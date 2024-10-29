package gui; 

import javax.swing.*;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhap extends JFrame implements ActionListener{
    private JPanel pnCenter;
    private JLabel lblTitle;
    private JTextField txtDangNhap;
    private JTextField txtMatKhau;
    private JButton btnDangNhap;
    private JButton btnQuenMatKhau;
    private JButton btnTroGiup;
    private JButton btnThoat;
    private JButton btnDoiMatKhau;
    private JLabel lblDangNhap;
    private JLabel lblMatKhau;
    private JLabel lblRong;
    private JPanel pnBoxDangNhap;
    private Menu menu;
    
    private Image backgroundImage;

	

    public DangNhap() {
    	menu = new Menu();
    	setIconImage(Toolkit.getDefaultToolkit().getImage(""));
        setTitle("Đăng nhập");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1922, 1094);      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        
        backgroundImage = Toolkit.getDefaultToolkit().getImage("img/hinhNen.jpg");
        pnCenter = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
         
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pnBoxDangNhap = new JPanel();
        pnBoxDangNhap.setLayout(new FlowLayout());

        Box b, b0, b1, b2, b3, b4;

        b = Box.createVerticalBox();
        b.setBounds(804, 430, 369, 152);
        b0 = Box.createHorizontalBox();
        b1 = Box.createHorizontalBox();
        b2 = Box.createHorizontalBox();
        b3 = Box.createHorizontalBox();
        b4 = Box.createHorizontalBox();
        Dimension buttonSize = new Dimension(120, 26); 

        txtDangNhap = new JTextField(25);
        txtMatKhau = new JTextField(25);
        txtDangNhap.setPreferredSize(new Dimension(400, 20)); 
        txtMatKhau.setPreferredSize(new Dimension(400, 20)); 
        lblDangNhap = new JLabel("Tên đăng nhập: ");
        lblMatKhau = new JLabel("Mật khẩu: ");
        lblMatKhau.setPreferredSize(lblDangNhap.getPreferredSize()); 
        
        btnDangNhap = new JButton("Đăng nhập");
        btnDangNhap.setPreferredSize(buttonSize);
        btnDangNhap.setBackground(Color.decode("#00972A")); 
        btnDangNhap.setForeground(Color.WHITE); 
        btnDangNhap.setMinimumSize(buttonSize); 
        btnDangNhap.setMaximumSize(buttonSize); 
        
        btnQuenMatKhau = new JButton("Quên mật khẩu");
        btnQuenMatKhau.setPreferredSize(buttonSize);
        btnQuenMatKhau.setBackground(Color.decode("#E28D0E")); 
        btnQuenMatKhau.setForeground(Color.WHITE); 
        btnQuenMatKhau.setMinimumSize(buttonSize);
        btnQuenMatKhau.setMaximumSize(buttonSize); 
        pnCenter.setLayout(null);
        b1.add(lblDangNhap);
        b1.add(txtDangNhap);
        b1.add(Box.createHorizontalStrut(10)); 
        b2.add(lblMatKhau);
        b2.add(txtMatKhau);
        b2.add(Box.createHorizontalStrut(10)); 
        
        b3.add(Box.createHorizontalStrut(85));    
        b3.add(btnDangNhap);
        b3.add(Box.createHorizontalStrut(8));
        b3.add(btnQuenMatKhau);
        
        b.add(b0);
        b.add(Box.createVerticalStrut(15)); 
        b.add(b1);
        b.add(Box.createVerticalStrut(15)); 
        b.add(b2);
        b.add(Box.createVerticalStrut(15)); 
        b.add(b3);
        pnCenter.add(b);
        btnDangNhap.setPreferredSize(buttonSize);
        btnQuenMatKhau.setPreferredSize(buttonSize);
        getContentPane().add(pnCenter, BorderLayout.CENTER);
        
        btnTroGiup = new JButton("Trợ giúp");
        btnTroGiup.setBounds(1496, 1007, 120, 26);
        pnCenter.add(btnTroGiup);
        btnTroGiup.setBackground(Color.decode("#0E30E2")); 
        btnTroGiup.setForeground(Color.white);
        
                btnTroGiup.setPreferredSize(buttonSize);
                btnDoiMatKhau = new JButton("Đổi mật khẩu");
                btnDoiMatKhau.setBounds(1636, 1007, 120, 26);
                pnCenter.add(btnDoiMatKhau);
                btnDoiMatKhau.setBackground(Color.decode("#E28D0E")); 
                btnDoiMatKhau.setForeground(Color.white);
                btnDoiMatKhau.setPreferredSize(buttonSize);
                btnThoat = new JButton("Thoát");
                btnThoat.setBounds(1776, 1007, 120, 26);
                pnCenter.add(btnThoat);
                btnThoat.setBackground(Color.decode("#E12020")); 
                btnThoat.setForeground(Color.white);
                btnThoat.setPreferredSize(buttonSize);
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon("img/Logo.png"));
                lblNewLabel.setBounds(0, -17, 225, 181);
                pnCenter.add(lblNewLabel);
                
                lblTitle = new JLabel("ĐĂNG NHẬP");
                lblTitle.setBounds(936, 392, 145, 28);
                pnCenter.add(lblTitle);
                lblTitle.setForeground(new Color(0, 0, 128));
                lblTitle.setFont(new Font("Arial", Font.BOLD, 24)); 
        btnDangNhap.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnDangNhap) {
    	    String taiKhoan = txtDangNhap.getText();
    	    String matKhau = txtMatKhau.getText();
    	    if (taiKhoan.isEmpty() || matKhau.isEmpty()) {
    	        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không được để trống!");
    	        return;
    	    }

    	    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();  
    	    int check = taiKhoanDAO.kiemTraTaiKhoan(taiKhoan, matKhau);

    	    if (check != -1) {
    	        menu = new Menu();
    	        menu.thayDoiMenuTheoVaiTro(check); 
    	        JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
    	        menu.setVisible(true); // Hiển thị giao diện
    	        setVisible(false); 
    	    } else {
    	        JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	    }
    	}
        
    }

    public static void main(String[] args) {
        DangNhap frame = new DangNhap();
        frame.setVisible(true);
    }

    

}
