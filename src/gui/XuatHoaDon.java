package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class XuatHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XuatHoaDon frame = new XuatHoaDon();
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
	public XuatHoaDon() {
	
		setBounds(100, 100, 522, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HARU SUSHI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(179, 11, 222, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("211 - 213 Phan Xích Long, Phường 2, Phú Nhuận, Hồ Chí Minh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(48, 62, 426, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHonThanh = new JLabel("HOÁ ĐƠN THANH TOÁN");
		lblHonThanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHonThanh.setBounds(127, 99, 222, 25);
		contentPane.add(lblHonThanh);
		
		JLabel lblNewLabel_2 = new JLabel("Số HĐ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 133, 82, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("123456789");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(104, 135, 179, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày lập:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 184, 82, 30);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Bàn:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(10, 238, 82, 30);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Nhân viên:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setBounds(308, 135, 82, 30);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("123456789");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(398, 133, 179, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Giờ ra");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1_1.setBounds(308, 184, 82, 30);
		contentPane.add(lblNewLabel_2_2_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 298, 475, 271);
		contentPane.add(scrollPane);

		// Tạo JTable với mô hình dữ liệu mặc định
		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {
		        // Dữ liệu mẫu (có thể thay thế với dữ liệu thực tế)
		     
		    },
		    new String[] {
		    		"Tên Món", "Số lượng", "Đơn giá", "Thành tiền"
		    }
		));

		// Đặt JTable làm nội dung (viewport) của JScrollPane
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2_3 = new JLabel("Tổng cộng:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(10, 592, 129, 30);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblTongTien = new JLabel("123.000đ");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTongTien.setBounds(136, 589, 213, 36);
		contentPane.add(lblTongTien);
		
		JLabel lblNewLabel_3 = new JLabel("Chúc quý khách vui vẻ hẹn gặp lại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(130, 655, 343, 36);
		contentPane.add(lblNewLabel_3);

	}
}
