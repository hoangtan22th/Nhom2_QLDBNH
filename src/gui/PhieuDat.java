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

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Properties;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextField;

public class PhieuDat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelChinh;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JDatePickerImpl datePicker;
	private JLabel lblSCh_1;
	private JLabel lblSCh_2;
	private JLabel lblMBn;
	private JTextField textField_3;


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
		
		textField = new JTextField();
		textField.setBounds(143, 138, 149, 29);
		panelChinh.add(textField);
		textField.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(21, 193, 105, 30);
		panelChinh.add(lblTnKhchHng);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 196, 149, 29);
		panelChinh.add(textField_1);
		
		JLabel lblSCh = new JLabel("Số chỗ:");
		lblSCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCh.setBounds(322, 193, 105, 30);
		panelChinh.add(lblSCh);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(464, 193, 149, 29);
		panelChinh.add(textField_2);
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
        
        JButton btnNewButton = new JButton("Xác nhận");
        btnNewButton.setBackground(new Color(255, 140, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(508, 295, 105, 35);
        panelChinh.add(btnNewButton);
        
        lblMBn = new JLabel("Mã bàn:");
        lblMBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMBn.setBounds(21, 78, 105, 30);
        panelChinh.add(lblMBn);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(143, 78, 149, 29);
        panelChinh.add(textField_3);
	}
}
