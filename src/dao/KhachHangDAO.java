package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.KhachHang;

public class KhachHangDAO {


    // Method to add a new customer
    public boolean themKhachHang(KhachHang kh) {
        String sql = "INSERT INTO KhachHang (maKH, tenKH, ngaySinh, sdt) VALUES (?, ?, ?, ?)";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, kh.getMaKH());
            pst.setString(2, kh.getTenKH());
            pst.setDate(3, Date.valueOf(kh.getNgaySinh()));
            pst.setString(4, kh.getSdt());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update a customer
    public boolean capNhatKhachHang(KhachHang kh) {
        String sql = "UPDATE KhachHang SET tenKH = ?, ngaySinh = ?, sdt = ? WHERE maKH = ?";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, kh.getTenKH());
            pst.setDate(2, Date.valueOf(kh.getNgaySinh()));
            pst.setString(3, kh.getSdt());
            pst.setString(4, kh.getMaKH());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a customer
    public boolean xoaKhachHang(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE maKH = ?";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maKH);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all customers
    public List<KhachHang> layTatCaKhachHang() {
        List<KhachHang> danhSachKH = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection con = connectDB.getConnection(); 
             Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
                String sdt = rs.getString("sdt");
                danhSachKH.add(new KhachHang(maKH, tenKH, ngaySinh, sdt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }

    // Method to find a customer by ID
    public KhachHang timKiemKhachHang(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE maKH = ?";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maKH);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String tenKH = rs.getString("tenKH");
                LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
                String sdt = rs.getString("sdt");
                return new KhachHang(maKH, tenKH, ngaySinh, sdt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to output the first customer
    public void xuatKhachHangDauTien() {
        KhachHang khDauTien = null;
        try {
            Connection con = connectDB.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT TOP 1 maKH, tenKH, ngaySinh, sdt FROM KhachHang ORDER BY maKH ASC";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {                
                String maKH = rs.getString("maKH");   
                String tenKH = rs.getString("tenKH");    
                Date ngaySinh = rs.getDate("ngaySinh");   
                String sdt = rs.getString("sdt");  
                
                System.out.println("Khách hàng đầu tiên:");
                System.out.println("maKH: " + maKH);
                System.out.println("tenKH: " + tenKH);
                System.out.println("ngaySinh: " + ngaySinh);
                System.out.println("sdt: " + sdt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	
}
