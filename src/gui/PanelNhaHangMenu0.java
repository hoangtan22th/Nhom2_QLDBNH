package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class PanelNhaHangMenu0 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public PanelNhaHangMenu0() {
        setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(81, 0, 161, 64);
        panel.setBackground(Color.WHITE);
        add(panel);
        panel.setLayout(null);

        JLabel lblPhieu = new JLabel("Phiếu");
        lblPhieu.setForeground(new Color(255, 255, 255));
        lblPhieu.setBackground(new Color(226, 141, 14));
        lblPhieu.setOpaque(true); // Thiết lập để hiển thị màu nền
        lblPhieu.setBounds(10, 11, 141, 42);
       
        panel.add(lblPhieu);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(81, 75, 806, 77);
        panel_1.setBackground(Color.WHITE);
        add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNhanVien = new JLabel("Nguyễn Văn A");
        lblNhanVien.setBounds(10, 11, 188, 55);
        panel_1.add(lblNhanVien);

        JLabel lblKhachHang = new JLabel("Khách hàng 1");
        lblKhachHang.setBounds(218, 11, 188, 55);
        panel_1.add(lblKhachHang);

        JLabel lblSoLuongKhach = new JLabel("4 khách");
        lblSoLuongKhach.setBounds(432, 11, 188, 55);
        panel_1.add(lblSoLuongKhach);

        JLabel lblThoiGianDen = new JLabel("11:00");
        lblThoiGianDen.setBounds(643, 10, 153, 56);
        panel_1.add(lblThoiGianDen);

        // Tạo border title cho các label
        lblKhachHang.setBorder(BorderFactory.createTitledBorder("Khách hàng"));
        lblNhanVien.setBorder(BorderFactory.createTitledBorder("Nhân viên"));
        lblSoLuongKhach.setBorder(BorderFactory.createTitledBorder("Số lượng khách"));
        lblThoiGianDen.setBorder(BorderFactory.createTitledBorder("Thời gian đến"));

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(81, 163, 806, 507);
        panel_2.setBackground(Color.WHITE);
        add(panel_2);
        panel_2.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 786, 431);
        panel_2.add(scrollPane);

        table = new JTable();
  
        table.setRowHeight(30); // Chiều cao của mỗi hàng (30 pixel)

        // Tạo model bảng
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {
                {"abc", null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
            },
            new String[] {
                "Số Lượng", "Hàng Bán", "Tiền Hàng"
            }
        );
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);

        scrollPane.setViewportView(table);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(80, 706, 742, 70);
        panel_3.setBackground(Color.WHITE);
        add(panel_3);
        panel_3.setLayout(null);

        JLabel lblDaDat = new JLabel("Đã đặt");

        lblDaDat.setForeground(new Color(255, 255, 255));
        lblDaDat.setBackground(new Color(226, 141, 14));
        lblDaDat.setOpaque(true); // Thiết lập để hiển thị màu nền
        lblDaDat.setBounds(211, 11, 191, 48);
        panel_3.add(lblDaDat);

        JLabel lblCoKhach = new JLabel("Có khách");
   
        lblCoKhach.setForeground(new Color(255, 255, 255));
        lblCoKhach.setBackground(new Color(51, 153, 102));
        lblCoKhach.setOpaque(true); // Thiết lập để hiển thị màu nền
        lblCoKhach.setBounds(10, 11, 191, 48);
        panel_3.add(lblCoKhach);

        JLabel lblTrong = new JLabel("Trống");

        lblTrong.setForeground(new Color(255, 255, 255));
        lblTrong.setBackground(new Color(0, 117, 225));
        lblTrong.setOpaque(true); // Thiết lập để hiển thị màu nền
        lblTrong.setBounds(412, 11, 182, 48);
        panel_3.add(lblTrong);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_4.setBounds(930, 11, 778, 138);
        add(panel_4);
        panel_4.setLayout(null);

        JButton btnBanThuong = new JButton("Thường");
        btnBanThuong.setForeground(new Color(255, 255, 255));
        btnBanThuong.setBackground(new Color(14, 48, 226)); // Màu 0E30E2
      
        btnBanThuong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBanThuong.setBounds(10, 11, 246, 101);
        panel_4.add(btnBanThuong);

        JButton btnBanVIP = new JButton("VIP");
        btnBanVIP.setForeground(new Color(255, 255, 255));
        btnBanVIP.setBackground(new Color(14, 48, 226)); // Màu 0E30E2

        btnBanVIP.setBounds(285, 11, 234, 101);
        panel_4.add(btnBanVIP);

        JButton btnTatCa = new JButton("Tất cả");
        btnTatCa.setForeground(new Color(255, 255, 255));
        btnTatCa.setBackground(new Color(14, 48, 226)); // Màu 0E30E2

        btnTatCa.setBounds(544, 11, 234, 101);
        panel_4.add(btnTatCa);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_5.setBounds(940, 165, 768, 505);
        add(panel_5);
                        panel_5.setLayout(new GridLayout(0, 4, 0, 0));
                
                        JButton btnButton1 = new JButton("New button");
                        btnButton1.setForeground(new Color(30, 144, 255));
                        panel_5.add(btnButton1);
        
                JButton btnButton2 = new JButton("New button");
                panel_5.add(btnButton2);
        
                JButton btnButton3 = new JButton("New button");
                panel_5.add(btnButton3);
                
                        JButton btnButton4 = new JButton("New button");
                        panel_5.add(btnButton4);
                
                        JButton btnButton5 = new JButton("New button");
                        panel_5.add(btnButton5);
                
                        JButton btnButton6 = new JButton("New button");
                        panel_5.add(btnButton6);
        
                JButton btnButton7 = new JButton("New button");
                panel_5.add(btnButton7);
                        
                                JButton btnButton8 = new JButton("New button");
                                btnButton8.addActionListener(new ActionListener() {
                                	public void actionPerformed(ActionEvent e) {
                                	}
                                });
                                panel_5.add(btnButton8);
                
                        JButton btnButton9 = new JButton("New button");
                        panel_5.add(btnButton9);
                
                        JButton btnButton10 = new JButton("New button");
                        panel_5.add(btnButton10);
                
                        JButton btnButton11 = new JButton("New button");
                        panel_5.add(btnButton11);
        
                JButton btnButton12 = new JButton("New button");
                panel_5.add(btnButton12);
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        panel_6.setBounds(940, 712, 768, 64);
        add(panel_6);
        panel_6.setLayout(null);
        JButton btnNewButton_14 = new JButton("Chuyển bàn");
        btnNewButton_14.setForeground(Color.WHITE);
        btnNewButton_14.setBackground(new Color(0, 117, 225));
        btnNewButton_14.setBounds(156, 6, 143, 53);
        panel_6.add(btnNewButton_14);
        
        JButton btnNewButton_15 = new JButton("Ghép bàn");
        btnNewButton_15.setForeground(Color.WHITE);
        btnNewButton_15.setBackground(new Color(226, 141, 14));
        btnNewButton_15.setBounds(309, 6, 143, 53);
        panel_6.add(btnNewButton_15);
        
        JButton btnNewButton_16 = new JButton("Tách bàn");
        btnNewButton_16.setForeground(Color.WHITE);

        btnNewButton_16.setBackground(new Color(226, 141, 14));
        btnNewButton_16.setBounds(462, 6, 143, 53);
        panel_6.add(btnNewButton_16);
        
        JButton btnNewButton_17 = new JButton("Phiếu kiểm món");
        btnNewButton_17.setForeground(Color.WHITE);
        btnNewButton_17.setBackground(new Color(209, 14, 226));
        btnNewButton_17.setBounds(615, 6, 153, 53);
        panel_6.add(btnNewButton_17);
        
        JButton btnNewButton_13 = new JButton("Thêm món");
        btnNewButton_13.setForeground(Color.WHITE);
        btnNewButton_13.setBackground(new Color(14, 48, 226));
        btnNewButton_13.setBounds(0, 6, 146, 53);
        panel_6.add(btnNewButton_13);
    }
}
