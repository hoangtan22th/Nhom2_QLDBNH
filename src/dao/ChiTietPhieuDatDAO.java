package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<ChiTietPhieuDat> layChiTietPhieuDat(String maBan) {
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

	}






