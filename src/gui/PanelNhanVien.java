package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import entity.NhanVien;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelNhanVien extends JPanel {


    private static final long serialVersionUID = 1L;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JTextField txtNgaySinh;
    private JTextField txtSDT;
    private JTextField txtDiaChi;
    private JTextField txtGmail;
    private JTextField txtLCB;
    private JTextField txtNgayVaoLam;
    private JTextField txtSearch;
    private JTable tblNhanVien;
    private DefaultTableModel tableModel;
    private NhanVienDAO nhanVienDAO;

    public PanelNhanVien() {
        nhanVienDAO = new NhanVienDAO(); 
        setLayout(null);

        Label lblTT = new Label("Thông tin");
        lblTT.setBackground(new Color(65, 41, 224));
        lblTT.setBounds(10, 10, 150, 40);
        add(lblTT);
        lblTT.setAlignment(Label.CENTER);
        lblTT.setForeground(new Color(255, 255, 255));
        lblTT.setFont(new Font("Arial", Font.BOLD, 17));

        JLabel lblNhanVien = new JLabel("    Danh sách nhân viên");
        lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
        lblNhanVien.setBackground(new Color(65, 41, 224));
        lblNhanVien.setForeground(new Color(255, 255, 255));
        lblNhanVien.setFont(new Font("Arial", Font.BOLD, 18));
        lblNhanVien.setBounds(388, 10, 1524, 40);
        lblNhanVien.setOpaque(true);
        add(lblNhanVien);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(192, 192, 192)));
        panel.setBounds(10, 56, 368, 939);
        add(panel);
        panel.setLayout(null);

        txtMaNV = new JTextField();
        txtMaNV.setBounds(10, 114, 348, 35);
        panel.add(txtMaNV);
        txtMaNV.setColumns(10);

        JLabel lblMa = new JLabel("Mã nhân viên");
        lblMa.setBounds(15, 89, 111, 26);
        panel.add(lblMa);
        lblMa.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblTen = new JLabel("Tên nhân viên");
        lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTen.setBounds(15, 164, 111, 26);
        panel.add(lblTen);
        
        txtTenNV = new JTextField();
        txtTenNV.setColumns(10);
        txtTenNV.setBounds(10, 188, 348, 35);
        panel.add(txtTenNV);

        JLabel lblNgaySinh = new JLabel("Ngày sinh");
        lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNgaySinh.setBounds(15, 238, 111, 26);
        panel.add(lblNgaySinh);
        
        txtNgaySinh = new JTextField();
        txtNgaySinh.setColumns(10);
        txtNgaySinh.setBounds(10, 264, 348, 35);
        panel.add(txtNgaySinh);

        JLabel lblSDT = new JLabel("Số điện thoại");
        lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSDT.setBounds(15, 314, 111, 26);
        panel.add(lblSDT);
        
        txtSDT = new JTextField();
        txtSDT.setColumns(10);
        txtSDT.setBounds(10, 341, 348, 35);
        panel.add(txtSDT);

        JLabel lblDiaChi = new JLabel("Địa chỉ");
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDiaChi.setBounds(15, 386, 111, 26);
        panel.add(lblDiaChi);
        
        txtDiaChi = new JTextField();
        txtDiaChi.setColumns(10);
        txtDiaChi.setBounds(10, 411, 348, 35);
        panel.add(txtDiaChi);

        JLabel lblGmail = new JLabel("Gmail");
        lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGmail.setBounds(15, 456, 111, 26);
        panel.add(lblGmail);
        
        txtGmail = new JTextField();
        txtGmail.setColumns(10);
        txtGmail.setBounds(10, 479, 348, 35);
        panel.add(txtGmail);

        JLabel lblLCB = new JLabel("Lương CB");
        lblLCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLCB.setBounds(15, 530, 111, 26);
        panel.add(lblLCB);
        
        txtLCB = new JTextField();
        txtLCB.setColumns(10);
        txtLCB.setBounds(10, 556, 348, 35);
        panel.add(txtLCB);

        JLabel lblNgayVaoLam = new JLabel("Ngày vào làm");
        lblNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNgayVaoLam.setBounds(15, 601, 111, 26);
        panel.add(lblNgayVaoLam);
        
        txtNgayVaoLam = new JTextField();
        txtNgayVaoLam.setColumns(10);
        txtNgayVaoLam.setBounds(10, 627, 348, 35);
        panel.add(txtNgayVaoLam);

        JButton btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.WHITE);
        btnThem.setBackground(new Color(0, 191, 0));
        btnThem.setBounds(10, 677, 70, 30);
        panel.add(btnThem);

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        JButton btnSua = new JButton("Sửa");
        btnSua.setForeground(Color.WHITE);
        btnSua.setBackground(new Color(255, 128, 64));
        btnSua.setBounds(106, 677, 70, 30);
        panel.add(btnSua);
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setForeground(Color.WHITE);
        btnXoa.setBackground(Color.RED);
        btnXoa.setBounds(197, 677, 70, 30);
        panel.add(btnXoa);
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        JLabel lblMaNV = new JLabel("Nhập mã nhân viên cần tìm:");
        lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMaNV.setBounds(707, 68, 199, 29);
        add(lblMaNV);

        txtSearch = new JTextField();
        txtSearch.setBounds(1001, 68, 746, 30);
        add(txtSearch);
        txtSearch.setColumns(10);

        JButton btnSearch = new JButton("Tìm kiếm");
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSearch.setForeground(new Color(255, 255, 255));
        btnSearch.setBackground(new Color(0, 208, 0));
        btnSearch.setBounds(1794, 68, 118, 30);
        add(btnSearch);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txtSearch.getText().trim().equals("")) {
                    loadAllEmployees();
                }
                else {
                    searchEmployee();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(388, 107, 1524, 888);
        add(scrollPane);

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Mã", "Tên nhân viên", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Gmail", "Lương cơ bản", "Ngày vào làm"}
        );

        tblNhanVien = new JTable(tableModel);
        scrollPane.setViewportView(tblNhanVien);

        loadAllEmployees();
        
        tblNhanVien.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblNhanVien.getSelectedRow();
                if (selectedRow != -1) {
                    fillInputFields(selectedRow);
                }
            }
        });
    }
    
    private void fillInputFields(int selectedRow) {
        txtMaNV.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtTenNV.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtNgaySinh.setText(tableModel.getValueAt(selectedRow, 2).toString()); 
        txtSDT.setText(tableModel.getValueAt(selectedRow, 3).toString());
        txtDiaChi.setText(tableModel.getValueAt(selectedRow, 4).toString());        
        txtGmail.setText(tableModel.getValueAt(selectedRow, 5).toString());
        txtLCB.setText(tableModel.getValueAt(selectedRow, 6).toString());
        txtNgayVaoLam.setText(tableModel.getValueAt(selectedRow, 7).toString()); 
    }

    private void loadAllEmployees() {
        tableModel.setRowCount(0);
        List<NhanVien> employees = nhanVienDAO.layTatCaNhanVien(); 
        for (NhanVien nv : employees) {
            tableModel.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),         
                nv.getNgaySinh(),
                nv.getSdt(),  
                nv.getDiaChi(),
                nv.getGmail(),              
                nv.getLuongCB(),
                nv.getNgayVaoLam()
            });
        }
    }
    
    private void loadSearchEmployees(NhanVien nv) {
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{
            nv.getMaNV(),
            nv.getTenNV(),         
            nv.getNgaySinh(),
            nv.getSdt(),  
            nv.getDiaChi(),
            nv.getGmail(),              
            nv.getLuongCB(),
            nv.getNgayVaoLam()
        });
    }

    private void addEmployee() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setTenNV(txtTenNV.getText());
        nv.setNgaySinh(LocalDate.parse(txtNgaySinh.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
        nv.setSdt(txtSDT.getText());
        nv.setDiaChi(txtDiaChi.getText());
        nv.setGmail(txtGmail.getText());
        nv.setLuongCB(Double.parseDouble(txtLCB.getText()));
        nv.setNgayVaoLam(LocalDate.parse(txtNgayVaoLam.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
        nv.setChucVu(false); 
        nhanVienDAO.themNhanVien(nv);
        loadAllEmployees();
        clearFields();
    }

    private void updateEmployee() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setTenNV(txtTenNV.getText());
        nv.setNgaySinh(LocalDate.parse(txtNgaySinh.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
        nv.setSdt(txtSDT.getText());
        nv.setDiaChi(txtDiaChi.getText());
        nv.setGmail(txtGmail.getText());
        nv.setLuongCB(Double.parseDouble(txtLCB.getText()));
        nv.setNgayVaoLam(LocalDate.parse(txtNgayVaoLam.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
        nv.setChucVu(false); 
        nhanVienDAO.capNhatNhanVien(nv);
        loadAllEmployees();
        clearFields();
    }

    private void deleteEmployee() {
        String maNV = txtMaNV.getText();
        nhanVienDAO.xoaNhanVien(maNV);
        loadAllEmployees();
        clearFields();
    }

    private void searchEmployee() {
        String maNV = txtSearch.getText();
        NhanVien nv = nhanVienDAO.timKiemNhanVien(maNV);
        if (nv != null) {
            loadSearchEmployees(nv);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên!");
        }
    }

    private void clearFields() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtGmail.setText("");
        txtLCB.setText("");
        txtNgayVaoLam.setText("");
        txtSearch.setText("");
    }

}
