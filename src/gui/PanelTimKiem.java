package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTimKiem extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnlContainer; // Container for CardLayout

	/**
	 * Create the panel.
	 */
	public PanelTimKiem() {
		setLayout(null);

		Label lblTT = new Label("Tìm kiếm");
		lblTT.setBackground(new Color(65, 41, 224));
		lblTT.setBounds(20, 10, 124, 38);
		add(lblTT);
		lblTT.setForeground(new Color(255, 255, 255));
		lblTT.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblNewLabel = new JLabel("Chọn mục tìm kiếm");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(1407, 30, 178, 17);
		add(lblNewLabel);

		JComboBox<String> cbxTim = new JComboBox<>();
		cbxTim.setModel(new DefaultComboBoxModel<>(new String[] { "Tìm kiếm nhân viên", "Tìm kiếm khách hàng",
				"Tìm kiếm món ăn", "Tìm kiếm thẻ thành viên", "Tìm kiếm tài khoản", "Tìm kiếm bàn" }));
		cbxTim.setBounds(1543, 28, 275, 22);
		add(cbxTim);

		// Button to confirm selection
		JButton btnChon = new JButton("Chọn");
		btnChon.setForeground(new Color(255, 255, 255));
		btnChon.setBackground(new Color(0, 0, 255));
		btnChon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnChon.setBounds(1828, 27, 85, 23);
		add(btnChon);

		// Panel container with CardLayout
		pnlContainer = new JPanel(new CardLayout());
		pnlContainer.setBounds(10, 54, 1920, 1014);
		add(pnlContainer);

		// Add panels to CardLayout
		JPanel pnlDsThanhVien = new PanelDsThanhVien(); // Replace with your panel
		JPanel pnlTaiKhoan = new PanelTaiKhoanMenu(); // Replace with your panel
		JPanel pnlNhanVien = new PanelNhanVien();
		JPanel pnlKhachHang = new PanelKhachHang();
		JPanel pnlMonAn = new PanelQLMonAn();
		JPanel pnlBanTrong = new PanelTimKiemBanTrong();

		pnlContainer.add(pnlDsThanhVien, "DsThanhVien");
		pnlContainer.add(pnlTaiKhoan, "TaiKhoan");
		pnlContainer.add(pnlNhanVien, "NhanVien");
		pnlContainer.add(pnlKhachHang, "KhachHang");
		pnlContainer.add(pnlMonAn, "MonAn");
		pnlContainer.add(pnlBanTrong, "TimBanTrong");

		// Add ActionListener for the button
		btnChon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = cbxTim.getSelectedItem().toString();
				CardLayout cl = (CardLayout) pnlContainer.getLayout();

				if (selectedItem.equals("Tìm kiếm thẻ thành viên")) {
					cl.show(pnlContainer, "DsThanhVien");
				} else if (selectedItem.equals("Tìm kiếm tài khoản")) {
					cl.show(pnlContainer, "TaiKhoan");
				} else if (selectedItem.equals("Tìm kiếm nhân viên")) {
					cl.show(pnlContainer, "NhanVien");
				} else if (selectedItem.equals("Tìm kiếm khách hàng")) {
					cl.show(pnlContainer, "KhachHang");
				} else if (selectedItem.equals("Tìm kiếm món ăn")) {
					cl.show(pnlContainer, "MonAn");
				} else if (selectedItem.equals("Tìm kiếm bàn")) {
					cl.show(pnlContainer, "TimBanTrong");
				}
			}
		});
	}
}
