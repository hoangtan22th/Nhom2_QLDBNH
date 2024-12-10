package dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.Ban;
import entity.ChiTietPhieuDat;
import entity.MonAnUong;
import entity.NhanVien;
import entity.PhieuDatBan;

public class PhieuDatBanDAO {
	public String phatSinhMaPhieuDatMoi() {
	    Connection connection = null;
	    String maPhieuDatCuoi = null;
	    String sql = "SELECT TOP 1 maPhieuDat FROM PhieuDatBan ORDER BY maPhieuDat DESC";
	    
	    try {
	        connection = connectDB.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            maPhieuDatCuoi = rs.getString("MaPhieuDat");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        connectDB.closeConnection(connection);
	    }

	    if (maPhieuDatCuoi != null) {
	        int soPhieuCuoi = Integer.parseInt(maPhieuDatCuoi.substring(2)); // Bỏ phần "PD" và lấy phần số
	        soPhieuCuoi++;  // Tăng số thứ tự lên 1
	        return String.format("PD%05d", soPhieuCuoi);  // Tạo mã mới với định dạng "PDxxxxx"
	    } else {
	        return "PD00001";  // Nếu chưa có phiếu đặt nào, bắt đầu từ PD00001
	    }
	}
	public boolean themPhieuDat(PhieuDatBan phieuDat) {
	    Connection connection = null;
	    String sql = "INSERT INTO PhieuDatBan (maPhieuDat, tenKhachDat, soLuongKhach, ngayDat, ghiChu,tienCoc,trangThai, maNV,soDienThoai) VALUES (?, ?,?, ?,?, ?, ?, ?,?)";
	    
	    try {
	        connection = connectDB.getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        
	        ps.setString(1, phieuDat.getMaPhieuDat());
	        ps.setString(2, phieuDat.getTenKhachDat());
	        ps.setInt(3, phieuDat.getSoLuongKhach());
	        ps.setTimestamp(4, phieuDat.getNgayDat());
	        ps.setString(5, phieuDat.getGhiChu());
	        ps.setFloat(6, phieuDat.getTienCoc());
	        ps.setBoolean(7, false);
	        ps.setString(8, phieuDat.getNhanVien().getMaNV() );
	        ps.setString(9, phieuDat.getSoDienThoai());
	        int result = ps.executeUpdate();
	        return result > 0; // Trả về true nếu thêm thành công
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Trả về false nếu có lỗi
	    } finally {
	        connectDB.closeConnection(connection);
	    }
	}
	public PhieuDatBan layPhieuDatBan(String maPhieuDat) {
	    PhieuDatBan phieuDatBan = null; // Khởi tạo biến lưu trữ thông tin phiếu đặt
	    String query = "SELECT * FROM PhieuDatBan WHERE maPhieuDat = ?"; // Truy vấn SQL

	    try (Connection con = connectDB.getConnection(); 
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        
	        stmt.setString(1, maPhieuDat); // Thiết lập tham số cho câu truy vấn
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                // Lấy thông tin từ ResultSet
	                String tenKhachDat = rs.getString("tenKhachDat");
	                int soLuongKhach = rs.getInt("soLuongKhach");
	                java.sql.Timestamp ngayDat = rs.getTimestamp("ngayDat");
	                String ghiChu = rs.getString("ghiChu");
	                Float tienCoc = rs.getFloat("tienCoc");
	                Boolean trangThai = rs.getBoolean("trangThai");
	                String soDienThoai = rs.getString("soDienThoai");
	                NhanVien nhanVien = null; 
	                phieuDatBan = new PhieuDatBan(maPhieuDat, tenKhachDat, soLuongKhach, ngayDat, ghiChu,tienCoc,soDienThoai,trangThai, nhanVien);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return phieuDatBan;
	}
	public List<Object[]> layTatCaPhieuDatBan() {
        List<Object[]> result = new ArrayList<>();
        String sql = "SELECT DISTINCT pd.maPhieuDat, pd.tenKhachDat, pd.ngayDat, pd.ghiChu, pd.tienCoc, pd.trangThai, pd.soDienThoai, " +
                "b.maBan, b.tenBan " +
                "FROM QuanLyDatBanNhaHang.dbo.PhieuDatBan pd " +
                "LEFT JOIN QuanLyDatBanNhaHang.dbo.ChiTietPhieuDat ct ON pd.maPhieuDat = ct.maPhieuDat " +
                "LEFT JOIN QuanLyDatBanNhaHang.dbo.Ban b ON ct.maBan = b.maBan " +
                "ORDER BY pd.ngayDat DESC";  

        try ( Connection con = connectDB.getConnection();
    	        Statement stmt = con.createStatement();
    	        ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String maPhieuDat = rs.getString("maPhieuDat");
                String tenKhachDat = rs.getString("tenKhachDat");
                java.sql.Timestamp ngayDat = rs.getTimestamp("ngayDat");
                String ghiChu = rs.getString("ghiChu");
                float tienCoc = rs.getFloat("tienCoc");
                boolean trangThai = rs.getBoolean("trangThai");
                String soDienThoai = rs.getString("soDienThoai");
                String maBan = rs.getString("maBan");
                String tenBan = rs.getString("tenBan");

                // Tạo đối tượng PhieuDatBan và Ban
                PhieuDatBan phieuDatBan = new PhieuDatBan(maPhieuDat, tenKhachDat, 0, ngayDat, ghiChu, tienCoc, soDienThoai, trangThai, null);
      
                Ban ban = new Ban(maBan, tenBan, null, 0, trangThai, trangThai, null);

                // Thêm vào kết quả
                result.add(new Object[]{phieuDatBan, ban});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
	 
    public boolean setTrangThai(String maPhieuDat, boolean trangThai) {
        String sql = "UPDATE PhieuDatBan SET trangThai = ? WHERE maPhieuDat = ?";

        try (Connection con = connectDB.getConnection(); 
   	         PreparedStatement stmt = con.prepareStatement(sql)){
        	
            stmt.setBoolean(1, trangThai);
            stmt.setString(2, maPhieuDat);     

  
            int rowsUpdated = stmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
