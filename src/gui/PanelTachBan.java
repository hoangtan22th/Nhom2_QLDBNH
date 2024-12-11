package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.connectDB;
import dao.BanDAO;
import dao.KhuVucBanDAO;
import entity.Ban;
import entity.KhuVucBan;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PanelTachBan extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDongY;
	private JComboBox<String> cbDenKhu, CBDenBan;
	private JLabel lblTenMon, lblSoLuong,lblKhu1,lblBan1;

	public PanelTachBan() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 674, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		// Phối màu cho panel chính
		contentPane.setBackground(SystemColor.control); // Màu xanh nhạt dịu dàng
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 648, 39);
		panel.setBackground(SystemColor.control); // Cùng màu nền
		contentPane.add(panel);

		JLabel lblChuyenBan = new JLabel("TÁCH BÀN");
		lblChuyenBan.setBackground(SystemColor.windowText);
		lblChuyenBan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChuyenBan.setForeground(SystemColor.textHighlight); // Màu xám nhẹ
		panel.add(lblChuyenBan);

		JLabel lblNewLabel = new JLabel("Bạn đã chọn món: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(15, 52, 149, 33);
		contentPane.add(lblNewLabel);

		lblTenMon = new JLabel("z");
		lblTenMon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTenMon.setBounds(156, 50, 369, 36);
		contentPane.add(lblTenMon);

		JLabel lblNewLabel_1 = new JLabel("Số lượng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(528, 50, 75, 38);
		contentPane.add(lblNewLabel_1);

		lblSoLuong = new JLabel("1");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSoLuong.setBounds(607, 50, 46, 38);
		contentPane.add(lblSoLuong);

		JLabel lblTuKhu = new JLabel("Từ khu:");
		lblTuKhu.setBackground(SystemColor.infoText);
		lblTuKhu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTuKhu.setBounds(128, 90, 58, 39);
		lblTuKhu.setForeground(SystemColor.infoText); // Màu xám nhẹ
		contentPane.add(lblTuKhu);

		KhuVucBanDAO khuVucBanDAO = new KhuVucBanDAO();
		List<String> khuVucBans = khuVucBanDAO.getAllTenKhuVucBan();

		JLabel lblBan = new JLabel("Bàn: ");
		lblBan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBan.setBounds(360, 90, 75, 39);
		lblBan.setForeground(SystemColor.infoText); // Màu xám nhẹ
		contentPane.add(lblBan);
		
		 lblKhu1 = new JLabel("z");
		lblKhu1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblKhu1.setBounds(196, 97, 135, 25);
		contentPane.add(lblKhu1);
		
		 lblBan1 = new JLabel("z");
		lblBan1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBan1.setBounds(426, 97, 177, 25);
		contentPane.add(lblBan1);
		

	}
	public void setThongTinMon(String thongTinMon) {
	    // Giả sử thongTinMon có dạng "Tên món|Số lượng|Khu vực|Bàn"
	    String[] parts = thongTinMon.split("\\|");
	    if (parts.length == 4) {
	        String tenMon = parts[0];
	        String soLuong = parts[1];
	        String khu = parts[2];
	        String ban = parts[3];

	        // Cập nhật các thành phần giao diện
	        lblTenMon.setText(tenMon);
	        lblSoLuong.setText(soLuong);
	        lblKhu1.setText(khu);
	        lblBan1.setText(ban);

	    } else {
	        JOptionPane.showMessageDialog(this, "Thông tin món không đúng định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}