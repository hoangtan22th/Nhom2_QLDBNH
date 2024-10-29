package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GhepBan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GhepBan frame = new GhepBan();
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
	public GhepBan() {
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
        
        JComboBox<String> cbTuKhu = new JComboBox<>();
        cbTuKhu.setModel(new DefaultComboBoxModel<>(new String[] {"Khu thường 1", "Khu thường 2", "Khu thường 3"}));
        cbTuKhu.setBounds(174, 77, 112, 39);
        cbTuKhu.setBackground(new Color(245, 245, 245)); // Màu nền cho combo box
        cbTuKhu.setForeground(SystemColor.windowBorder); // Màu chữ xám
        contentPane.add(cbTuKhu);
        
        JLabel lblDenKhu = new JLabel("Đến khu:");
        lblDenKhu.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblDenKhu.setBounds(325, 74, 75, 39);
        lblDenKhu.setForeground(SystemColor.infoText); // Màu xám nhẹ
        contentPane.add(lblDenKhu);
        
        JComboBox<String> cbTuKhu_1 = new JComboBox<>();
        cbTuKhu_1.setModel(new DefaultComboBoxModel<>(new String[] {"Khu thường 2"}));
        cbTuKhu_1.setBounds(410, 77, 112, 39);
        cbTuKhu_1.setBackground(new Color(245, 245, 245)); // Màu nền combo box
        cbTuKhu_1.setForeground(new Color(105, 105, 105)); // Màu chữ xám
        contentPane.add(cbTuKhu_1);
        
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
        
        JComboBox<String> cbTuKhu_2 = new JComboBox<>();
        cbTuKhu_2.setModel(new DefaultComboBoxModel<>(new String[] {"Bàn Naruto"}));
        cbTuKhu_2.setBounds(174, 153, 112, 36);
        cbTuKhu_2.setBackground(new Color(245, 245, 245));
        cbTuKhu_2.setForeground(new Color(105, 105, 105));
        contentPane.add(cbTuKhu_2);
        
        JComboBox<String> cbTuKhu_3 = new JComboBox<>();
        cbTuKhu_3.setModel(new DefaultComboBoxModel<>(new String[] {"Bàn Sasuke"}));
        cbTuKhu_3.setBounds(410, 149, 112, 39);
        cbTuKhu_3.setBackground(new Color(245, 245, 245));
        cbTuKhu_3.setForeground(new Color(105, 105, 105));
        contentPane.add(cbTuKhu_3);
        
        JButton btnDongY = new JButton("ĐỒNG Ý");
        btnDongY.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDongY.setBounds(237, 224, 183, 46);
        btnDongY.setBackground(SystemColor.textHighlight); // Màu xanh dương nhạt
        btnDongY.setForeground(Color.WHITE); // Chữ trắng
        contentPane.add(btnDongY);
	}

}
