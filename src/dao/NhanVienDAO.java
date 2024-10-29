package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.NhanVien;

public class NhanVienDAO {



    // Method to add a new employee
    public boolean themNhanVien(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (maNV, tenNV, diaChi, sdt, ngaySinh, ngayVaoLam, gmail, chucVu, luongCB) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nv.getMaNV());
            pst.setString(2, nv.getTenNV());
            pst.setString(3, nv.getDiaChi());
            pst.setString(4, nv.getSdt());
            pst.setDate(5, java.sql.Date.valueOf(nv.getNgaySinh()));
            pst.setDate(6, java.sql.Date.valueOf(nv.getNgayVaoLam()));
            pst.setString(7, nv.getGmail());
            pst.setBoolean(8, nv.isChucVu());
            pst.setDouble(9, nv.getLuongCB());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get an employee by ID
    public NhanVien layNhanVien(String maNV) {
        String sql = "SELECT * FROM NhanVien WHERE maNV = ?";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maNV);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new NhanVien(
                    rs.getString("maNV"),
                    rs.getString("tenNV"),
                    rs.getString("diaChi"),
                    rs.getString("sdt"),
                    rs.getDate("ngaySinh").toLocalDate(),
                    rs.getDate("ngayVaoLam").toLocalDate(),
                    rs.getString("gmail"),
                    rs.getBoolean("chucVu"),
                    rs.getFloat("luongCB")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to search for an employee by ID
    public NhanVien timKiemNhanVien(String maNV) {
        return layNhanVien(maNV);
    }

    // Method to update an employee
    public boolean capNhatNhanVien(NhanVien nv) {
        String sql = "UPDATE NhanVien SET tenNV = ?, diaChi = ?, sdt = ?, ngaySinh = ?, ngayVaoLam = ?, gmail = ?, chucVu = ?, luongCB = ? WHERE maNV = ?";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nv.getTenNV());
            pst.setString(2, nv.getDiaChi());
            pst.setString(3, nv.getSdt());
            pst.setDate(4, java.sql.Date.valueOf(nv.getNgaySinh()));
            pst.setDate(5, java.sql.Date.valueOf(nv.getNgayVaoLam()));
            pst.setString(6, nv.getGmail());
            pst.setBoolean(7, nv.isChucVu());
            pst.setDouble(8, nv.getLuongCB());
            pst.setString(9, nv.getMaNV());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete an employee
    public boolean xoaNhanVien(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE maNV = ?";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maNV);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all employees
    public List<NhanVien> layTatCaNhanVien() {
        List<NhanVien> danhSachNV = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (Connection con = connectDB.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql); 
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                danhSachNV.add(new NhanVien(
                    rs.getString("maNV"),
                    rs.getString("tenNV"),
                    rs.getString("diaChi"),
                    rs.getString("sdt"),
                    rs.getDate("ngaySinh").toLocalDate(),
                    rs.getDate("ngayVaoLam").toLocalDate(),
                    rs.getString("gmail"),
                    rs.getBoolean("chucVu"),
                    rs.getFloat("luongCB")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNV;
    }




}
