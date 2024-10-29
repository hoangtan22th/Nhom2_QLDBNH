package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.MonAnUong;

public class MonAnUongDAO {

    public List<MonAnUong> loadAllMonAnUong() {
        List<MonAnUong> monAnUongList = new ArrayList<>();
        String sql = "SELECT maMonAnUong, tenMonAnUong, giaTien, loai FROM MonAnUong";

       
        try (Connection connection = connectDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String maMonAnUong = resultSet.getString("maMonAnUong");
                String tenMonAnUong = resultSet.getString("tenMonAnUong");
                double giaTien = resultSet.getDouble("giaTien");
                String loai = resultSet.getString("loai");
               

                MonAnUong monAnUong = new MonAnUong(maMonAnUong, tenMonAnUong, giaTien, loai);
                monAnUongList.add(monAnUong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monAnUongList;
    }


    public boolean addMonAnUong(MonAnUong monAnUong) {
        String sql = "INSERT INTO MonAnUong (maMonAnUong, tenMonAnUong, giaTien, loai) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = connectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, monAnUong.getMaMonAnUong());
            preparedStatement.setString(2, monAnUong.getTenMonAnUong());
            preparedStatement.setDouble(3, monAnUong.getGiaTien());
            preparedStatement.setString(4, "Chưa có");
      
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; 
    }

 
    public boolean updateMonAnUong(MonAnUong monAnUong) {
        String sql = "UPDATE MonAnUong SET tenMonAnUong = ?, giaTien = ?, loai = ?, WHERE maMonAnUong = ?";
        
        try (Connection connection = connectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, monAnUong.getTenMonAnUong());
            preparedStatement.setDouble(2, monAnUong.getGiaTien());
            preparedStatement.setString(3, "Chưa có");
       
            preparedStatement.setString(4, monAnUong.getMaMonAnUong());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; 
    }

    
    public boolean deleteMonAnUong(String maMonAnUong) {
        String sql = "DELETE FROM MonAnUong WHERE maMonAnUong = ?";
        
        try (Connection connection = connectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, maMonAnUong);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; }
    public MonAnUong layMonAnUong(String maMonAn) {
        MonAnUong monAnUong = null;
        String query = "SELECT maMonAnUong, tenMonAnUong, giaTien, loai FROM MonAnUong WHERE maMonAnUong = ?";

        try (Connection con = connectDB.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setString(1, maMonAn);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenMonAn = rs.getString("tenMonAnUong");
                    double giaTien = rs.getDouble("giaTien");
                    String loai = rs.getString("loai");           
                    monAnUong = new MonAnUong(maMonAn, tenMonAn, giaTien, loai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monAnUong; 
    }


}
