package dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import connectDB.connectDB;
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
	    String sql = "INSERT INTO PhieuDatBan (maPhieuDat, tenKhachDat, soLuongKhach, ngayDat, ghiChu, maNV) VALUES (?, ?, ?, ?, ?, ?)";
	    
	    try {
	        connection = connectDB.getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        
	        ps.setString(1, phieuDat.getMaPhieuDat());
	        ps.setString(2, phieuDat.getTenKhachDat());
	        ps.setInt(3, phieuDat.getSoLuongKhach());
	        ps.setTimestamp(4, java.sql.Timestamp.valueOf(phieuDat.getNgayDat()));
	        ps.setString(5, phieuDat.getGhiChu());
	        ps.setString(6, phieuDat.getNhanVien().getMaNV() );

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
	                LocalDateTime ngayDat = rs.getTimestamp("ngayDat").toLocalDateTime();
	                String ghiChu = rs.getString("ghiChu");
	                NhanVien nhanVien = null; // Bạn cần lấy thông tin nhân viên nếu có

	                // Tạo đối tượng PhieuDatBan
	                phieuDatBan = new PhieuDatBan(maPhieuDat, tenKhachDat, soLuongKhach, ngayDat, ghiChu, nhanVien);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return phieuDatBan; // Trả về đối tượng PhieuDatBan hoặc null nếu không tìm thấy
	}



}
