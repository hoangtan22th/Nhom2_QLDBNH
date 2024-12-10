package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.jcalendar.model.JCalModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextField;

public class PhieuDat extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelChinh;
	private JTextField txtTenNhanVien;
	private JTextField txtTenKhachHang;
	private JTextField txtSoCho;
	private JDatePickerImpl datePicker;
	private JLabel lblSCh_1;
	private JLabel lblSCh_2;
	private JLabel lblMBn;
	private static JTextField txtMaBan;
	private JTextField txtTienCoc;
	private JButton btnXacNhan;
	public static String maBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuDat frame = new PhieuDat();
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
	public PhieuDat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 400);
		panelChinh = new JPanel();
		panelChinh.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelChinh);
		panelChinh.setLayout(null);
		
		JLabel lblPhieuDat = new JLabel("Phiếu Đặt");
		lblPhieuDat.setForeground(new Color(30, 144, 255));
		lblPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPhieuDat.setBounds(296, 11, 131, 50);
		panelChinh.add(lblPhieuDat);
		
		JLabel lblNewLabel = new JLabel("Tên nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 135, 105, 30);
		panelChinh.add(lblNewLabel);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(143, 138, 149, 29);
		panelChinh.add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(21, 193, 105, 30);
		panelChinh.add(lblTnKhchHng);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(143, 196, 149, 29);
		panelChinh.add(txtTenKhachHang);
		
		JLabel lblSCh = new JLabel("Số chỗ:");
		lblSCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCh.setBounds(322, 193, 105, 30);
		panelChinh.add(lblSCh);
		
		txtSoCho = new JTextField();
		txtSoCho.setColumns(10);
		txtSoCho.setBounds(464, 193, 149, 29);
		panelChinh.add(txtSoCho);
		// Date picker setup
        UtilDateModel modelDate = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hôm nay");
        properties.put("text.month", "Tháng");
        properties.put("text.year", "Năm");

        JDatePanelImpl datePanel = new JDatePanelImpl(modelDate, properties);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Tải icon từ đường dẫn
        ImageIcon calendarIcon = new ImageIcon("img/lich.png");

        // Lấy nút của datePicker và đặt icon cho nó
        JButton calendarButton = (JButton) datePicker.getComponent(1); // Lấy nút calendar
        calendarButton.setIcon(calendarIcon);

        // Set vị trí và kích thước của datePicker
        datePicker.setBounds(464, 78, 149, 35);
        panelChinh.add(datePicker);

        // Đặt kích thước và font chữ cho trường nhập ngày
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePicker.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));
        
        lblSCh_1 = new JLabel("Thời gian kết thúc:");
        lblSCh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSCh_1.setBounds(322, 135, 131, 30);
        panelChinh.add(lblSCh_1);
        
     // Date picker setup
        UtilDateModel modelDate1 = new UtilDateModel();
        Properties properties1 = new Properties();
        properties.put("text.today", "Hôm nay");
        properties.put("text.month", "Tháng");
        properties.put("text.year", "Năm");

        JDatePanelImpl datePanel1 = new JDatePanelImpl(modelDate1, properties1);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Tải icon từ đường dẫn
        ImageIcon calendarIcon1 = new ImageIcon("img/lich.png");

        // Lấy nút của datePicker và đặt icon cho nó
        JButton calendarButton1 = (JButton) datePicker.getComponent(1); // Lấy nút calendar
        calendarButton.setIcon(calendarIcon1);

        // Set vị trí và kích thước của datePicker
        datePicker.setBounds(464, 135, 149, 35);
        panelChinh.add(datePicker);

        // Đặt kích thước và font chữ cho trường nhập ngày
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePicker.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));
        
        lblSCh_2 = new JLabel("Thời gian bắt đầu đặt:");
        lblSCh_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSCh_2.setBounds(322, 83, 140, 30);
        panelChinh.add(lblSCh_2);
        
        btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setBackground(new Color(255, 140, 0));
        btnXacNhan.setForeground(new Color(255, 255, 255));
        btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnXacNhan.setBounds(508, 295, 105, 35);
        panelChinh.add(btnXacNhan);
        
        lblMBn = new JLabel("Mã bàn:");
        lblMBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMBn.setBounds(21, 78, 105, 30);
        panelChinh.add(lblMBn);
        
        txtMaBan = new JTextField();
        
        txtMaBan.setColumns(10);
        txtMaBan.setBounds(143, 78, 149, 29);
        panelChinh.add(txtMaBan);
        
        JLabel lblNewLabel_1 = new JLabel("Tiền cọc:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(21, 245, 105, 29);
        panelChinh.add(lblNewLabel_1);
        
        txtTienCoc = new JTextField();
        txtTienCoc.setBounds(143, 247, 149, 30);
        panelChinh.add(txtTienCoc);
        txtTienCoc.setColumns(10);
        
       
    
        
        
        
        
	}
	public static void setThongTinPhieuDat(String x) {
		txtMaBan.setText(x);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnXacNhan) {
			String tenKhachHang = txtTenKhachHang.getText();
			int soCho = Integer.parseInt(txtSoCho.getText());
			float tienCoc = Float.parseFloat(txtTienCoc.getText());
			
			
		}
		
	}
}
