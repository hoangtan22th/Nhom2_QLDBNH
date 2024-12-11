package gui;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // Import ArrayList
import java.util.List;
import java.util.Properties;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dao.BanDAO;
import dao.KhuVucBanDAO;
import entity.Ban;
import entity.KhuVucBan;

import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;

public class PanelTimKiemBanTrong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaBan;

	private ArrayList<String> banNames; // Danh sách tên bàn
	private static JTextField txtTen;
	private static JTextField txtSo;
	private static JPanel pnlBan;
	private ButtonGroup group_1;
	private static JComboBox cbThuong;
	private static JRadioButton rdbThuong;
	private static JRadioButton rdbVIP;
	private JLabel lblLoaiBan;
	private JLabel lblTen;
	private ButtonGroup buttonGroup;
	private static JLabel lblMaBan;
	private static JLabel lblMa;
	private JTextField txtTim;
	private JButton btnTim;

	public PanelTimKiemBanTrong() {
		setLayout(null);
		createHeaderLabels();
		createInputPanel();
	}

	private void createHeaderLabels() {
		Label lblTT = new Label("Thông tin");
		lblTT.setBackground(new Color(65, 41, 224));
		lblTT.setBounds(10, 10, 150, 40);
		add(lblTT);
		lblTT.setAlignment(Label.CENTER);
		lblTT.setForeground(Color.WHITE);
		lblTT.setFont(new Font("Arial", Font.BOLD, 17));
	}

	private void createInputPanel() {
		JPanel pnlTT = new JPanel();
		pnlTT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, new Color(160, 160, 160)),
				"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		pnlTT.setBounds(10, 150, 371, 789);
		add(pnlTT);
		pnlTT.setLayout(null);

		// Create the radio buttons

		JTextPane txpGhiChu = new JTextPane();
		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		panel.setBounds(10, 273, 351, 99);
		panel.setLayout(null);
		txpGhiChu.setBounds(0, 0, 348, 96);
		panel.add(txpGhiChu);
		pnlTT.add(panel);

		lblLoaiBan = new JLabel("Loại bàn");
		lblLoaiBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoaiBan.setBounds(10, 10, 103, 35);
		pnlTT.add(lblLoaiBan);

		lblTen = new JLabel("Tên bàn");
		lblTen.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTen.setBounds(10, 141, 70, 21);
		pnlTT.add(lblTen);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setColumns(10);
		txtTen.setBounds(10, 173, 202, 35);
		pnlTT.add(txtTen);

		JLabel lblSoCho = new JLabel("Số chỗ");
		lblSoCho.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSoCho.setBounds(251, 141, 70, 21);
		pnlTT.add(lblSoCho);

		txtSo = new JTextField();
		txtSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSo.setBounds(222, 173, 139, 35);
		pnlTT.add(txtSo);
		txtSo.setColumns(10);

		cbThuong = new JComboBox();
		cbThuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbThuong.setBounds(10, 95, 351, 35);
		pnlTT.add(cbThuong);

		JLabel lblKhuVucBan = new JLabel("Khu vực");
		lblKhuVucBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhuVucBan.setBounds(10, 54, 97, 30);
		pnlTT.add(lblKhuVucBan);
		KhuVucBanDAO khuVucBanDAO = new KhuVucBanDAO();
		List<String> khuVucBans = khuVucBanDAO.getAllTenKhuVucBan();

		for (String khuVucBan : khuVucBans) {
			cbThuong.addItem(khuVucBan);
		}

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhiChu.setBounds(10, 230, 70, 21);
		pnlTT.add(lblGhiChu);

		buttonGroup = new ButtonGroup();

		rdbThuong = new JRadioButton("Bàn thường");
		rdbThuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbThuong.setBounds(119, 16, 109, 23);
		pnlTT.add(rdbThuong);

		buttonGroup.add(rdbThuong);

		rdbVIP = new JRadioButton("Bàn VIP");
		rdbVIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbVIP.setBounds(252, 16, 109, 23);
		pnlTT.add(rdbVIP);

		buttonGroup.add(rdbVIP);

		pnlBan = new JPanel();
		pnlBan.setBounds(390, 11, 1524, 928);
		add(pnlBan);
		pnlBan.setLayout(new GridLayout(0, 1, 6, 15));

		lblMaBan = new JLabel("Mã bàn:");
		lblMaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaBan.setBounds(11, 111, 53, 28);
		add(lblMaBan);

		lblMa = new JLabel("");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMa.setBounds(72, 111, 88, 28);
		add(lblMa);

		txtTim = new JTextField();
		txtTim.setBounds(10, 60, 275, 40);
		add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setForeground(new Color(255, 255, 255));
		btnTim.setBackground(new Color(14, 243, 7));
		btnTim.setFont(new Font("Arial", Font.BOLD, 12));
		btnTim.setBounds(292, 60, 89, 40);
		add(btnTim);

		btnTim.addActionListener(this);
		loadBanButtons1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTim) {
			searchTable(txtTim.getText().trim());
		}
	}

	public static void loadBanButtons1() {
		BanDAO banDAO = new BanDAO();
		List<Ban> listBan = banDAO.getAllBans();

		pnlBan.removeAll(); // Xóa tất cả các nút hiện tại trong panel

		pnlBan.setLayout(new GridLayout(0, 4, 10, 10)); // Sắp xếp lại các nút theo lưới

		for (Ban ban : listBan) {
			String buttonLabel = ban.getTenBan() + " - " + ban.getSoChoNgoi() + " chỗ";
			JButton btnBan = new JButton(buttonLabel);

			// Đặt màu sắc dựa trên trạng thái của bàn
			if (ban.isTrangThai()) {
				btnBan.setBackground(new Color(255, 165, 0)); // Màu cam nếu bàn đã có ChiTietPhieuDat
			} else {
				btnBan.setBackground(new Color(0, 117, 225)); // Màu xanh dương nếu bàn trống
			}

			btnBan.setForeground(Color.WHITE); // Đặt màu chữ trắng để dễ nhìn

			// Gắn sự kiện click để hiển thị thông tin bàn khi nhấn nút
			btnBan.addActionListener(e -> {
				loadBanInfo1(ban); // Gọi phương thức hiển thị thông tin bàn
			});

			pnlBan.add(btnBan); // Thêm nút bàn vào panel
		}

		// Cập nhật lại giao diện
		pnlBan.revalidate();
		pnlBan.repaint();
		cbThuong.revalidate();
		cbThuong.repaint();

	}

	private static void loadBanInfo1(Ban ban) {
		txtTen.setText(ban.getTenBan());
		txtSo.setText(String.valueOf(ban.getSoChoNgoi()));
		lblMa.setText(ban.getMaBan());

		cbThuong.setSelectedItem(ban.getKhuVucBan().getTenKhu());

		if (ban.getLoaiBan()) {
			rdbVIP.setSelected(true);
		} else {
			rdbThuong.setSelected(true);
		}
//	    	JOptionPane.showMessageDialog(null, ban.getTenBan());
	}

	public void searchTable(String searchTerm) {
		BanDAO banDAO = new BanDAO();
		List<Ban> searchResults = banDAO.searchBans(searchTerm);

		pnlBan.removeAll(); // Remove all current buttons

		if (searchResults.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy bàn với tên hoặc mã đó", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			for (Ban ban : searchResults) {
				String buttonLabel = ban.getTenBan() + " - " + ban.getSoChoNgoi() + " chỗ";
				JButton btnBan = new JButton(buttonLabel);

				// Đặt màu sắc dựa trên trạng thái của bàn
				if (ban.isTrangThai()) {
					btnBan.setBackground(new Color(255, 165, 0)); // Màu cam nếu bàn đã có ChiTietPhieuDat
				} else {
					btnBan.setBackground(new Color(0, 117, 225)); // Màu xanh dương nếu bàn trống
				}

				btnBan.setForeground(Color.WHITE); // Đặt màu chữ trắng để dễ nhìn

				// Gắn sự kiện click để hiển thị thông tin bàn khi nhấn nút
				btnBan.addActionListener(e -> {
					loadBanInfo1(ban); // Gọi phương thức hiển thị thông tin bàn
					// Select the clicked button (if needed for some visual indication)
					selectTable(ban);
				});

				pnlBan.add(btnBan); // Thêm nút bàn vào panel
			}

			// Cập nhật lại giao diện
			pnlBan.revalidate();
			pnlBan.repaint();
		}
	}

	// Method to select a specific table
	private void selectTable(Ban ban) {
		for (Component comp : pnlBan.getComponents()) {
			JButton btnBan = (JButton) comp;
			if (btnBan.getText().startsWith(ban.getTenBan())) {
				btnBan.setSelected(true); // Mark this button as selected
			} else {
				btnBan.setSelected(false); // Deselect all other buttons
			}
		}
	}

}
