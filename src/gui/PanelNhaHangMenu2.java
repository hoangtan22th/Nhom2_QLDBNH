package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.BanDAO;
import dao.KhuVucBanDAO;
import entity.Ban;
import entity.KhuVucBan;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelNhaHangMenu2 extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel_6;
	private JComboBox cbThuong;
	private JPanel pnDanhSachBan;
	private JButton btnTatCa;
	private JButton btnBan;
	private JButton btnThemMon;
	public static String luuTenBan;
	public String LUUMABAN;
	public PanelNhaHangMenu2() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(81, 0, 161, 64);
		panel.setBackground(new Color(240, 240, 240));
		
		add(panel);
		panel.setLayout(null);

		JLabel lblPhieu = new JLabel("Phiếu");
		lblPhieu.setForeground(new Color(255, 255, 255));
		lblPhieu.setBackground(new Color(226, 141, 14));
		lblPhieu.setOpaque(true); 
		lblPhieu.setBounds(10, 11, 141, 42);

		panel.add(lblPhieu);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(81, 75, 806, 77);
		panel_1.setBackground(new Color(240, 240, 240));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNhanVien = new JLabel("Nguyễn Văn A");
		lblNhanVien.setBounds(10, 11, 188, 55);
		panel_1.add(lblNhanVien);
		lblNhanVien.setBorder(BorderFactory.createTitledBorder("Nhân viên"));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(81, 163, 806, 599);
		panel_2.setBackground(new Color(240, 240, 240));
		add(panel_2);
		panel_2.setLayout(null);

	
		DefaultTableModel model = new DefaultTableModel(new Object[][] { { "abc", null, null }

		}, new String[] { "Số Lượng", "Hàng Bán", "Tiền Hàng" });

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(81, 773, 742, 70);
		panel_3.setBackground(new Color(240, 240, 240));
		add(panel_3);
		panel_3.setLayout(null);

		JLabel lblDaDat = new JLabel("Đã đặt");
		lblDaDat.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblDaDat.setForeground(new Color(255, 255, 255));
		lblDaDat.setBackground(new Color(226, 141, 14));
		lblDaDat.setOpaque(true);
		lblDaDat.setBounds(10, 11, 191, 48);
		panel_3.add(lblDaDat);

		JLabel lblTrong = new JLabel("Trống");
		lblTrong.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTrong.setForeground(new Color(255, 255, 255));
		lblTrong.setBackground(new Color(0, 117, 225));
		lblTrong.setOpaque(true);
		lblTrong.setBounds(211, 11, 182, 48);
		panel_3.add(lblTrong);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setBounds(930, 31, 778, 118);
		add(panel_4);
		panel_4.setLayout(null);

		btnTatCa = new JButton("Tất cả");
		btnTatCa.setForeground(new Color(255, 255, 255));
		btnTatCa.setBackground(new Color(14, 48, 226)); // Màu 0E30E2

		btnTatCa.setBounds(277, 11, 234, 101);
		panel_4.add(btnTatCa);

		cbThuong = new JComboBox<>();
		cbThuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbThuong.setBounds(10, 11, 234, 101);
		panel_4.add(cbThuong);

		KhuVucBanDAO khuVucBanDAO = new KhuVucBanDAO();
		List<String> khuVucBans = khuVucBanDAO.getAllTenKhuVucBan();

		for (String khuVucBan : khuVucBans) {
			cbThuong.addItem(khuVucBan);
		}

		pnDanhSachBan = new JPanel();
		pnDanhSachBan.setBackground(new Color(240, 240, 240));
		pnDanhSachBan.setBounds(940, 165, 768, 586);
		add(pnDanhSachBan);
		pnDanhSachBan.setLayout(new GridLayout(0, 4, 15, 15));

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 240, 240));
		panel_6.setBounds(940, 773, 768, 164);
		add(panel_6);
		panel_6.setLayout(null);

		btnThemMon = new JButton("Thêm món");
		btnThemMon.setForeground(Color.WHITE);
		btnThemMon.setBackground(new Color(14, 48, 226));
		btnThemMon.setBounds(0, 6, 146, 53);
		panel_6.add(btnThemMon);
		cbThuong.addActionListener(this);
		btnThemMon.addActionListener(this);
		
		String firstKhuTen = cbThuong.getItemAt(0).toString();
		BanDAO banDAO = new BanDAO();
		List<Ban> listBan = banDAO.getBansByKhu(firstKhuTen);
		Map<String, JButton> mapBan = new HashMap<>();
		pnDanhSachBan.removeAll();
		for (Ban ban : listBan) {
		   
			String buttonLabel = "<html><center>" + ban.getTenBan() + " - " + ban.getSoChoNgoi() + " chỗ</center></html>";
		               
		  
		    ImageIcon originalIcon = new ImageIcon("img/iconBanAn.png");
			Image image = originalIcon.getImage(); 
			Image resizedImage = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH); 
			ImageIcon resizedIcon = new ImageIcon(resizedImage);
		    JButton btnBan = new JButton(buttonLabel, resizedIcon);
		    btnBan.setForeground(new Color(255, 255, 255));  
		    if (ban.isTrangThai()) {
		        btnBan.setBackground(new Color(255, 165, 0)); // Màu cam
		    } else {
		        btnBan.setBackground(new Color(0, 117, 225)); // Màu xanh
		    }   
   

		    
		    pnDanhSachBan.add(btnBan);

		  
		    mapBan.put(ban.getTenBan(), btnBan);

		
		    btnBan.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		           
//		            System.out.println("Đã chọn bàn: " + ban.getTenBan() + 
//		                               ", Số chỗ ngồi: " + ban.getSoChoNgoi() + 
//		                               ", Trạng thái: " + (ban.isTrangThai() ? "Đã đặt" : "Chưa đặt") +
//		                               ", Loại bàn: " + (ban.getLoaiBan() ? "VIP" : "Thường") +
//		                               ", Thời gian đặt: " + ban.getThoiGianDatBan());
//		        	JOptionPane.showMessageDialog(null, "Bạn đã chọn bàn: "+ban.getTenBan());
		            ThemMon.luuMaBan = ban.getMaBan();
		     
		        }
		    });
		}

		pnDanhSachBan.revalidate();
		pnDanhSachBan.repaint();

		btnTatCa.addActionListener(this);

	}
   
	@Override
	public void actionPerformed(ActionEvent e) {



	}
}
