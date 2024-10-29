package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    public connectDB() { }

    public static Connection getConnection() {
        Connection c = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDatBanNhaHang;encrypt=false;";

        String[] users = {"dat", "sa", "thaiphat"};
        String[] passwords = {"12345678", "sapassword", "thaiphat_password"};

        for (int i = 0; i < users.length; i++) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                c = DriverManager.getConnection(url, users[i], passwords[i]);
                System.out.println("Kết nối thành công với user: " + users[i]);
                break; 
            } catch (SQLException e) {
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        if (c == null) {
            System.out.println("Không thể kết nối với bất kỳ tài khoản nào.");
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        if (c != null) {
            try {
                c.close();
                System.out.println("Đóng kết nối thành công.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
