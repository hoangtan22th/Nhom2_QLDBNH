package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.BanDAO;
import dao.ChiTietPhieuDatDAO;
import dao.KhuVucBanDAO;
import entity.Ban;
import entity.ChiTietPhieuDat;
import entity.KhuVucBan;
import entity.MonAnUong;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ChonBanDatTruoc extends JFrame implements ActionListener {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonBanDatTruoc frame = new ChonBanDatTruoc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static final long serialVersionUID = 1L;
	private JPanel panel_6;
	private JComboBox cbThuong;
	private JPanel pnDanhSachBan;
	private JButton btnBan;
	public static String luuTenBan;
	private JButton btnXacNhan;

	public ChonBanDatTruoc() {
		setBackground(new Color(240, 240, 240));
		setSize(825,950);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		DefaultTableModel model = new DefaultTableModel(new Object[][] { { null, null, null }

		}, new String[] { "Số Lượng", "Hàng Bán", "Tiền Hàng" });

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setBounds(38, 40, 778, 118);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

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
		pnDanhSachBan.setBounds(38, 180, 768, 586);
		getContentPane().add(pnDanhSachBan);
		pnDanhSachBan.setLayout(new GridLayout(0, 4, 15, 15));

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 240, 240));
		panel_6.setBounds(38, 778, 768, 86);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setBackground(new Color(14, 48, 226));
		btnXacNhan.setBounds(605, 11, 163, 53);
		panel_6.add(btnXacNhan);
		cbThuong.addActionListener(this);

		String firstKhuTen = cbThuong.getItemAt(0).toString();
		BanDAO banDAO = new BanDAO();
		List<Ban> listBan = banDAO.getBansByKhu(firstKhuTen);
		Map<String, JButton> mapBan = new HashMap<>();
		pnDanhSachBan.removeAll();
		for (Ban ban : listBan) {

			String buttonLabel = "<html><center>" + ban.getTenBan() + " - " + ban.getSoChoNgoi()
					+ " chỗ</center></html>";

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
					JOptionPane.showMessageDialog(null, "Bạn đã chọn bàn: " + ban.getTenBan());
					 PhieuDat.maBan =ban.getMaBan();
				}
			});

		}

		pnDanhSachBan.revalidate();
		pnDanhSachBan.repaint();
		btnXacNhan.addActionListener(this);

	}
	
	private JButton createBanButton(Ban ban) {
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

	    btnBan.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // xử lý sự kiện khi bàn được chọn
	            JOptionPane.showMessageDialog(null, "Bạn đã chọn bàn: " + ban.getTenBan());
	            PhieuDat.maBan =ban.getMaBan();
	        }
	    });

	    return btnBan;
	}
	private void updateBanList(String khuVuc) {
	    BanDAO banDAO = new BanDAO();
	    List<Ban> listBan = banDAO.getBansByKhu(khuVuc);
	    pnDanhSachBan.removeAll();

	    for (Ban ban : listBan) {
	        JButton btnBan = createBanButton(ban);
	        pnDanhSachBan.add(btnBan);
	    }

	    pnDanhSachBan.revalidate(); // Cập nhật giao diện
	    pnDanhSachBan.repaint();    // Vẽ lại panel
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbThuong) {

			 String selectedKhu = (String) cbThuong.getSelectedItem();
		        updateBanList(selectedKhu);
		
		} 
		else if (e.getSource()==btnXacNhan) {
//			new PhieuDat().setVisible(true);
			setVisible(false); 
			PhieuDat.setThongTinPhieuDat(PhieuDat.maBan);
			
		}
}}
