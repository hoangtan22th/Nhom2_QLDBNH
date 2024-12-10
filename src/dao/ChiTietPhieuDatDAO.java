package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.Ban;
import entity.ChiTietPhieuDat;
import entity.MonAnUong;
import entity.PhieuDatBan;

public class ChiTietPhieuDatDAO {
	public boolean themChiTietPhieuDat(ChiTietPhieuDat chiTiet) {
	    Connection con = connectDB.getConnection();
	    String sql = "INSERT INTO ChiTietPhieuDat (maPhieuDat, maMonAnUong, soLuong, maBan) VALUES (?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, chiTiet.getPhieuDatBan().getMaPhieuDat()); 
	        ps.setString(2, chiTiet.getMonAnUong().getMaMonAnUong()); 
	        ps.setInt(3, chiTiet.getSoLuong()); 
	        ps.setString(4, chiTiet.getBan().getMaBan()); 

	        return ps.executeUpdate() > 0; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        connectDB.closeConnection(con);
	    }
	    return false; 
	}
	public List<ChiTietPhieuDat> layAllChiTietPhieuDat(String maBan) {
	    List<ChiTietPhieuDat> chiTietList = new ArrayList<>();
	    String query = "SELECT soLuong, maMonAnUong FROM ChiTietPhieuDat WHERE maBan = ?";

	    try (Connection con = connectDB.getConnection(); 
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        
	        stmt.setString(1, maBan);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int soLuong = rs.getInt("soLuong");
	                String maMonAn = rs.getString("maMonAnUong");

	                
	                MonAnUongDAO maud= new MonAnUongDAO();
	                MonAnUong monAnUong = maud.layMonAnUong(maMonAn); 

	           
	                chiTietList.add(new ChiTietPhieuDat(soLuong, monAnUong,null,null)); 
	        }}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return chiTietList;
	}
	public List<ChiTietPhieuDat> layChiTietPhieuDat(String maBan) {
	    List<ChiTietPhieuDat> chiTietList = new ArrayList<>();
	    // Truy vấn lấy chi tiết phiếu đặt từ bảng ChiTietPhieuDat khi trạng thái phiếu đặt = 1
	    String query = "SELECT ctpd.soLuong, ctpd.maMonAnUong " +
	                   "FROM ChiTietPhieuDat ctpd " +
	                   "JOIN PhieuDatBan pdb ON ctpd.maPhieuDat = pdb.maPhieuDat " +
	                   "WHERE ctpd.maBan = ? AND pdb.trangThai = 1";

	    try (Connection con = connectDB.getConnection(); 
	         PreparedStatement stmt = con.prepareStatement(query)) {

	        // Set giá trị mã bàn vào truy vấn
	        stmt.setString(1, maBan);

	        try (ResultSet rs = stmt.executeQuery()) {
	            // Duyệt qua kết quả trả về và thêm chi tiết vào danh sách
	            while (rs.next()) {
	                int soLuong = rs.getInt("soLuong");
	                String maMonAn = rs.getString("maMonAnUong");

	                // Lấy chi tiết món ăn từ DAO
	                MonAnUongDAO maud = new MonAnUongDAO();
	                MonAnUong monAnUong = maud.layMonAnUong(maMonAn);

	                // Thêm vào danh sách kết quả
	                chiTietList.add(new ChiTietPhieuDat(soLuong, monAnUong, null, null));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return chiTietList;
	}


	  public List<ChiTietPhieuDat> layTatCaChiTietPhieuDat_Join() {
		  List<ChiTietPhieuDat> chiTietPhieuDatList = new ArrayList<>();
		    
		    // Câu truy vấn SQL để lấy thông tin từ bảng ChiTietPhieuDat và kết hợp với các bảng khác
		    String sql = "SELECT TOP (1000) " +
		                 "ctd.maPhieuDat, ctd.maBan, pd.soDienThoai, pd.tenKhachDat, pd.ngayDat, pd.trangThai, pd.tienCoc, " +
		                 "b.tenBan " +
		                 "FROM QuanLyDatBanNhaHang.dbo.ChiTietPhieuDat ctd " +
		                 "JOIN QuanLyDatBanNhaHang.dbo.PhieuDatBan pd ON ctd.maPhieuDat = pd.maPhieuDat " +
		                 "JOIN QuanLyDatBanNhaHang.dbo.Ban b ON ctd.maBan = b.maBan";

		    try (Connection connection = connectDB.getConnection();
		         Statement statement = connection.createStatement();
		         ResultSet resultSet = statement.executeQuery(sql)) {

		        while (resultSet.next()) {
		
		            String maPhieuDat = resultSet.getString("maPhieuDat");
		            String maBan = resultSet.getString("maBan");
		            String soDienThoai = resultSet.getString("soDienThoai");
		            String tenKhachDat = resultSet.getString("tenKhachDat");
		            Timestamp ngayDat = resultSet.getTimestamp("ngayDat");
		            Boolean trangThai = resultSet.getBoolean("trangThai");
		            float tienCoc = resultSet.getFloat("tienCoc");
		            String tenBan = resultSet.getString("tenBan");

		            PhieuDatBan phieuDatBan = new PhieuDatBan(maPhieuDat, tenKhachDat, 0, ngayDat, "", tienCoc, soDienThoai, trangThai, null);  
		            Ban ban = new Ban(maBan, tenBan, null, 0, false, false, null); 

		          
		            ChiTietPhieuDat chiTietPhieuDat = new ChiTietPhieuDat(0, null, phieuDatBan, ban);

		            chiTietPhieuDatList.add(chiTietPhieuDat);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return chiTietPhieuDatList;
	    }
	
	}






