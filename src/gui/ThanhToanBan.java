package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BanDAO;
import dao.HoaDonDAO;
import entity.HoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThanhToanBan extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaBan;
	private JTextField txtMaHoaDon;
	private JTextField txtNgayTao;
	private JTextField txtTienHang;
	private JTextField txtKhuyenMai;
	private JTextField txtThue;
	private JTextField txtTongTien;
	private JTextField txtKhachPhaiTra;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThoi;
	private JButton btnInHoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToanBan frame = new ThanhToanBan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThanhToanBan() {
	
		setBounds(100, 100, 1281, 702);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 74, 461, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBanDat = new JLabel("Bàn đặt");
		lblBanDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBanDat.setBounds(181, 11, 83, 40);
		panel.add(lblBanDat);
		
		txtMaBan = new JTextField();
		txtMaBan.setBounds(288, 13, 117, 40);
		panel.add(txtMaBan);
		txtMaBan.setColumns(10);
		txtMaBan.setText(ThemMon.luuMaBan);
		JLabel lblMaHoaDon = new JLabel("Mã hoá đơn");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaHoaDon.setBounds(26, 64, 95, 30);
		panel.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(130, 66, 283, 30);
		panel.add(txtMaHoaDon);
		
		JLabel lblNgayTao = new JLabel("Ngày tạo");
		lblNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayTao.setBounds(26, 123, 95, 30);
		panel.add(lblNgayTao);
		
		txtNgayTao = new JTextField();
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(130, 123, 283, 30);
		panel.add(txtNgayTao);
		
		JLabel lblTienHang = new JLabel("Tiền hàng");
		lblTienHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienHang.setBounds(26, 184, 95, 30);
		panel.add(lblTienHang);
		
		txtTienHang = new JTextField();
		txtTienHang.setColumns(10);
		txtTienHang.setBounds(130, 184, 283, 30);
		panel.add(txtTienHang);
		
		JLabel lblKhuyenMai = new JLabel("Khuyến Mãi");
		lblKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhuyenMai.setBounds(26, 253, 95, 30);
		panel.add(lblKhuyenMai);
		
		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setColumns(10);
		txtKhuyenMai.setBounds(130, 253, 283, 30);
		panel.add(txtKhuyenMai);
		
		JLabel lblThue = new JLabel("Thuế");
		lblThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThue.setBounds(26, 313, 95, 30);
		panel.add(lblThue);
		
		txtThue = new JTextField();
		txtThue.setColumns(10);
		txtThue.setBounds(130, 315, 283, 30);
		panel.add(txtThue);
		
		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setForeground(new Color(0, 117, 255));
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTngTin.setBounds(26, 389, 95, 30);
		panel.add(lblTngTin);
		
		txtTongTien = new JTextField();
		txtTongTien.setForeground(new Color(226, 141, 14));
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(130, 389, 283, 30);
		panel.add(txtTongTien);
		
		JLabel lblThanhToan = new JLabel("Thanh toán");
		lblThanhToan.setOpaque(true); 
		lblThanhToan.setForeground(SystemColor.text);
		lblThanhToan.setBackground(new Color(0, 117, 255));
		lblThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThanhToan.setBounds(10, 11, 1233, 52);
		contentPane.add(lblThanhToan);
		
		JLabel lblKhchPhiTr = new JLabel("Khách phải trả");
		lblKhchPhiTr.setForeground(new Color(0, 117, 255));
		lblKhchPhiTr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhchPhiTr.setBounds(481, 74, 132, 30);
		contentPane.add(lblKhchPhiTr);
		
		txtKhachPhaiTra = new JTextField();
		txtKhachPhaiTra.setForeground(new Color(226, 141, 14));
		txtKhachPhaiTra.setColumns(10);
		txtKhachPhaiTra.setBounds(623, 74, 181, 30);
		contentPane.add(txtKhachPhaiTra);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(623, 195, 181, 30);
		contentPane.add(txtTienKhachDua);
		
		JLabel lblTinKhcha = new JLabel("Tiền khách đưa");
		lblTinKhcha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinKhcha.setBounds(481, 193, 132, 30);
		contentPane.add(lblTinKhcha);
		
		JLabel lblPhngThc = new JLabel("Phương thức ");
		lblPhngThc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhngThc.setBounds(481, 135, 132, 30);
		contentPane.add(lblPhngThc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tiền mặt", "Chuyển khoản"}));
		comboBox.setBounds(623, 135, 181, 30);
		contentPane.add(comboBox);
		
		JLabel lblTienThoi = new JLabel("Tiền thối");
		lblTienThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienThoi.setBounds(481, 262, 132, 30);
		contentPane.add(lblTienThoi);
		
		txtTienThoi = new JTextField();
		txtTienThoi.setColumns(10);
		txtTienThoi.setBounds(623, 264, 181, 30);
		contentPane.add(txtTienThoi);
		
		btnInHoaDon = new JButton("IN HOA ĐƠN");
		btnInHoaDon.setForeground(Color.WHITE);
		btnInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInHoaDon.setBackground(new Color(226, 141, 14));
		btnInHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInHoaDon.setBounds(1090, 602, 143, 52);
		contentPane.add(btnInHoaDon);
		btnInHoaDon.addActionListener(this);
		JPanel pnBanPhim = new JPanel();
		pnBanPhim.setBounds(814, 74, 429, 495);
		contentPane.add(pnBanPhim);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(794, 322, -304, 204);
		contentPane.add(panel_1);
		
		JPanel pnGoiY = new JPanel();
		pnGoiY.setBounds(481, 325, 323, 244);
		contentPane.add(pnGoiY);
		// Tạo panel pnBanPhim và thiết lập GridLayout với 3 hàng và 3 cột
		
		 pnBanPhim.setLayout(new GridLayout(5, 3, 10, 10)); // 4 hàng, 3 cột, khoảng cách 10px

	        // Các nút số và phím chức năng
	        String[] buttonLabels = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "00", "000"};
	        for (String label : buttonLabels) {
	            JButton btn = new JButton(label);
	            btn.setBackground(new Color(255, 255, 255));
	           
	            pnBanPhim.add(btn); 
	        }

	     
	        JButton btnDot = new JButton(".");
	        pnBanPhim.add(btnDot); 
	        btnDot.setBackground(new Color(255, 255, 255));
	        
	       
	        JButton btnC = new JButton("C");
	        JButton btnDel = new JButton("DEL");
	        pnBanPhim.add(btnC);  // Thêm nút C
	        pnBanPhim.add(btnDel); // Thêm nút DEL
	        btnC.setBackground(new Color(255, 255, 255));  
	        btnDel.setBackground(new Color(255, 255, 255)); 

		// Tạo panel pnGoiY và thiết lập GridLayout với 3 hàng và 3 cột
	
		pnGoiY.setLayout(new GridLayout(3, 3, 10, 10));  // 3 hàng, 3 cột, khoảng cách 10px giữa các phần tử

		// Tạo các nút giá tiền từ 50k đến 500k cho pnGoiY
		String[] priceLabels = {"50k", "100k", "150k", "200k", "250k", "300k", "350k", "400k", "500k"};
		for (String label : priceLabels) {
		    JButton btn = new JButton(label);
		    btn.setBackground(new Color(255, 255, 255));
           
		    pnGoiY.add(btn);
		}

		// Thêm các panel vào contentPane hoặc frame chính của bạn
		contentPane.add(pnBanPhim);
		contentPane.add(pnGoiY);

		HoaDonDAO hdd = new HoaDonDAO();
		HoaDon hoaDon = hdd.getHoaDonByMaBan(ThemMon.luuMaBan); 
		
		if (hoaDon != null) {
            txtMaHoaDon.setText(hoaDon.getMaHoaDon());
            txtNgayTao.setText(hoaDon.getNgayLapHoaDon().toString());
            
            txtTienHang.setText(String.valueOf(hoaDon.getThanhTien()));
        
            txtKhuyenMai.setText("Chưa có khuyến mãi");
            txtThue.setText("10%");
            txtTongTien.setText(String.valueOf(hoaDon.getTongTien()));
            txtKhachPhaiTra.setText(String.valueOf(hoaDon.getTongTien()));
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn cho mã bàn này.");
        }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInHoaDon) {
		    BanDAO bd = new BanDAO();
		    // Hủy đặt bàn theo mã bàn
		    bd.huyDatBan(ThemMon.luuMaBan);

		    // Set trạng thái hóa đơn thành true (hoặc "Đã thanh toán" nếu bạn sử dụng chuỗi thay vì boolean)
		    HoaDonDAO hoaDonDAO = new HoaDonDAO();
		    boolean success = hoaDonDAO.setTrangThaiHoaDon(txtMaHoaDon.getText(), true); // Thay "Đã thanh toán" bằng trạng thái mong muốn

		    // Hiển thị thông báo thành công nếu set trạng thái thành công
		    if (success) {
		        JOptionPane.showMessageDialog(this, "Xuất hoá đơn thành công và trạng thái hóa đơn đã được cập nhật!");
		    } else {
		        JOptionPane.showMessageDialog(this, "Xuất hoá đơn thành công, nhưng không thể cập nhật trạng thái hóa đơn!");
		    }

		    // Hiển thị cửa sổ xuất hóa đơn
		    new XuatHoaDon().setVisible(true);
		}

		
	}
}
