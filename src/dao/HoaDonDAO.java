package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;

public class HoaDonDAO {

    private Connection connection;

    public HoaDonDAO() {
        connection = connectDB.getConnection();
    }

    /**
     * Lấy danh sách tất cả hóa đơn.
     * @return ResultSet chứa danh sách các hóa đơn.
     */
    public ResultSet getAllHoaDon() {
        String sql = "SELECT * FROM HoaDon";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Thêm một hóa đơn mới vào cơ sở dữ liệu.
     * @param maNV - mã nhân viên
     * @param maKH - mã khách hàng
     * @param ngayLap - ngày lập hóa đơn
     * @param maThue - mã thuế
     * @return true nếu thêm thành công, false nếu thất bại.
     */
    public boolean addHoaDon(int maNV, int maKH, String ngayLap, int maThue) {
        String sql = "INSERT INTO HoaDon (maNV, maKH, ngayLap, maThue) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maNV);
            stmt.setInt(2, maKH);
            stmt.setString(3, ngayLap);
            stmt.setInt(4, maThue);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Cập nhật thông tin của một hóa đơn.
     * @param maHoaDon - mã hóa đơn
     * @param maNV - mã nhân viên
     * @param maKH - mã khách hàng
     * @param ngayLap - ngày lập hóa đơn
     * @param maThue - mã thuế
     * @return true nếu cập nhật thành công, false nếu thất bại.
     */
    public boolean updateHoaDon(int maHoaDon, int maNV, int maKH, String ngayLap, int maThue) {
        String sql = "UPDATE HoaDon SET maNV = ?, maKH = ?, ngayLap = ?, maThue = ? WHERE maHoaDon = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maNV);
            stmt.setInt(2, maKH);
            stmt.setString(3, ngayLap);
            stmt.setInt(4, maThue);
            stmt.setInt(5, maHoaDon);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa một hóa đơn.
     * @param maHoaDon - mã hóa đơn cần xóa
     * @return true nếu xóa thành công, false nếu thất bại.
     */
    public boolean deleteHoaDon(int maHoaDon) {
        String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maHoaDon);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**+
     * Lọc và tìm món ăn bán nhiều nhất trong khoảng thời gian cho trước.
     * @param ngayBatDau - ngày bắt đầu
     * @param ngayKetThuc - ngày kết thúc
     * @return tên món ăn bán chạy nhất trong thời gian cho trước.
     */
    /**
     * Lọc và tìm món ăn bán nhiều nhất trong khoảng thời gian cho trước.
     * @param ngayBatDau - ngày bắt đầu
     * @param ngayKetThuc - ngày kết thúc
     * @return tên món ăn bán chạy nhất trong thời gian cho trước.
     */
    public List<String> findTopSellingDishes(String ngayBatDau, String ngayKetThuc) {
        String sql = """
            SELECT TOP 10 maMonAnUong, SUM(soLuongMonAN) AS tongSoLuong
            FROM ChiTietHoaDon
            JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
            WHERE HoaDon.ngayLap BETWEEN ? AND ?
            GROUP BY maMonAnUong
            ORDER BY tongSoLuong DESC
        """;

        List<String> topDishes = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Chuyển đổi ngày từ chuỗi sang định dạng SQL
            stmt.setDate(1, java.sql.Date.valueOf(ngayBatDau.trim()));
            stmt.setDate(2, java.sql.Date.valueOf(ngayKetThuc.trim()));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String maMonAnUong = rs.getString("maMonAnUong");
                    int tongSoLuong = rs.getInt("tongSoLuong");

                    // Lấy tên món ăn từ mã
                    String tenMonAnUong = getDishNameById(maMonAnUong);

                    if (tenMonAnUong != null) {
                        topDishes.add(tenMonAnUong + " (Số lượng: " + tongSoLuong + ")");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topDishes;
    }



    /**
     * Lấy tên món ăn theo mã.
     * @param maMonAnUong - mã món ăn (String)
     * @return tên món ăn.
     */
    private String getDishNameById(String maMonAnUong) { // Thay `int` thành `String`
        String sql = "SELECT tenMonAnUong FROM MonAnUong WHERE maMonAnUong = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maMonAnUong); // Sử dụng `setString` thay vì `setInt`
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("tenMonAnUong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Thực hiện thống kê các thông tin quan trọng về hóa đơn trong khoảng thời gian cho trước.
     * @param ngayBatDau - ngày bắt đầu
     * @param ngayKetThuc - ngày kết thúc
     * @return Một mảng gồm tổng số hóa đơn, tổng doanh thu và trung bình mỗi hóa đơn.
     */
    public Object[] getStatistics(String ngayBatDau, String ngayKetThuc) {
        String sql = "SELECT COUNT(*) AS totalInvoices, SUM(tongTien) AS totalRevenue, AVG(tongTien) AS avgRevenue " +
                     "FROM HoaDon " +
                     "WHERE ngayLap BETWEEN ? AND ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Format date strings into the correct format "yyyy-MM-dd"
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date startDate = sdf.parse(ngayBatDau.trim());
            java.util.Date endDate = sdf.parse(ngayKetThuc.trim());

            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int totalInvoices = rs.getInt("totalInvoices");
                double totalRevenue = rs.getDouble("totalRevenue");
                double avgRevenue = rs.getDouble("avgRevenue");
                return new Object[] { totalInvoices, totalRevenue, avgRevenue };
            }
        } catch (SQLException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public double getTotalRevenue(String ngayBatDau, String ngayKetThuc) {
        String sql = """
	        SELECT SUM(ChiTietHoaDon.soLuongMonAN * MonAnUong.giaTien) AS tongDoanhThu
			FROM ChiTietHoaDon
			JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
			JOIN MonAnUong ON ChiTietHoaDon.maMonAnUong = MonAnUong.maMonAnUong
			WHERE HoaDon.ngayLap BETWEEN ? AND ?

        """;

        double totalRevenue = 0.0;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Gán giá trị tham số ngày bắt đầu và ngày kết thúc
            stmt.setDate(1, java.sql.Date.valueOf(ngayBatDau.trim()));
            stmt.setDate(2, java.sql.Date.valueOf(ngayKetThuc.trim()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    totalRevenue = rs.getDouble("tongDoanhThu");
                    System.out.print("tongDoanhThu"+totalRevenue);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRevenue;
    }


    /**
     * Đóng kết nối cơ sở dữ liệu.
     */
    public void closeConnection() {
        connectDB.closeConnection(connection);
    }
}
