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

public class GhepBan extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDongY;
	private JComboBox<String> cbTuKhu,cbTuKhu_1,cbTuKhu_2,cbTuKhu_3;

	public GhepBan() {
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

		JLabel lblChuyenBan = new JLabel("GHÉP BÀN");
		lblChuyenBan.setBackground(SystemColor.windowText);
		lblChuyenBan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChuyenBan.setForeground(SystemColor.textHighlight); // Màu xám nhẹ
		panel.add(lblChuyenBan);

		JLabel lblTuKhu = new JLabel("Từ khu: ");
		lblTuKhu.setBackground(SystemColor.infoText);
		lblTuKhu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTuKhu.setBounds(102, 74, 62, 39);
		lblTuKhu.setForeground(SystemColor.infoText); // Màu xám nhẹ
		contentPane.add(lblTuKhu);

		cbTuKhu = new JComboBox<>();
		cbTuKhu.setModel(new DefaultComboBoxModel<>(new String[] { "" }));
		cbTuKhu.setBounds(174, 77, 112, 39);
		cbTuKhu.setBackground(new Color(245, 245, 245)); // Màu nền cho combo box
		cbTuKhu.setForeground(SystemColor.windowBorder); // Màu chữ xám
		contentPane.add(cbTuKhu);

		KhuVucBanDAO khuVucBanDAO = new KhuVucBanDAO();
		List<String> khuVucBans = khuVucBanDAO.getAllTenKhuVucBan();

		for (String khuVucBan : khuVucBans) {
			cbTuKhu.addItem(khuVucBan);
		}
		
		JLabel lblDenKhu = new JLabel("Đến khu:");
		lblDenKhu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDenKhu.setBounds(325, 74, 75, 39);
		lblDenKhu.setForeground(SystemColor.infoText); // Màu xám nhẹ
		contentPane.add(lblDenKhu);

		cbTuKhu_1 = new JComboBox<>();
		cbTuKhu_1.setModel(new DefaultComboBoxModel<>(new String[] { "" }));
		cbTuKhu_1.setBounds(410, 77, 112, 39);
		cbTuKhu_1.setBackground(new Color(245, 245, 245)); // Màu nền combo box
		cbTuKhu_1.setForeground(new Color(105, 105, 105)); // Màu chữ xám
		contentPane.add(cbTuKhu_1);
		
		KhuVucBanDAO khuVucBanDAO1 = new KhuVucBanDAO();
		List<String> khuVucBanss = khuVucBanDAO1.getAllTenKhuVucBan();

		for (String khuVucBan : khuVucBanss) {
			cbTuKhu_1.addItem(khuVucBan);
		}

		JLabel lblTBn = new JLabel("Từ bàn: ");
		lblTBn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTBn.setBounds(102, 149, 75, 39);
		lblTBn.setForeground(SystemColor.infoText); // Màu xám nhẹ
		contentPane.add(lblTBn);

		JLabel lblnBn = new JLabel("Đến bàn: ");
		lblnBn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblnBn.setBounds(325, 149, 75, 39);
		lblnBn.setForeground(SystemColor.infoText); // Màu xám nhẹ
		contentPane.add(lblnBn);

		cbTuKhu_2 = new JComboBox<>();
		cbTuKhu_2.setModel(new DefaultComboBoxModel<>(new String[] { "" }));
		cbTuKhu_2.setBounds(174, 153, 112, 36);
		cbTuKhu_2.setBackground(new Color(245, 245, 245));
		cbTuKhu_2.setForeground(new Color(105, 105, 105));
		contentPane.add(cbTuKhu_2);
		cbTuKhu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selecTenKhu = cbTuKhu.getSelectedItem().toString();
		        BanDAO banDAO = new BanDAO();

		        cbTuKhu_2.removeAllItems();

		        List<String> listBan = banDAO.getTenBansByKhu(selecTenKhu);
		        for (String ban : listBan) {
		            cbTuKhu_2.addItem(ban);
		        }
		    }
		});


		cbTuKhu_3 = new JComboBox<>();
		cbTuKhu_3.setModel(new DefaultComboBoxModel<>(new String[] { "" }));
		cbTuKhu_3.setBounds(410, 149, 112, 39);
		cbTuKhu_3.setBackground(new Color(245, 245, 245));
		cbTuKhu_3.setForeground(new Color(105, 105, 105));
		contentPane.add(cbTuKhu_3);
		cbTuKhu_1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selecTenKhu = cbTuKhu_1.getSelectedItem().toString();
		        BanDAO banDAO = new BanDAO();
		        cbTuKhu_3.removeAllItems();

		        List<String> listBan = banDAO.getTenBansByKhu(selecTenKhu);
		        for (String ban : listBan) {
		        	cbTuKhu_3.addItem(ban);
		        }
		    }
		});

		btnDongY = new JButton("ĐỒNG Ý");
		btnDongY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDongY.setBounds(237, 224, 183, 46);
		btnDongY.setBackground(SystemColor.textHighlight); // Màu xanh dương nhạt
		btnDongY.setForeground(Color.WHITE); // Chữ trắng
		contentPane.add(btnDongY);
		
		btnDongY.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnDongY) {
	        String tenTuBan = cbTuKhu_2.getSelectedItem() != null ? cbTuKhu_2.getSelectedItem().toString() : "";
	        String tenDenBan = cbTuKhu_3.getSelectedItem() != null ? cbTuKhu_3.getSelectedItem().toString() : "";

	        if (!tenTuBan.isEmpty() && !tenDenBan.isEmpty()) {
	            BanDAO banDAO = new BanDAO();
	            List<String> maTuBans = banDAO.getMaBanTheoTen(tenTuBan);
	            List<String> maDenBans = banDAO.getMaBanTheoTen(tenDenBan);

	            if (!maTuBans.isEmpty() && !maDenBans.isEmpty()) {
	                String maTuBan = maTuBans.get(0);
	                String maDenBan = maDenBans.get(0);
	                banDAO.ghepBan(maTuBan, maDenBan);
					banDAO.capNhatTrangThaiBan(maTuBan, false);
					banDAO.capNhatTrangThaiBan(maDenBan, true);
	            } else {
	                System.out.println("Vui lòng chọn bàn chuyển đi và bàn chuyển đến hợp lệ.");
	            }
	        } else {
	            System.out.println("Vui lòng chọn bàn chuyển đi và bàn chuyển đến.");
	        }
	    }
	}
}
//test