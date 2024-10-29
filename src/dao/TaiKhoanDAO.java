package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.KhachHang;
import entity.LoaiThe;
import entity.TaiKhoan;
import entity.TheThanhVien;

public class TaiKhoanDAO {
    
//    public boolean kiemTraTaiKhoan(String taiKhoan, String matKhau) {     
//        try {
//            Connection con = connectDB.getConnection();
//            Statement st = con.createStatement();
//            String sql = "SELECT taiKhoan, matKhau FROM TaiKhoan WHERE taiKhoan = '" + taiKhoan + "' AND matKhau = '" + matKhau + "'";
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//            	return true;
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        return false;
//    }
	public int kiemTraTaiKhoan(String taiKhoan, String matKhau) {
	    int role = -1; // Giá trị -1 là không tìm thấy
	    try {
	        Connection con = connectDB.getConnection();
	        Statement st = con.createStatement();
	        String sql = "SELECT role FROM TaiKhoan WHERE taiKhoan = '" + taiKhoan + "' AND matKhau = '" + matKhau + "'";
	        ResultSet rs = st.executeQuery(sql);
	        if (rs.next()) {
	            role = rs.getInt("role"); // Trả về vai trò của người dùng
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return role;
	}

    public List<TaiKhoan> getAllTK(){
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		String sql = "select * from TaiKhoan";
		try (Connection con = connectDB.getConnection();
				 Statement st = con.createStatement()) {        
             ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String taiKhoan = rs.getString("taiKhoan");
				String matKhau = rs.getString("matKhau");
				Boolean role = rs.getBoolean("role");
				LocalDateTime ngayDK = rs.getTimestamp("ngayTaoTk") != null? rs.getTimestamp("ngayTaoTK").toLocalDateTime():null;
				TaiKhoan taiKhoan2 = new TaiKhoan(taiKhoan, matKhau, role, ngayDK);
				list.add(taiKhoan2);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
    public List<TaiKhoan> timTKbyMa(String maTK) {
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		String sql = "select * from TaiKhoan where taiKhoan like N'%"+maTK+"%'";
		System.out.println(sql);
		try (Connection con = connectDB.getConnection();
				 Statement st = con.createStatement()) {        
            ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String taiKhoan = rs.getString("taiKhoan");
				String matKhau = rs.getString("matKhau");
				Boolean role = rs.getBoolean("role");
				LocalDateTime ngayDK = rs.getTimestamp("ngayTaoTK") != null? rs.getTimestamp("ngayTaoTK").toLocalDateTime():null;
				TaiKhoan taiKhoan2 = new TaiKhoan(taiKhoan, matKhau, role, ngayDK);
				list.add(taiKhoan2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
    public boolean kiemNhanVien(String maNV) {
        String sql = "SELECT maNV FROM NhanVien WHERE maNV = ?";
        try (Connection con = connectDB.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, maNV);
            ResultSet rs = statement.executeQuery();
            // Kiểm tra nếu tìm thấy nhân viên
            if (rs.next()) {
                return true;  
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean themTK(TaiKhoan tk) {
        // Kiểm tra nếu nhân viên có mã nv đã tồn tại
        if (!kiemNhanVien(tk.getTaiKhoan())) {
            System.out.println("Nhân viên không tồn tại");
            return false;
        }
        
        String sql = "INSERT INTO TaiKhoan (taiKhoan, matKhau, role, ngayTaoTK) VALUES (?, ?, ?, ?)";
        try (Connection con = connectDB.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {   
            // Thực hiện câu lệnh insert vào bảng TaiKhoan
            statement.setString(1, tk.getTaiKhoan());
            statement.setString(2, tk.getMatKhau());
            // Chèn giá trị boolean vào cột role (0 cho nhân viên, 1 cho quản lý)
            statement.setBoolean(3, tk.isRole()); 
            statement.setDate(4, java.sql.Date.valueOf(tk.getNgayTaoTK().toLocalDate()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateTK(TaiKhoan tk) {
        String sql = "UPDATE TaiKhoan SET matKhau = ?, role = ?, ngayTaoTK = ? WHERE taiKhoan = ?";
        try (Connection con = connectDB.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, tk.getMatKhau());
            statement.setString(2, tk.isRole() ? "1" : "0");
            statement.setDate(3, java.sql.Date.valueOf(tk.getNgayTaoTK().toLocalDate()));
            statement.setString(4, tk.getTaiKhoan());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update successful!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
