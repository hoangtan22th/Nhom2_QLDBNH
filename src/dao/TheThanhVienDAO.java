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
import entity.TheThanhVien;

public class TheThanhVienDAO {
	
	public List<String> getTTVByKH(String maKH) {
	    List<String> TTV = new ArrayList<>();
	    String sql = "SELECT b.maTTV " +
	                 "FROM TheThanhVien b JOIN KhachHang k ON b.maTTV = k.maTTV " +
	                 "WHERE k.maKH = ?";

	    try (Connection con = connectDB.getConnection();
	         PreparedStatement pst = con.prepareStatement(sql)) {
	         
	        pst.setString(1, maKH);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            
	            TTV.add(tenKH);
	            TTV.add(sdt);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return TTV; 
	}
	public List<String> getTTVByLT(String maLT) {
	    List<String> TTV = new ArrayList<>();
	    String sql = "SELECT b.loaiThe " +
	                 "FROM TheThanhVien b JOIN LoaiThe k ON b.loaiThe = k.maLoaiTTV " +
	                 "WHERE k.maLoaiTTV = ?";

	    try (Connection con = connectDB.getConnection();
	         PreparedStatement pst = con.prepareStatement(sql)) {
	         
	        pst.setString(1, maLT);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            String tenLT = rs.getString("tenLoaiTTV");
	            
	            TTV.add(tenLT);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return TTV; 
	}
	
	
	public List<TheThanhVien> getAllTheThanhVien(){
		List<TheThanhVien> list = new ArrayList<TheThanhVien>();
		String sql = "SELECT \r\n"
				+ "    TheThanhVien.maTTV, \r\n"
				+ "    KhachHang.tenKH, \r\n"
				+ "    KhachHang.sdt, \r\n"
				+ "    LoaiThe.tenLoaiTTV, \r\n"
				+ "    TheThanhVien.diemTichLuy, \r\n"
				+ "    TheThanhVien.ngayDangKy\r\n"
				+ "FROM \r\n"
				+ "    TheThanhVien\r\n"
				+ "JOIN \r\n"
				+ "    KhachHang ON TheThanhVien.maTTV = KhachHang.maTTV\r\n"
				+ "JOIN \r\n"
				+ "    LoaiThe ON TheThanhVien.loaiThe = LoaiThe.maLoaiTTV;\r\n";
		try (Connection con = connectDB.getConnection();
				 Statement st = con.createStatement()) {        
             ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maThe = rs.getString("maTTV");
				String tenKH = rs.getString("tenKH");
				String sdt = rs.getString("sdt");
				KhachHang khachHang = new KhachHang(tenKH,sdt);
				String loaiThe = rs.getString("tenLoaiTTV");
				LoaiThe loaiThe2 = new LoaiThe(loaiThe);
				Double soDiem = rs.getDouble("diemTichLuy");
				LocalDateTime ngayDK = rs.getTimestamp("ngayDangKy") != null? rs.getTimestamp("ngayDangKy").toLocalDateTime():null;
				TheThanhVien theThanhVien = new TheThanhVien(maThe, khachHang, loaiThe2, soDiem, ngayDK);
				list.add(theThanhVien);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public List<TheThanhVien> timTTVTheoSDT(String Timsdt) {
		List<TheThanhVien> list = new ArrayList<TheThanhVien>();
		String sql = "SELECT \r\n"
				+ "    TheThanhVien.maTTV, \r\n"
				+ "    KhachHang.tenKH, \r\n"
				+ "    KhachHang.sdt, \r\n"
				+ "    LoaiThe.tenLoaiTTV, \r\n"
				+ "    TheThanhVien.diemTichLuy, \r\n"
				+ "    TheThanhVien.ngayDangKy\r\n"
				+ "FROM \r\n"
				+ "    TheThanhVien\r\n"
				+ "JOIN \r\n"
				+ "    KhachHang ON TheThanhVien.maTTV = KhachHang.maTTV\r\n"
				+ "JOIN \r\n"
				+ "    LoaiThe ON TheThanhVien.loaiThe = LoaiThe.maLoaiTTV\r\n"
				+ "WHERE \r\n"
				+ "    KhachHang.sdt LIKE N'%"+Timsdt+"%'";
		System.out.println(sql);
		try (Connection con = connectDB.getConnection();
				 Statement st = con.createStatement()) {        
            ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maThe = rs.getString("maTTV");
				String tenKH = rs.getString("tenKH");
				String sdt = rs.getString("sdt");
				KhachHang khachHang = new KhachHang(tenKH,sdt);
				String loaiThe = rs.getString("tenLoaiTTV");
				LoaiThe loaiThe2 = new LoaiThe(loaiThe);
				Double soDiem = rs.getDouble("diemTichLuy");
				LocalDateTime ngayDK = rs.getTimestamp("ngayDangKy") != null? rs.getTimestamp("ngayDangKy").toLocalDateTime():null;
				TheThanhVien theThanhVien = new TheThanhVien(maThe, khachHang, loaiThe2, soDiem, ngayDK);
				list.add(theThanhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean kiemTraKhachHangVaMaTTV(String sdt) {
	    String sql = "SELECT maKH, maTTV FROM KhachHang WHERE sdt = ?";
	    try (Connection con = connectDB.getConnection();
	         PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setString(1, sdt);
	        ResultSet rs = statement.executeQuery();
	        
	        if (rs.next()) {
	            String maTTV = rs.getString("maTTV");
	            return maTTV == null || maTTV.isEmpty();
	        }
	        return false;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean themTTV(TheThanhVien ttv) {
	    // Kiểm tra xem khách hàng có tồn tại và maTTV có null hay không
	    if (!kiemTraKhachHangVaMaTTV(ttv.getKhachHang().getSdt())) {
	        System.out.println("Khách hàng không tồn tại hoặc đã có thẻ thành viên");
	        return false;
	    }

	    Connection con = null;
	    PreparedStatement statement1 = null;
	    PreparedStatement statement2 = null;
	    try {
	        con = connectDB.getConnection();
	        con.setAutoCommit(false);

	        // Thêm mới vào bảng TheThanhVien
	        String sqlInsertTTV = "INSERT INTO TheThanhVien (maTTV, diemTichLuy, ngayDangKy, loaiThe) VALUES (?, ?, ?, ?)";
	        statement2 = con.prepareStatement(sqlInsertTTV);
	        statement2.setString(1, ttv.getMaTTV());
	        statement2.setDouble(2, ttv.getDiemTichLuy());
	        statement2.setDate(3, java.sql.Date.valueOf(ttv.getNgayDangKy().toLocalDate()));
	        statement2.setString(4, ttv.getLoaiThe().getMaLoaiTTV());

	        int rowsInserted = statement2.executeUpdate();
	        if (rowsInserted > 0) {
	            // Cập nhật maTTV vào bảng KhachHang
	            String sqlUpdateKhachHang = "UPDATE KhachHang SET maTTV = ? WHERE sdt = ?";
	            statement1 = con.prepareStatement(sqlUpdateKhachHang);
	            statement1.setString(1, ttv.getMaTTV());
	            statement1.setString(2, ttv.getKhachHang().getSdt());
	            int rowsUpdated = statement1.executeUpdate();
	            if (rowsUpdated > 0) {
	                con.commit();
	                return true;
	            } else {
	                con.rollback(); 
	                return false;
	            }
	        } else {
	            con.rollback();
	            return false;
	        }
	    } catch (SQLException e) {
	        if (con != null) {
	            try {
	                con.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (statement1 != null) statement1.close();
	            if (statement2 != null) statement2.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	public boolean updateTTV(TheThanhVien ttv) {
	    String sqlUpdateTheThanhVien = "UPDATE TheThanhVien "
	                                + "SET ngayDangKy = ?, loaiThe = ?, diemTichLuy = ? "
	                                + "WHERE maTTV = ?";
	    
	    String sqlUpdateKhachHang = "UPDATE KhachHang "
	                              + "SET tenKH = ?, sdt = ? "
	                              + "WHERE maTTV = ?";
	    Connection con = connectDB.getConnection();
	    try {
	        con.setAutoCommit(false);

	        // Cập nhật bảng TheThanhVien
	        try (PreparedStatement stmtTheThanhVien = con.prepareStatement(sqlUpdateTheThanhVien)) {
	            stmtTheThanhVien.setDate(1, java.sql.Date.valueOf(ttv.getNgayDangKy().toLocalDate()));  
	            stmtTheThanhVien.setString(2, ttv.getLoaiThe().getMaLoaiTTV());           
	            stmtTheThanhVien.setDouble(3, ttv.getDiemTichLuy());                    
	            stmtTheThanhVien.setString(4, ttv.getMaTTV());                            

	            stmtTheThanhVien.executeUpdate();
	        }

	        // Cập nhật bảng KhachHang
	        try (PreparedStatement stmtKhachHang = con.prepareStatement(sqlUpdateKhachHang)) {
	            stmtKhachHang.setString(1, ttv.getKhachHang().getTenKH());   
	            stmtKhachHang.setString(2, ttv.getKhachHang().getSdt());     
	            stmtKhachHang.setString(3, ttv.getMaTTV());                  

	            stmtKhachHang.executeUpdate();
	        }
	        con.commit();
	        
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            con.rollback(); 
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return false;
	}
	public String generateMaTTV() {
	    String maTTV = null;
	    String sql = "SELECT MAX(CAST(SUBSTRING(maTTV, 4, LEN(maTTV) - 3) AS INT)) AS maxMa FROM TheThanhVien";

	    try (Connection con = connectDB.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            int maxMa = rs.getInt("maxMa");
	            if (maxMa > 0) {
	                maTTV = String.format("TTV%05d", maxMa + 1);
	            } else {
	                maTTV = "TTV00001";
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return maTTV;
	}

	

}
