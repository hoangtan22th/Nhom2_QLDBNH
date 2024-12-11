package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.connectDB;
import entity.Ban;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thue;

public class HoaDonDAO {

	public boolean themHoaDon(HoaDon hoaDon) {

		hoaDon.setMaHoaDon(generateMaHoaDon());

		String sql = "INSERT INTO HoaDon (maHoaDon, maNV, maKH, ngayLap, maThue, maBan, thanhTien, tongTien, trangThai) "
				+ "VALUES (?, ?, ?, GETDATE(), ?, ?, ?, ?, ?)";

		try (Connection con = connectDB.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, hoaDon.getMaHoaDon());
			pst.setString(2, hoaDon.getNhanVien().getMaNV());
			pst.setString(3, hoaDon.getKhachHang().getMaKH());
			pst.setString(4, hoaDon.getThue().getMaThue());
			pst.setString(5, hoaDon.getBan().getMaBan());
			pst.setDouble(6, hoaDon.getThanhTien());
			pst.setDouble(7, hoaDon.getTongTien());
			pst.setBoolean(8, hoaDon.isTrangThai());

			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String generateMaHoaDon() {
		String maHoaDon = "HD00001";

		String sql = "SELECT TOP 1 maHoaDon FROM HoaDon ORDER BY maHoaDon DESC";

		try (Connection con = connectDB.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			if (rs.next()) {

				String lastMaHoaDon = rs.getString("maHoaDon");

				int lastNumber = Integer.parseInt(lastMaHoaDon.substring(2));

				int newNumber = lastNumber + 1;

				maHoaDon = "HD" + String.format("%05d", newNumber);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maHoaDon;
	}
	public HoaDon getHoaDonByMaBan(String maBan) {
	    Connection con = connectDB.getConnection();
	    HoaDon hoaDon = null; 
	    String sql = "SELECT maHoaDon, maNV, maKH, ngayLap, maThue, maBan, thanhTien, tongTien, trangThai " +
	                 "FROM HoaDon WHERE maBan = ?";
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, maBan); 	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            hoaDon = new HoaDon();
	            hoaDon.setMaHoaDon(rs.getString("maHoaDon"));

	            // Lấy thông tin Nhân viên từ cơ sở dữ liệu
	            String maNV = rs.getString("maNV");
	            if (maNV != null) {
	                hoaDon.setNhanVien(new NhanVien(maNV));
	            } else {
	                hoaDon.setNhanVien(new NhanVien("admin")); // Mặc định nếu không có thông tin
	            }

	            // Lấy thông tin Khách hàng từ cơ sở dữ liệu
	            String maKH = rs.getString("maKH");
	            if (maKH != null) {
	                hoaDon.setKhachHang(new KhachHang(maKH));
	            }

	            // Xử lý ngày lập hóa đơn
	            java.sql.Date ngayLap = rs.getDate("ngayLap");
	            if (ngayLap != null) {
	                hoaDon.setNgayLapHoaDon(ngayLap.toLocalDate());
	            }

	            // Lấy thông tin Thuế từ cơ sở dữ liệu
	            String maThue = rs.getString("maThue");
	            if (maThue != null) {
	                hoaDon.setThue(new Thue(maThue));
	            }

	            // Khởi tạo Ban nếu chưa có
	            if (hoaDon.getBan() == null) {
	                hoaDon.setBan(new Ban());  // Khởi tạo nếu đối tượng Ban chưa có
	            }
	            hoaDon.getBan().setMaBan(rs.getString("maBan"));

	            // Lấy các thông tin còn lại từ cơ sở dữ liệu
	            hoaDon.setThanhTien(rs.getInt("thanhTien"));
	            hoaDon.setTongTien(rs.getInt("tongTien"));
	            hoaDon.setTrangThai(rs.getBoolean("trangThai"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        connectDB.closeConnection(con); 
	    }

	    return hoaDon; 
	}
	public boolean kiemTraHoaDonTontai(String maBan) {
	    Connection con = connectDB.getConnection();
	    String sql = "SELECT COUNT(*) FROM HoaDon WHERE maBan = ? AND trangThai = 0"; 
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, maBan); 
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        connectDB.closeConnection(con); // Đảm bảo đóng kết nối sau khi sử dụng
	    }
	    return false; // Nếu không có hoá đơn nào tồn tại với mã bàn và trạng thái 0
	}
	public boolean setTrangThaiHoaDon(String maHoaDon, boolean b) {
	    Connection con = connectDB.getConnection();
	    String sql = "UPDATE HoaDon SET trangThai = ? WHERE maHoaDon = ?"; // Cập nhật trạng thái cho hóa đơn có mã tương ứng
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setBoolean(1, b); 
	        ps.setString(2, maHoaDon); 
	        int rowsAffected = ps.executeUpdate();

	    
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        connectDB.closeConnection(con); 
	    }
	    return false; 
	}


}
