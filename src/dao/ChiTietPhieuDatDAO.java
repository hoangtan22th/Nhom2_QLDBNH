package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.Ban;
import entity.ChiTietPhieuDat;
import entity.MonAnUong;
import entity.PhieuDatBan;

public class ChiTietPhieuDatDAO {
	public ChiTietPhieuDat layChiTietTheoPhieuVaMon(String maPhieuDat, String maMonAn) {
		  Connection con = connectDB.getConnection();
	    ChiTietPhieuDat chiTiet = null;
	    String query = "SELECT * FROM ChiTietPhieuDat WHERE MaPhieuDat = ? AND MaMonAnUong = ?";
	    
	    try (PreparedStatement ps = con.prepareStatement(query)) {
	        
	    	ps.setString(1, maPhieuDat);
	    	ps.setString(2, maMonAn);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            // Lấy thông tin chi tiết
	            int soLuong = rs.getInt("SoLuong");
	            String maBan = rs.getString("MaBan");
	            Ban ban = new Ban(maBan);
	            MonAnUong monAn = new MonAnUong(maMonAn);  // Lấy các thuộc tính nếu cần
	            PhieuDatBan phieuDat = new PhieuDatBan(maPhieuDat);
	            
	            chiTiet = new ChiTietPhieuDat(soLuong, monAn, phieuDat, ban);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return chiTiet;
	}
	public boolean capNhatChiTiet(ChiTietPhieuDat chiTiet) {
		  Connection con = connectDB.getConnection();
	    String query = "UPDATE ChiTietPhieuDat SET SoLuong = ? WHERE MaPhieuDat = ? AND MaMonAnUong = ?";
	    int rowsAffected = 0;
	    
	    try (PreparedStatement ps = con.prepareStatement(query))  {
	        
	    	ps.setInt(1, chiTiet.getSoLuong());
	    	ps.setString(2, chiTiet.getPhieuDatBan().getMaPhieuDat());
	    	ps.setString(3, chiTiet.getMonAnUong().getMaMonAnUong());
	        
	        rowsAffected = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rowsAffected > 0;
	}
//	public boolean themChiTietPhieuDat1(ChiTietPhieuDat chiTiet) {
//		  Connection con = connectDB.getConnection();
//	    String query = "INSERT INTO ChiTietPhieuDat (MaPhieuDat, MaMonAnUong, MaBan, SoLuong) VALUES (?, ?, ?, ?)";
//	    int rowsAffected = 0;
//	    
//	    try (PreparedStatement ps = con.prepareStatement(query))  {
//	        
//	    	ps.setString(1, chiTiet.getPhieuDatBan().getMaPhieuDat());
//	    	ps.setString(2, chiTiet.getMonAnUong().getMaMonAnUong());
//	    	ps.setString(3, chiTiet.getBan().getMaBan());
//	    	ps.setInt(4, chiTiet.getSoLuong());
//	        
//	        rowsAffected = ps.executeUpdate();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return rowsAffected > 0;
//	}

	public boolean themChiTietPhieuDat(ChiTietPhieuDat chiTiet) {
	    Connection con = connectDB.getConnection();
	    String sql = "INSERT INTO ChiTietPhieuDat (maPhieuDat, maMonAnUong, soLuong, maBan) VALUES (?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, chiTiet.getPhieuDatBan().getMaPhieuDat()); 
	        if (chiTiet.getMonAnUong() != null) {
	            ps.setString(2, chiTiet.getMonAnUong().getMaMonAnUong());
	        } else {
	            ps.setString(2, null); 
	        }

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
	    String query = "SELECT ctpd.soLuong, ctpd.maMonAnUong " +
	                   "FROM ChiTietPhieuDat ctpd " +
	                   "JOIN PhieuDatBan pdb ON ctpd.maPhieuDat = pdb.maPhieuDat " +
	                   "WHERE ctpd.maBan = ? AND pdb.trangThai = 1";

	    try (Connection con = connectDB.getConnection(); 
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, maBan);

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int soLuong = rs.getInt("soLuong");
	                String maMonAn = rs.getString("maMonAnUong");
	                MonAnUongDAO maud = new MonAnUongDAO();
	                MonAnUong monAnUong = maud.layMonAnUong(maMonAn);
	                chiTietList.add(new ChiTietPhieuDat(soLuong, monAnUong, null, null));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return chiTietList;
	}


//	public List<ChiTietPhieuDat> layChiTietPhieuDat(String maBan) {
//	    List<ChiTietPhieuDat> chiTietList = new ArrayList<>();
//	    String query = "SELECT ctpd.soLuong, ctpd.maMonAnUong, pdb.ngayDat, pdb.soLuongKhach " +
//	                   "FROM ChiTietPhieuDat ctpd " +
//	                   "JOIN PhieuDatBan pdb ON ctpd.maPhieuDat = pdb.maPhieuDat " +
//	                
//	                   "WHERE ctpd.maBan = ? AND pdb.trangThai = 1";
//
//	    try (Connection con = connectDB.getConnection(); 
//	         PreparedStatement stmt = con.prepareStatement(query)) {
//	        stmt.setString(1, maBan);
//
//	        try (ResultSet rs = stmt.executeQuery()) {
//	            while (rs.next()) {
//	                int soLuong = rs.getInt("soLuong");
//	                String maMonAn = rs.getString("maMonAnUong");
//	                LocalDateTime thoiGianDen = rs.getTimestamp("ngayDat").toLocalDateTime();
//	     
//	                int soLuongKhach = rs.getInt("soLuongKhach");
//
//	                MonAnUongDAO maud = new MonAnUongDAO();
//	                MonAnUong monAnUong = maud.layMonAnUong(maMonAn);
//	                ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(soLuong, monAnUong, thoiGianDen, soLuongKhach);
//	                
//	                chiTietList.add(chiTiet);
//	            }
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//
//	    return chiTietList;
//	}

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






