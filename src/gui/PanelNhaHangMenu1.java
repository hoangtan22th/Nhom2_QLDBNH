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

public class PanelNhaHangMenu1 extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel_6;
	private JButton btnChuyenBan;
	private JButton btnGhepBan;
	private JComboBox cbThuong;
	private JPanel pnDanhSachBan;
	private JButton btnTatCa;
	private JButton btnBan;
	public static String luuTenBan;
	private JButton btnHuyDatBan;
	private JButton btnThemTiepMon;
	private JButton btnDatBan;
	private JButton btnThanhToan;

	public PanelNhaHangMenu1() {
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

		JLabel lblNhanVien = new JLabel("Nguyễn Văn Chính Xác");
		lblNhanVien.setBounds(10, 11, 188, 55);
		panel_1.add(lblNhanVien);

		JLabel lblKhachHang = new JLabel("");
		lblKhachHang.setBounds(218, 11, 188, 55);
		panel_1.add(lblKhachHang);

		JLabel lblSoLuongKhach = new JLabel("");
		lblSoLuongKhach.setBounds(432, 11, 188, 55);
		panel_1.add(lblSoLuongKhach);

		JLabel lblThoiGianDen = new JLabel("");
		lblThoiGianDen.setBounds(643, 10, 153, 56);
		panel_1.add(lblThoiGianDen);

		lblKhachHang.setBorder(BorderFactory.createTitledBorder("Khách hàng"));
		lblNhanVien.setBorder(BorderFactory.createTitledBorder("Nhân viên"));
		lblSoLuongKhach.setBorder(BorderFactory.createTitledBorder("Số lượng khách"));
		lblThoiGianDen.setBorder(BorderFactory.createTitledBorder("Thời gian đến"));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(81, 163, 806, 599);
		panel_2.setBackground(new Color(240, 240, 240));
		add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 786, 588);
		panel_2.add(scrollPane);

		table = new JTable();

		table.setRowHeight(30);

		DefaultTableModel model = new DefaultTableModel(new Object[][] { { null, null, null }

		}, new String[] { "Số Lượng", "Hàng Bán", "Tiền Hàng" });
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);

		scrollPane.setViewportView(table);

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
		panel_6.setBounds(940, 773, 768, 157);
		add(panel_6);
		panel_6.setLayout(null);
		btnChuyenBan = new JButton("Chuyển bàn");
		btnChuyenBan.setForeground(Color.WHITE);
		btnChuyenBan.setBackground(new Color(0, 117, 225));
		btnChuyenBan.setBounds(10, 70, 163, 53);
		panel_6.add(btnChuyenBan);

		btnGhepBan = new JButton("Ghép bàn");
		btnGhepBan.setForeground(Color.WHITE);
		btnGhepBan.setBackground(new Color(226, 141, 14));
		btnGhepBan.setBounds(183, 70, 163, 53);
		panel_6.add(btnGhepBan);

		JButton btnNewButton_16 = new JButton("Tách bàn");
		btnNewButton_16.setForeground(Color.WHITE);

		btnNewButton_16.setBackground(new Color(226, 141, 14));
		btnNewButton_16.setBounds(356, 70, 163, 53);
		panel_6.add(btnNewButton_16);

		JButton btnPhieuKiemMon = new JButton("Phiếu kiểm món");
		btnPhieuKiemMon.setForeground(Color.WHITE);
		btnPhieuKiemMon.setBackground(new Color(209, 14, 226));
		btnPhieuKiemMon.setBounds(529, 7, 163, 53);
		panel_6.add(btnPhieuKiemMon);

		btnHuyDatBan = new JButton("Huỷ đặt bàn");
		btnHuyDatBan.setForeground(Color.WHITE);
		btnHuyDatBan.setBackground(new Color(250, 128, 114));
		btnHuyDatBan.setBounds(529, 70, 163, 53);
		panel_6.add(btnHuyDatBan);

		btnThemTiepMon = new JButton("Thêm món ");
		btnThemTiepMon.setForeground(Color.WHITE);
		btnThemTiepMon.setBackground(new Color(14, 48, 226));
		btnThemTiepMon.setBounds(183, 7, 163, 53);
		panel_6.add(btnThemTiepMon);
		
		btnDatBan = new JButton("Đặt bàn");
		btnDatBan.setForeground(Color.WHITE);
		btnDatBan.setBackground(new Color(14, 48, 226));
		btnDatBan.setBounds(10, 7, 163, 53);
		panel_6.add(btnDatBan);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setBackground(new Color(14, 48, 226));
		btnThanhToan.setBounds(356, 7, 163, 53);
		panel_6.add(btnThanhToan);

		btnChuyenBan.addActionListener(this);
		btnGhepBan.addActionListener(this);
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
					ThemMon.luuMaBan = ban.getMaBan();
					PhieuDat.maBan = ban.getMaBan();
					if (ban.isTrangThai()) {
						ChiTietPhieuDatDAO ctpdd = new ChiTietPhieuDatDAO();
						List<ChiTietPhieuDat> chiTietList = ctpdd.layChiTietPhieuDat(ThemMon.luuMaBan);

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);

						for (ChiTietPhieuDat chiTiet : chiTietList) {
							int soLuong = chiTiet.getSoLuong();
							MonAnUong monAnUong = chiTiet.getMonAnUong();

							model.addRow(new Object[] { soLuong, monAnUong.getTenMonAnUong(),
									monAnUong.getGiaTien() * soLuong });
						}

						table.revalidate();
						table.repaint();
					} else {

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
					}
				}
			});

		}

		pnDanhSachBan.revalidate();
		pnDanhSachBan.repaint();

		btnTatCa.addActionListener(this);
		btnHuyDatBan.addActionListener(this);
		btnDatBan.addActionListener(this);

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
	            ThemMon.luuMaBan = ban.getMaBan();
				PhieuDat.maBan = ban.getMaBan();
				if (ban.isTrangThai()) {
					ChiTietPhieuDatDAO ctpdd = new ChiTietPhieuDatDAO();
					List<ChiTietPhieuDat> chiTietList = ctpdd.layChiTietPhieuDat(ThemMon.luuMaBan);

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);

					for (ChiTietPhieuDat chiTiet : chiTietList) {
						int soLuong = chiTiet.getSoLuong();
						MonAnUong monAnUong = chiTiet.getMonAnUong();

						model.addRow(new Object[] { soLuong, monAnUong.getTenMonAnUong(),
								monAnUong.getGiaTien() * soLuong });
					}

					table.revalidate();
					table.repaint();
				} else {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
				}
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
		// TODO Auto-generated method stub
		if (e.getSource() == btnChuyenBan) {
			new ChuyenBan().setVisible(true);
		} else if (e.getSource() == btnGhepBan) {

			new GhepBan().setVisible(true);
		} 
		else if(e.getSource() == btnDatBan) {
			new PhieuDat().setVisible(true);
			PhieuDat.setThongTinPhieuDat(PhieuDat.maBan);
			
			
			
		}
		else if(e.getSource()==btnHuyDatBan) {
			BanDAO bd = new BanDAO();
			bd.huyDatBan(ThemMon.luuMaBan);
			JOptionPane.showMessageDialog(this, "Huỷ đặt bàn thành công!");
		}
		else if (e.getSource() == cbThuong) {

			 String selectedKhu = (String) cbThuong.getSelectedItem();
		        updateBanList(selectedKhu);
		
		} else if (e.getSource() == btnTatCa) {
			BanDAO banDAO = new BanDAO();
			List<Ban> bans = banDAO.getAllBans();

			pnDanhSachBan.removeAll();
			pnDanhSachBan.revalidate();
			pnDanhSachBan.repaint();

			for (Ban ban : bans) {
				JButton button = new JButton(ban.getTenBan());
				button.setForeground(new Color(255, 255, 255));
				button.setBackground(new Color(0, 117, 225));

				button.setToolTipText("Mã bàn: " + ban.getMaBan());
				pnDanhSachBan.add(button);
			}

			pnDanhSachBan.revalidate();
			pnDanhSachBan.repaint();
		} 

	}
}
