package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.KhuVucBan;

public class KhuVucBanDAO {
	public List<KhuVucBan> getAllKhuVucBan() {
	    List<KhuVucBan> khuVucBans = new ArrayList<>();    
	    try {
	        Connection con = connectDB.getConnection();
	        Statement st = con.createStatement();
	        String sql = "SELECT * FROM KhuVucBan"; 
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next()) {
	            String maKhu = rs.getString("maKhu");
	            String tenKhu = rs.getString("tenKhu");
	            int soBan = rs.getInt("soBan");
	            khuVucBans.add(new KhuVucBan(maKhu, tenKhu, soBan));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return khuVucBans;
	}
	 public List<String> getAllTenKhuVucBan() {
	        List<String> tenKhuVucBans = new ArrayList<>();

	        try (Connection con = connectDB.getConnection();
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery("SELECT tenKhu FROM KhuVucBan")) {

	            while (rs.next()) {
	                String tenKhu = rs.getString("tenKhu");
	                tenKhuVucBans.add(tenKhu);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return tenKhuVucBans;
	    }
	
}
