package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.jcalendar.model.JCalModel;

import dao.BanDAO;
import dao.ChiTietPhieuDatDAO;
import dao.PhieuDatBanDAO;
import entity.Ban;
import entity.ChiTietPhieuDat;
import entity.MonAnUong;
import entity.NhanVien;
import entity.PhieuDatBan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class PhieuDat extends JFrame implements ActionListener,MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelChinh;
	private JTextField txtTenNhanVien;
	private JTextField txtTenKhachHang;
	private JTextField txtSoCho;
	private JDatePickerImpl datePicker;
	private JLabel lblGioDat;
	private JLabel lblNgayDat;
	private static JTextField txtMaBan;
	private JTextField txtTienCoc;
	private JButton btnDatBan;
	
	public static String maBan;
	private JComboBox cbGioDat;
	private JTextField txtSdt;
	public static JTable tbMonAnTrenBan;

	private JLabel lblGhiChu;
	private JTextField textField;
	private JTable tbDanhSachPhieuDat;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_1;
	private JLabel lblLcTheoNgy;
	private JButton btnLoc;
	private JButton btnLamMoi;
	private JButton btnHuyPhieu;
	private JButton btnCapNhat;
	private JButton btnNhanBan;
	private JButton btnChonBan;
	private JButton btnChonMon;
	private JTextArea txtAGhiChu;
	public static DefaultTableModel modelMonAnTrenBan;
	private JTextField txtTrangThai;
	private JTextField txtPhieuDat;

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
		
		
		setBounds(100, 100, 1703, 1014);
		panelChinh = new JPanel();
		panelChinh.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(panelChinh);
		panelChinh.setLayout(null);
		
		JLabel lblPhieuDat = new JLabel("Phiếu Đặt");
		lblPhieuDat.setForeground(new Color(30, 144, 255));
		lblPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPhieuDat.setBounds(161, 11, 131, 50);
		panelChinh.add(lblPhieuDat);
		
		JLabel lblNewLabel = new JLabel("Tên nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 135, 105, 30);
		panelChinh.add(lblNewLabel);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(143, 138, 149, 29);
		txtTenNhanVien.setText("admin");
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
		txtTenKhachHang.setText("");
		JLabel lblSCh = new JLabel("Số chỗ:");
		lblSCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCh.setBounds(322, 193, 105, 30);
		panelChinh.add(lblSCh);
		
		txtSoCho = new JTextField();
		txtSoCho.setColumns(10);
		txtSoCho.setBounds(464, 195, 149, 30);
		txtSoCho.setText("");
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
        
        lblGioDat = new JLabel("Giờ đặt");
        lblGioDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGioDat.setBounds(322, 135, 131, 30);
        panelChinh.add(lblGioDat);
        
     // Date picker setup
        UtilDateModel modelDate1 = new UtilDateModel();
        Properties properties1 = new Properties();
        properties.put("text.today", "Hôm nay");
        properties.put("text.month", "Tháng");
        properties.put("text.year", "Năm");

        JDatePanelImpl datePanel1 = new JDatePanelImpl(modelDate1, properties1);

        // Tải icon từ đường dẫn
        ImageIcon calendarIcon1 = new ImageIcon("img/lich.png");
        calendarButton.setIcon(calendarIcon1);
        
        lblNgayDat = new JLabel("Ngày đặt");
        lblNgayDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNgayDat.setBounds(322, 83, 140, 30);
        panelChinh.add(lblNgayDat);
        
        btnDatBan = new JButton("Đặt bàn");
        btnDatBan.setBackground(new Color(255, 140, 0));
        btnDatBan.setForeground(new Color(255, 255, 255));
        btnDatBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDatBan.setBounds(1424, 875, 180, 50);
        panelChinh.add(btnDatBan);
        
        txtMaBan = new JTextField();
        
        txtMaBan.setColumns(10);
        txtMaBan.setBounds(143, 78, 149, 35);
        panelChinh.add(txtMaBan);
        
        JLabel lblNewLabel_1 = new JLabel("Tiền cọc:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(21, 245, 105, 29);
        panelChinh.add(lblNewLabel_1);
        
        txtTienCoc = new JTextField();
        txtTienCoc.setBounds(143, 247, 149, 30);
        panelChinh.add(txtTienCoc);
        txtTienCoc.setColumns(10);
        txtTienCoc.setText("");
        
      
     // Khởi tạo JComboBox và thêm vào giao diện
        cbGioDat = new JComboBox<>();
        cbGioDat.setBounds(464, 137, 149, 30);
        panelChinh.add(cbGioDat);
        
        JLabel lblSdt = new JLabel("Số điện thoại");
        lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSdt.setBounds(322, 244, 105, 30);
        panelChinh.add(lblSdt);
        
        txtSdt = new JTextField();
        txtSdt.setColumns(10);
        txtSdt.setBounds(464, 246, 149, 30);
        txtSdt.setText("");
        panelChinh.add(txtSdt);
        
        btnChonBan = new JButton("Chọn bàn");
        btnChonBan.setForeground(Color.WHITE);
        btnChonBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnChonBan.setBackground(new Color(255, 140, 0));
        btnChonBan.setBounds(21, 78, 105, 35);
        panelChinh.add(btnChonBan);
        
        btnChonMon = new JButton("Chọn món");
        btnChonMon.setForeground(Color.WHITE);
        btnChonMon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnChonMon.setBackground(new Color(255, 140, 0));
        btnChonMon.setBounds(21, 306, 105, 50);
        panelChinh.add(btnChonMon);
        
        tbMonAnTrenBan = new JTable();
		tbMonAnTrenBan.setRowHeight(30); 
		modelMonAnTrenBan = new DefaultTableModel(
			    new Object[][] {
			        // Dữ liệu ban đầu có thể để trống hoặc điền vào
			    },
			    new String[] {
			        "STT", "Mã món", "Tên món", "Giá tiền", "Loại", "Số lượng món"
			    }
			);

			// Gán model vào bảng tbMonAnTrenBan
			tbMonAnTrenBan.setModel(modelMonAnTrenBan);

		tbMonAnTrenBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 446, 592, 479);
		panelChinh.add(scrollPane_1);
		
		scrollPane_1.setViewportView(tbMonAnTrenBan);
		panelChinh.add(scrollPane_1);
		//
		 tbDanhSachPhieuDat = new JTable();
		 tbDanhSachPhieuDat.setRowHeight(30); 
//		 tbDanhSachPhieuDat.setModel(new DefaultTableModel(
//				new Object[][] {
//				
//				},
//				new String[] {
//						"Mã phiếu", "Khách hàng","Số điện thoại","Thời gian nhận","Mã bàn","Tên bàn","Trạng thái","Tiền cọc"
//				}
//			));
//		 tbDanhSachPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
//			scrollPane_2 = new JScrollPane();
//			scrollPane_2.setBounds(765, 319, 839, 545);
//			panelChinh.add(scrollPane_2);
//			
//			scrollPane_2.setViewportView(tbDanhSachPhieuDat);
//			panelChinh.add(scrollPane_2);
		
		//
		lblGhiChu = new JLabel("Ghi chú:");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhiChu.setBounds(161, 317, 79, 29);
		panelChinh.add(lblGhiChu);
		
		txtAGhiChu = new JTextArea();
		txtAGhiChu.setBounds(249, 302, 364, 50);
		txtAGhiChu.setText("");
		panelChinh.add(txtAGhiChu);
		
		JLabel lblDanhSachPhieuDat = new JLabel("Danh sách phiếu đặt");
		lblDanhSachPhieuDat.setForeground(new Color(30, 144, 255));
		lblDanhSachPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDanhSachPhieuDat.setBounds(1128, 11, 356, 50);
		panelChinh.add(lblDanhSachPhieuDat);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(765, 78, 719, 35);
		panelChinh.add(textField);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBackground(new Color(255, 140, 0));
		btnTimKiem.setBounds(1499, 78, 105, 35);
		panelChinh.add(btnTimKiem);
		
		lblLcTheoNgy = new JLabel("Lọc theo ngày");
		lblLcTheoNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLcTheoNgy.setBounds(765, 135, 131, 30);
		panelChinh.add(lblLcTheoNgy);
		
		btnLoc = new JButton("Tìm kiếm");
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLoc.setBackground(new Color(255, 140, 0));
		btnLoc.setBounds(764, 188, 105, 35);
		panelChinh.add(btnLoc);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoi.setBackground(new Color(255, 140, 0));
		btnLamMoi.setBounds(892, 188, 105, 35);
		panelChinh.add(btnLamMoi);
		
		btnHuyPhieu = new JButton("Huỷ phiếu đặt");
		btnHuyPhieu.setForeground(Color.WHITE);
		btnHuyPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuyPhieu.setBackground(new Color(255, 140, 0));
		btnHuyPhieu.setBounds(765, 875, 180, 50);
		panelChinh.add(btnHuyPhieu);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBackground(new Color(255, 140, 0));
		btnCapNhat.setBounds(969, 875, 180, 50);
		panelChinh.add(btnCapNhat);
		
		btnNhanBan = new JButton("Nhận bàn");
		btnNhanBan.setForeground(Color.WHITE);
		btnNhanBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhanBan.setBackground(new Color(255, 140, 0));
		btnNhanBan.setBounds(1173, 875, 180, 50);
		panelChinh.add(btnNhanBan);
        
    
        for (int i = 1; i <= 23; i++) {
            String hour = (i < 10) ? "0" + i : String.valueOf(i);
            cbGioDat.addItem(hour + ":00");
            cbGioDat.addItem(hour + ":30");
        }

       
       
    
        
      
        
        
        btnDatBan.addActionListener(this);
        btnChonMon.addActionListener(this);
        btnChonBan.addActionListener(this);
        btnCapNhat.addActionListener(this);
        
     // Khởi tạo model cho bảng
        tbDanhSachPhieuDat.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Mã phiếu", "Khách hàng", "Số điện thoại", "Thời gian nhận",
                "Mã bàn", "Tên bàn", "Trạng thái", "Tiền cọc", "Số khách"
            }
        ));

        // Thiết lập một số đặc tính cho bảng
        tbDanhSachPhieuDat.setRowHeight(30); // Đặt chiều cao của các hàng
        tbDanhSachPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Thiết lập font chữ cho bảng

        // Thêm bảng vào JScrollPane để có thể cuộn
        JScrollPane scrollPane_2 = new JScrollPane(tbDanhSachPhieuDat);
        scrollPane_2.setBounds(765, 319, 839, 545);  // Thiết lập vị trí và kích thước của JScrollPane
        panelChinh.add(scrollPane_2); // Thêm JScrollPane vào panelChinh

        // Cấu hình lại cho bảng trong JScrollPane
        scrollPane_2.setViewportView(tbDanhSachPhieuDat);

        // Thiết lập nhãn "Trạng thái"
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTrangThai.setBounds(21, 382, 105, 29);
        panelChinh.add(lblTrangThai);

        // Thiết lập ô nhập liệu cho trạng thái
        txtTrangThai = new JTextField();
        txtTrangThai.setText("");
        txtTrangThai.setColumns(10);
        txtTrangThai.setBounds(143, 383, 149, 30);
        panelChinh.add(txtTrangThai);

        // Thiết lập ô nhập liệu cho mã phiếu
        txtPhieuDat = new JTextField();
        txtPhieuDat.setText("");
        txtPhieuDat.setColumns(10);
        txtPhieuDat.setBounds(279, 11, 149, 45);
        panelChinh.add(txtPhieuDat);

        // Đăng ký sự kiện cho bảng và các nút
        tbDanhSachPhieuDat.addMouseListener(this);  // Xử lý sự kiện khi nhấp chuột vào bảng
        btnNhanBan.addActionListener(this);  // Xử lý sự kiện cho nút nhận bàn
        btnLamMoi.addActionListener(this);  // Xử lý sự kiện cho nút làm mới

        // Gọi hàm hiển thị danh sách phiếu đặt
        hienThiDanhSachPhieuDat();

	}

	public void hienThiDanhSachPhieuDat() {
	    System.out.println("Đang chạy hàm hiển thị danh sách phiếu đặt...");
	    
	    DefaultTableModel model = (DefaultTableModel) tbDanhSachPhieuDat.getModel();
	    model.setRowCount(0); // Xóa các dòng cũ
	    
	    PhieuDatBanDAO ctpdd = new PhieuDatBanDAO();
	    List<Object[]> chiTietPhieuDatList = ctpdd.layTatCaPhieuDatBan();
	    
	    System.out.println("Số lượng phiếu đặt: " + chiTietPhieuDatList.size()); // Kiểm tra số lượng
	    
	    // Thêm dữ liệu vào bảng
	    for (Object[] item : chiTietPhieuDatList) {
	        PhieuDatBan phieuDatBan = (PhieuDatBan) item[0];
	        Ban ban = (Ban) item[1];
	        
	        // In ra dữ liệu để kiểm tra
	        System.out.println("Mã phiếu: " + phieuDatBan.getMaPhieuDat() + ", Khách hàng: " + phieuDatBan.getTenKhachDat());
	        
	        model.addRow(new Object[]{
	            phieuDatBan.getMaPhieuDat(),
	            phieuDatBan.getTenKhachDat(),
	            phieuDatBan.getSoDienThoai(),
	            phieuDatBan.getNgayDat(),
	            ban.getMaBan(),
	            ban.getTenBan(),
	            phieuDatBan.isTrangThai(),
	            phieuDatBan.getTienCoc(),
	            phieuDatBan.getSoLuongKhach(),
	        });
	    }
	}

	    
//	    String[] columnNames = {
//	        "Mã phiếu", "Khách hàng", "Số điện thoại", "Thời gian nhận",
//	        "Mã bàn", "Tên bàn", "Trạng thái", "Tiền cọc","Số khách"
//	    };
//
//	    
//	    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

	    

	


	public static void setThongTinPhieuDat(String x) {
		txtMaBan.setText(x);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if (e.getSource() == btnDatBan) {
//	
//		    java.util.Date ngayDatUtil = (java.util.Date) datePicker.getModel().getValue();
//
//		  
//		    LocalDate ngayDat = ngayDatUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//		    
//		    String gioDat = (String) cbGioDat.getSelectedItem();
//		    LocalTime gio = LocalTime.parse(gioDat); 
//
//		    LocalDateTime ngayGioDat = ngayDat.atTime(gio);
//
//		
//		 String maBan = txtMaBan.getText().trim();
//		 String tenNhanVien = txtTenNhanVien.getText().trim();
//		 String tenKhachHang = txtTenKhachHang.getText().trim();
//		 int soCho = txtSoCho.getText().trim().isEmpty() ? 0 : Integer.parseInt(txtSoCho.getText().trim());
//		 float tienCoc = txtTienCoc.getText().trim().isEmpty() ? 0.0f : Float.parseFloat(txtTienCoc.getText().trim());
//		 String soDienThoai = txtSdt.getText().trim();
//		 String ghiChu = txtAGhiChu.getText().trim();
//
//	
//		 if (maBan.isEmpty()) {
//		     maBan = null;
//		 }
//		 if (tenNhanVien.isEmpty()) {
//		     tenNhanVien = null;
//		 }
//		 if (tenKhachHang.isEmpty()) {
//		     tenKhachHang = null;
//		 }
//		 if (soDienThoai.isEmpty()) {
//		     soDienThoai = null;
//		 }
//		 if (ghiChu.isEmpty()) {
//		     ghiChu = null;
//		 }
//
//		    PhieuDatBanDAO phieuDatDAO = new PhieuDatBanDAO();
//		    String maPhieuDat = phieuDatDAO.phatSinhMaPhieuDatMoi();
//
//		    Timestamp thoiGianDatTimestamp = Timestamp.valueOf(ngayGioDat);
//
//		    PhieuDatBan phieuDat = new PhieuDatBan(maPhieuDat, tenKhachHang, soCho, thoiGianDatTimestamp, ghiChu,tienCoc,soDienThoai, false, new NhanVien("admin"));
//		    boolean success = phieuDatDAO.themPhieuDat(phieuDat);
//
//		    // Kiểm tra kết quả và hiển thị thông báo
//		    if (success) {
//		        JOptionPane.showMessageDialog(null, "Phiếu đặt đã được thêm thành công!");
//		    } else {
//		        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm phiếu đặt.");
//		    }
//		    
//		    ChiTietPhieuDatDAO chiTietPhieuDatDAO = new ChiTietPhieuDatDAO();
//		    
//		    for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
//		        String maMonAn = (String) modelMonAnTrenBan.getValueAt(i, 1);
//		        int soLuongMon = (int) modelMonAnTrenBan.getValueAt(i, 5); 
//
//	
//		        MonAnUong monAnUong = new MonAnUong(maMonAn); 
//		        Ban ban = new Ban(txtMaBan.getText()); 
//
//		 
//		        ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(soLuongMon, monAnUong, phieuDat, ban);
//
//		        if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
//		            JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt cho món: " + maMonAn);
//		        }
//		    }
//		    JOptionPane.showMessageDialog(null, "Phiếu đặt và chi tiết phiếu đặt đã được lưu thành công.");
////		    BanDAO.updateThoiGianDatBan(luuMaBan,ngaytao);
////	        BanDAO banDAO = new BanDAO();
////	        if (!banDAO.capNhatTrangThaiBan(txtMaBan.getText(), true)) {
////	            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái bàn.");
////	        } else {
////	            JOptionPane.showMessageDialog(null, "Phiếu đặt đã được xác nhận và bàn đã được cập nhật trạng thái.");
////	        }
//		    
//		}
//		else if(e.getSource()==btnChonMon) {
//			new ThemMonDatTruoc().setVisible(true);
//		}
//		else if(e.getSource()==btnChonBan) {
//			new ChonBanDatTruoc().setVisible(true);
//		}
//		else if(e.getSource()==btnLamMoi) {
//			hienThiDanhSachPhieuDat();
//		}
//		else if(e.getSource()==btnNhanBan) {
//			PhieuDatBanDAO ptdd = new PhieuDatBanDAO();
//			ptdd.setTrangThai(txtPhieuDat.getText(), true);
////		    BanDAO.updateThoiGianDatBan(luuMaBan,ngaytao);
//	        BanDAO banDAO = new BanDAO();
//	        if (!banDAO.capNhatTrangThaiBan(txtMaBan.getText(), true)) {
//	            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái bàn.");
//	        } else {
//	            JOptionPane.showMessageDialog(null, "Bàn đã được cập nhật trạng thái.");
//	        }
//			JOptionPane.showMessageDialog(this, "Cập nhât thành công");
//			
//		}
//
//
//		if (e.getSource() == btnDatBan) {
//		    java.util.Date ngayDatUtil = (java.util.Date) datePicker.getModel().getValue();
//		    LocalDate ngayDat = ngayDatUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		    String gioDat = (String) cbGioDat.getSelectedItem();
//		    LocalTime gio = LocalTime.parse(gioDat); 
//		    LocalDateTime ngayGioDat = ngayDat.atTime(gio);
//
//		    String maBan = txtMaBan.getText().trim();
//		    String tenNhanVien = txtTenNhanVien.getText().trim();
//		    String tenKhachHang = txtTenKhachHang.getText().trim();
//		    int soCho = txtSoCho.getText().trim().isEmpty() ? 0 : Integer.parseInt(txtSoCho.getText().trim());
//		    float tienCoc = txtTienCoc.getText().trim().isEmpty() ? 0.0f : Float.parseFloat(txtTienCoc.getText().trim());
//		    String soDienThoai = txtSdt.getText().trim();
//		    String ghiChu = txtAGhiChu.getText().trim();
//
//		    if (maBan.isEmpty()) { maBan = null; }
//		    if (tenNhanVien.isEmpty()) { tenNhanVien = null; }
//		    if (tenKhachHang.isEmpty()) { tenKhachHang = null; }
//		    if (soDienThoai.isEmpty()) { soDienThoai = null; }
//		    if (ghiChu.isEmpty()) { ghiChu = null; }
//
//		    PhieuDatBanDAO phieuDatDAO = new PhieuDatBanDAO();
//		    String maPhieuDat = phieuDatDAO.phatSinhMaPhieuDatMoi();
//		    Timestamp thoiGianDatTimestamp = Timestamp.valueOf(ngayGioDat);
//
//		    PhieuDatBan phieuDat = new PhieuDatBan(maPhieuDat, tenKhachHang, soCho, thoiGianDatTimestamp, ghiChu, tienCoc, soDienThoai, false, new NhanVien("admin"));
//		    boolean success = phieuDatDAO.themPhieuDat(phieuDat);
//
//		    if (success) {
//		        // Thêm chi tiết phiếu đặt nếu có món ăn
//		        ChiTietPhieuDatDAO chiTietPhieuDatDAO = new ChiTietPhieuDatDAO();
//		        
//		        // Kiểm tra nếu có món ăn trong bảng modelMonAnTrenBan
//		        boolean hasFood = false; // Biến kiểm tra có món ăn hay không
//		        
//		        for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
//		            String maMonAn = (String) modelMonAnTrenBan.getValueAt(i, 1);
//		            int soLuongMon = (int) modelMonAnTrenBan.getValueAt(i, 5);
//
//		            if (!maMonAn.isEmpty() && soLuongMon > 0) {
//		                hasFood = true;
//		                MonAnUong monAnUong = new MonAnUong(maMonAn); 
//		                Ban ban = new Ban(txtMaBan.getText());
//		                ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(soLuongMon, monAnUong, phieuDat, ban);
//
//		                if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
//		                    JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt cho món: " + maMonAn);
//		                }
//		            }
//		        }
//
//		        // Nếu không có món ăn, có thể thêm chi tiết phiếu đặt với giá trị null cho món ăn và bàn
//		        if (!hasFood) {
//		            ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(0, null, phieuDat, null); // Null cho món ăn và bàn
//		            if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
//		                JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt với món ăn null.");
//		            }
//		        }
//
//		        JOptionPane.showMessageDialog(null, "Phiếu đặt và chi tiết phiếu đặt đã được lưu thành công.");
//		    } else {
//		        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm phiếu đặt.");
//		    }
		if (e.getSource() == btnDatBan) {
		   
		    java.util.Date ngayDatUtil = (java.util.Date) datePicker.getModel().getValue();
		    LocalDate ngayDat = ngayDatUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		    String gioDat = (String) cbGioDat.getSelectedItem();
		    LocalTime gio = LocalTime.parse(gioDat); 
		    LocalDateTime ngayGioDat = ngayDat.atTime(gio);

		 
		    String maBan = txtMaBan.getText().trim();
		    String tenNhanVien = txtTenNhanVien.getText().trim();
		    String tenKhachHang = txtTenKhachHang.getText().trim();
		    int soCho = txtSoCho.getText().trim().isEmpty() ? 0 : Integer.parseInt(txtSoCho.getText().trim());
		    float tienCoc = txtTienCoc.getText().trim().isEmpty() ? 0.0f : Float.parseFloat(txtTienCoc.getText().trim());
		    String soDienThoai = txtSdt.getText().trim();
		    String ghiChu = txtAGhiChu.getText().trim();

	
		    if (maBan.isEmpty()) { 
		        JOptionPane.showMessageDialog(null, "Mã bàn không được để trống!");
		        return;
		    }
		    if (tenNhanVien.isEmpty()) { tenNhanVien = null; }
		    if (tenKhachHang.isEmpty()) { tenKhachHang = null; }
		    if (soDienThoai.isEmpty()) { soDienThoai = null; }
		    if (ghiChu.isEmpty()) { ghiChu = null; }

		    // Tạo đối tượng PhieuDatBan và lưu vào cơ sở dữ liệu
		    PhieuDatBanDAO phieuDatDAO = new PhieuDatBanDAO();
		    String maPhieuDat = phieuDatDAO.phatSinhMaPhieuDatMoi();
		    Timestamp thoiGianDatTimestamp = Timestamp.valueOf(ngayGioDat);

		    PhieuDatBan phieuDat = new PhieuDatBan(maPhieuDat, tenKhachHang, soCho, thoiGianDatTimestamp, ghiChu, tienCoc, soDienThoai, false, new NhanVien("admin"));
		    boolean success = phieuDatDAO.themPhieuDat(phieuDat);

		    if (success) {
		        // Thêm chi tiết phiếu đặt nếu có món ăn
		        ChiTietPhieuDatDAO chiTietPhieuDatDAO = new ChiTietPhieuDatDAO();
		        
		        boolean hasFood = false; // Kiểm tra có món ăn trong đơn không
		        
		        // Duyệt qua bảng món ăn trên bàn
		        for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
		            String maMonAn = (String) modelMonAnTrenBan.getValueAt(i, 1);
		            int soLuongMon = (int) modelMonAnTrenBan.getValueAt(i, 5);

		            // Kiểm tra nếu món ăn có mã và số lượng hợp lệ
		            if (!maMonAn.isEmpty() && soLuongMon > 0) {
		                hasFood = true;
		                MonAnUong monAnUong = new MonAnUong(maMonAn); 
		                Ban ban = new Ban(maBan); // Đảm bảo bàn không null
		                ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(soLuongMon, monAnUong, phieuDat, ban);

		                // Thêm chi tiết phiếu đặt cho món ăn
		                if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
		                    JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt cho món: " + maMonAn);
		                }
		            }
		        }

		        // Nếu không có món ăn, thêm chi tiết phiếu đặt với giá trị null cho món ăn
		        if (!hasFood) {
		            ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(0, null, phieuDat, new Ban(maBan)); // Món ăn null, bàn không null
		            if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
		                JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt với món ăn null.");
		            }
		        }

		        JOptionPane.showMessageDialog(null, "Phiếu đặt và chi tiết phiếu đặt đã được lưu thành công.");
		    } else {
		        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm phiếu đặt.");
		    }
	

		} else if (e.getSource() == btnChonMon) {
		    new ThemMonDatTruoc().setVisible(true);
		} else if (e.getSource() == btnChonBan) {
		    new ChonBanDatTruoc().setVisible(true);
		} else if (e.getSource() == btnLamMoi) {
		    hienThiDanhSachPhieuDat();
		} else if (e.getSource() == btnNhanBan) {
		    PhieuDatBanDAO ptdd = new PhieuDatBanDAO();
		    ptdd.setTrangThai(txtPhieuDat.getText(), true);
		    BanDAO banDAO = new BanDAO();
		    if (!banDAO.capNhatTrangThaiBan(txtMaBan.getText(), true)) {
		        JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái bàn.");
		    } else {
		        JOptionPane.showMessageDialog(null, "Bàn đã được cập nhật trạng thái.");
		    }
		    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
		}
		else if(e.getSource()==btnCapNhat) {
			btnCapNhat.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        try {
			     
			            String maPhieuDat = txtPhieuDat.getText().trim();
			            String maBan = txtMaBan.getText().trim();
			            String tenKhachHang = txtTenKhachHang.getText().trim();
			            String soDienThoai = txtSdt.getText().trim();
			            float tienCoc = txtTienCoc.getText().trim().isEmpty() ? 0.0f : Float.parseFloat(txtTienCoc.getText().trim());
			            String ghiChu = txtAGhiChu.getText().trim();
			            
			            
			            java.util.Date ngayDatUtil = (java.util.Date) datePicker.getModel().getValue();
					    LocalDate ngayDat = ngayDatUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					    String gioDat = (String) cbGioDat.getSelectedItem();
					    LocalTime gio = LocalTime.parse(gioDat); 
					    LocalDateTime ngayGioDat = ngayDat.atTime(gio);
					    Timestamp thoiGianDatTimestamp = Timestamp.valueOf(ngayGioDat);
					    
			            String strSoCho = txtSoCho.getText();
			            int soCho = Integer.parseInt(strSoCho);
			            boolean trangThai = Boolean.parseBoolean(txtTrangThai.getText().trim());

			            // Kiểm tra các giá trị quan trọng
			            if (maPhieuDat.isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Mã phiếu đặt không được để trống!");
			                return;
			            }
			            if (maBan.isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Mã bàn không được để trống!");
			                return;
			            }

			            // Cập nhật phiếu đặt bàn
			            PhieuDatBan phieuDat = new PhieuDatBan(maPhieuDat, tenKhachHang, soCho, thoiGianDatTimestamp, ghiChu, tienCoc, soDienThoai, trangThai, new NhanVien("admin"));
			            PhieuDatBanDAO phieuDatDAO = new PhieuDatBanDAO();
			            boolean isPhieuDatUpdated = phieuDatDAO.capNhatPhieuDat(phieuDat);

			            if (isPhieuDatUpdated) {
			                // Cập nhật hoặc thêm chi tiết món ăn
			                ChiTietPhieuDatDAO chiTietPhieuDatDAO = new ChiTietPhieuDatDAO();

			                for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
			                    String maMonAn = (String) modelMonAnTrenBan.getValueAt(i, 1);
			                    int soLuongMon = (int) modelMonAnTrenBan.getValueAt(i, 5);

			                    if (!maMonAn.isEmpty() && soLuongMon > 0) {
			                        // Kiểm tra xem món ăn đã tồn tại trong phiếu đặt chưa
			                        ChiTietPhieuDat existingChiTiet = chiTietPhieuDatDAO.layChiTietTheoPhieuVaMon(maPhieuDat, maMonAn);

			                        if (existingChiTiet != null) {
			                            // Nếu đã tồn tại, cập nhật số lượng
			                            existingChiTiet.setSoLuong(soLuongMon);
			                            chiTietPhieuDatDAO.capNhatChiTiet(existingChiTiet);
			                        } else {
			                            // Nếu chưa tồn tại, thêm mới
			                            MonAnUong monAnUong = new MonAnUong(maMonAn);
			                            Ban ban = new Ban(maBan);
			                            ChiTietPhieuDat newChiTiet = new ChiTietPhieuDat(soLuongMon, monAnUong, phieuDat, ban);
			                            chiTietPhieuDatDAO.themChiTietPhieuDat(newChiTiet);
			                        }
			                    }
			                }

			                JOptionPane.showMessageDialog(null, "Cập nhật phiếu đặt thành công!");
			            } else {
			                JOptionPane.showMessageDialog(null, "Cập nhật phiếu đặt thất bại!");
			            }
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + ex.getMessage());
			        }
			    }
			});

		}

		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
        int row = tbDanhSachPhieuDat.getSelectedRow(); 
        String khachHang = (String)tbDanhSachPhieuDat.getValueAt(row, 1);
        String maPhieuDat = (String)tbDanhSachPhieuDat.getValueAt(row, 0);
        Boolean trangThai = (Boolean)tbDanhSachPhieuDat.getValueAt(row, 6);
        Float tienCoc = (Float) tbDanhSachPhieuDat.getValueAt(row, 7);
        String soDienThoai = (String) tbDanhSachPhieuDat.getValueAt(row, 2);
        String maBan = (String) tbDanhSachPhieuDat.getValueAt(row, 4);
        int soCho =  (int) tbDanhSachPhieuDat.getValueAt(row, 8);
  
        java.sql.Timestamp timestamp = (java.sql.Timestamp) tbDanhSachPhieuDat.getValueAt(row, 3);
        LocalDateTime thoiGian = timestamp.toLocalDateTime();
        datePicker.getModel().setDate(thoiGian.getYear(), thoiGian.getMonthValue() - 1, thoiGian.getDayOfMonth());
        datePicker.getModel().setSelected(true);
        cbGioDat.setSelectedItem(thoiGian.toLocalTime().toString());


        txtPhieuDat.setText(maPhieuDat);
        txtMaBan.setText(maBan);
        txtTenKhachHang.setText(khachHang);
        txtSdt.setText(soDienThoai);
        txtTienCoc.setText((String.valueOf(tienCoc)));
        txtTrangThai.setText(String.valueOf(trangThai));
        txtSoCho.setText(String.valueOf(soCho));
//        txtTrangThai.setText(trangThai ? "Đã Nhận" : "Chưa Nhận");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
