package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connectDB.connectDB;
import entity.ChiTietHoaDon;
import entity.MonAnUong;

public class ChiTietHoaDonDAO {
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTiet) {
	    Connection con = connectDB.getConnection();
	    String sql = "INSERT INTO ChiTietHoaDon (maHoaDon, maMonAnUong, soLuongMonAn) VALUES (?, ?, ?)";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        
	        // Lấy thông tin từ đối tượng ChiTietHoaDon
	        ps.setString(1, chiTiet.getHoaDon().getMaHoaDon()); // Mã hóa đơn
	        ps.setString(2, chiTiet.getMonAnUong().getMaMonAnUong()); // Mã món ăn
	        ps.setInt(3, chiTiet.getSoLuongMonAn()); // Số lượng món ăn
	        
	        // Thực thi câu lệnh SQL
	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        connectDB.closeConnection(con); // Đóng kết nối sau khi thực thi
	    }
	    return false; // Trả về false nếu có lỗi xảy ra
	}


}
