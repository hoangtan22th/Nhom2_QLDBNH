package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import entity.KhachHang;

public class PanelKhachHang extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtMaKh;
    private JTextField txtTenKh;
    private JTextField txtNgaySinh;
    private JTextField txtSDT;
    private JTextField txtTimKiem;
    private JTable tblKhachHang;
    private DefaultTableModel tableModel;  // Declare a table model
    private KhachHangDAO khachHangDAO;

    public PanelKhachHang() {
        setLayout(null);
        khachHangDAO = new KhachHangDAO();
        Label lblTT = new Label("Thông tin");
        lblTT.setBackground(new Color(65, 41, 224));
        lblTT.setBounds(10, 10, 150, 40);
        add(lblTT);
        lblTT.setAlignment(Label.CENTER);
        lblTT.setForeground(new Color(255, 255, 255));
        lblTT.setFont(new Font("Arial", Font.BOLD, 17));
        
        JLabel lblNhanVien = new JLabel("    Quản lý khách hàng");
        lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
        lblNhanVien.setBackground(new Color(65, 41, 224));
        lblNhanVien.setForeground(new Color(255, 255, 255));
        lblNhanVien.setFont(new Font("Arial", Font.BOLD, 18));
        lblNhanVien.setBounds(387, 10, 1524, 40);
        lblNhanVien.setOpaque(true);
        add(lblNhanVien);
        
        JPanel panelTTKH = new JPanel();
        panelTTKH.setBorder(new LineBorder(new Color(192, 192, 192)));
        panelTTKH.setBounds(10, 56, 367, 939);
        add(panelTTKH);
        panelTTKH.setLayout(null);
        
        txtMaKh = new JTextField();
        txtMaKh.setBounds(10, 35, 347, 35);
        panelTTKH.add(txtMaKh);
        txtMaKh.setColumns(10);
        
        JLabel lblMa = new JLabel("Mã khách hàng");
        lblMa.setBounds(15, 10, 111, 26);
        panelTTKH.add(lblMa);
        lblMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblTen = new JLabel("Tên khách hàng");
        lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTen.setBounds(15, 85, 111, 26);
        panelTTKH.add(lblTen);
        
        txtTenKh = new JTextField();
        txtTenKh.setColumns(10);
        txtTenKh.setBounds(10, 109, 347, 35);
        panelTTKH.add(txtTenKh);
        
        JLabel lblNgaySinh = new JLabel("Ngày sinh");
        lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNgaySinh.setBounds(15, 159, 111, 26);
        panelTTKH.add(lblNgaySinh);
        
        txtNgaySinh = new JTextField();
        txtNgaySinh.setColumns(10);
        txtNgaySinh.setBounds(10, 185, 347, 35);
        panelTTKH.add(txtNgaySinh);
        
        JLabel lblSDT = new JLabel("Số điện thoại");
        lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSDT.setBounds(15, 235, 111, 26);
        panelTTKH.add(lblSDT);
        
        txtSDT = new JTextField();
        txtSDT.setColumns(10);
        txtSDT.setBounds(10, 258, 347, 35);
        panelTTKH.add(txtSDT);
        
        JButton btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.WHITE);
        btnThem.setBackground(new Color(0, 191, 0));
        btnThem.setBounds(10, 303, 70, 30);
        panelTTKH.add(btnThem);
        
        JButton btnSua = new JButton("Sửa");
        btnSua.setForeground(Color.WHITE);
        btnSua.setBackground(new Color(255, 128, 64));
        btnSua.setBounds(104, 303, 70, 30);
        panelTTKH.add(btnSua);
        
        JButton btnXoa = new JButton("Xóa");
        btnXoa.setForeground(Color.WHITE);
        btnXoa.setBackground(Color.RED);
        btnXoa.setBounds(198, 303, 70, 30);
        panelTTKH.add(btnXoa);
        
        JButton btnLuu = new JButton("Lưu");
        btnLuu.setForeground(Color.WHITE);
        btnLuu.setBackground(Color.BLUE);
        btnLuu.setBounds(287, 303, 70, 30);
        panelTTKH.add(btnLuu);
        
        JLabel lblTimKiem = new JLabel("Nhập mã khách hàng cần tìm:");
        lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTimKiem.setBounds(779, 69, 199, 29);
        add(lblTimKiem);
        
        txtTimKiem = new JTextField();
        txtTimKiem.setBounds(1017, 68, 746, 30);
        add(txtTimKiem);
        txtTimKiem.setColumns(10);
        
        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTimKiem.setForeground(new Color(255, 255, 255));
        btnTimKiem.setBackground(new Color(0, 208, 0));
        btnTimKiem.setBounds(1793, 68, 118, 29);
        add(btnTimKiem);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(387, 107, 1524, 888);
        add(scrollPane);
        
        // Initialize the table model and set it to the table
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã", "Tên", "Số điện thoại", "Ngày sinh" });
        tblKhachHang = new JTable(tableModel);
        scrollPane.setViewportView(tblKhachHang);

        // Action listeners
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maKH = txtMaKh.getText();
                String tenKH = txtTenKh.getText();
                String ngaySinh = txtNgaySinh.getText();
                String sdt = txtSDT.getText();
                KhachHang kh = new KhachHang(maKH, tenKH, LocalDate.parse(ngaySinh), sdt);
                if (khachHangDAO.themKhachHang(kh)) {
                    loadKhachHangData();
                    clearFields();
                }
            }
        });

        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maKH = txtMaKh.getText();
                String tenKH = txtTenKh.getText();
                String ngaySinh = txtNgaySinh.getText();
                String sdt = txtSDT.getText();
                KhachHang kh = new KhachHang(maKH, tenKH, LocalDate.parse(ngaySinh), sdt);
                if (khachHangDAO.capNhatKhachHang(kh)) {
                    loadKhachHangData();
                    clearFields();
                }
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maKH = txtMaKh.getText();
                if (khachHangDAO.xoaKhachHang(maKH)) {
                    loadKhachHangData();
                    clearFields();
                }
            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maKH = txtTimKiem.getText().trim();
                KhachHang kh = khachHangDAO.timKiemKhachHang(maKH);
                if (kh != null) {
                    loadSearchData(kh);
                } else if (maKH.equals("")) {
                    loadKhachHangData();
                }
            }
        });
        
         tblKhachHang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblKhachHang.getSelectedRow();
                if (selectedRow != -1) {
                    fillInputFields(selectedRow);
                }
            }
        });
        loadKhachHangData();

    }
    
    private void fillInputFields(int selectedRow) {
        txtMaKh.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtTenKh.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtSDT.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txtNgaySinh.setText(tableModel.getValueAt(selectedRow, 3).toString());        
    }

    private void loadKhachHangData() {
        tableModel.setRowCount(0); // Clear the table model
        List<KhachHang> khachHangs = khachHangDAO.layTatCaKhachHang();
        for (KhachHang kh : khachHangs) {
            tableModel.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getNgaySinh() });
        }
    }
    
    private void loadSearchData(KhachHang kh) {
        tableModel.setRowCount(0); // Clear the table model
        tableModel.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getNgaySinh() });
    }

    private void clearFields() {
        txtMaKh.setText("");
        txtTenKh.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtTimKiem.setText("");
    }
}
