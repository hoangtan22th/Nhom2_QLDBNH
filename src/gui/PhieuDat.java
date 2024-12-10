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

public class PhieuDat extends JFrame implements ActionListener {

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
		lblPhieuDat.setBounds(296, 11, 131, 50);
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
        btnChonMon.setBounds(21, 317, 105, 35);
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
		scrollPane_1.setBounds(21, 385, 592, 479);
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
        
        // Thêm các giá trị vào JComboBox (ví dụ giờ đặt từ 1:00 đến 23:00)
        for (int i = 1; i <= 23; i++) {
            String hour = (i < 10) ? "0" + i : String.valueOf(i); // Đảm bảo định dạng "01", "02", ..., "23"
            cbGioDat.addItem(hour + ":00");
            cbGioDat.addItem(hour + ":30");
        }

       
       
    
        
        hienThiDanhSachPhieuDat();
        
        btnDatBan.addActionListener(this);
        btnChonMon.addActionListener(this);
        btnChonBan.addActionListener(this);
	}
	// Giả sử bạn đã có đối tượng tbDanhSachPhieuDat là một JTable và phương thức layTatCaChiTietPhieuDat_Join()

	public void hienThiDanhSachPhieuDat() {
	    // Lấy danh sách chi tiết phiếu đặt từ cơ sở dữ liệu
	    PhieuDatBanDAO ctpdd = new PhieuDatBanDAO();  // Đảm bảo kết nối cơ sở dữ liệu được truyền vào DAO
	    List<Object[]> chiTietPhieuDatList = ctpdd.layTatCaPhieuDatBan();

	    // Chuẩn bị dữ liệu cho bảng
	    Object[][] data = new Object[chiTietPhieuDatList.size()][];

	    for (int i = 0; i < chiTietPhieuDatList.size(); i++) {
	        // Lấy thông tin từ mỗi phần tử trong danh sách
	        Object[] item = chiTietPhieuDatList.get(i);
	        PhieuDatBan phieuDatBan = (PhieuDatBan) item[0];
	        Ban ban = (Ban) item[1];

	        // Thêm thông tin vào mảng dữ liệu cho bảng
	        data[i] = new Object[]{
	            phieuDatBan.getMaPhieuDat(),
	            phieuDatBan.getTenKhachDat(),
	            phieuDatBan.getSoDienThoai(),
	            phieuDatBan.getNgayDat(),
	            ban.getMaBan(),
	            ban.getTenBan(),
	            phieuDatBan.isTrangThai(),
	            phieuDatBan.getTienCoc(),
	        };
	    }

	    // Cập nhật mô hình bảng
	    String[] columnNames = {
	        "Mã phiếu", "Khách hàng", "Số điện thoại", "Thời gian nhận", 
	        "Mã bàn", "Tên bàn", "Trạng thái", "Tiền cọc"
	    };

	    // Tạo mô hình bảng với dữ liệu đã lấy
	    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

	    // Cập nhật bảng với mô hình mới
	    tbDanhSachPhieuDat.setModel(tableModel);

	    // Cài đặt các thuộc tính cho bảng
	    tbDanhSachPhieuDat.setRowHeight(30);
	    tbDanhSachPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 14));

	    // Đảm bảo scrollbar được hiển thị
	    JScrollPane scrollPane_2 = new JScrollPane(tbDanhSachPhieuDat);
	    scrollPane_2.setBounds(765, 319, 839, 545);  // Bạn có thể điều chỉnh lại vị trí và kích thước nếu cần
	    panelChinh.add(scrollPane_2);

	    // Cập nhật giao diện
	    scrollPane_2.setViewportView(tbDanhSachPhieuDat);
	    panelChinh.add(scrollPane_2);
	}


	public static void setThongTinPhieuDat(String x) {
		txtMaBan.setText(x);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		     maBan = null;
		 }
		 if (tenNhanVien.isEmpty()) {
		     tenNhanVien = null;
		 }
		 if (tenKhachHang.isEmpty()) {
		     tenKhachHang = null;
		 }
		 if (soDienThoai.isEmpty()) {
		     soDienThoai = null;
		 }
		 if (ghiChu.isEmpty()) {
		     ghiChu = null;
		 }

		    PhieuDatBanDAO phieuDatDAO = new PhieuDatBanDAO();
		    String maPhieuDat = phieuDatDAO.phatSinhMaPhieuDatMoi();

		    Timestamp thoiGianDatTimestamp = Timestamp.valueOf(ngayGioDat);

		    PhieuDatBan phieuDat = new PhieuDatBan(maPhieuDat, tenKhachHang, soCho, thoiGianDatTimestamp, ghiChu,tienCoc,soDienThoai, false, new NhanVien("admin"));
		    boolean success = phieuDatDAO.themPhieuDat(phieuDat);

		    // Kiểm tra kết quả và hiển thị thông báo
		    if (success) {
		        JOptionPane.showMessageDialog(null, "Phiếu đặt đã được thêm thành công!");
		    } else {
		        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm phiếu đặt.");
		    }
		    
		    ChiTietPhieuDatDAO chiTietPhieuDatDAO = new ChiTietPhieuDatDAO();
		    
		    for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
		        String maMonAn = (String) modelMonAnTrenBan.getValueAt(i, 1);
		        int soLuongMon = (int) modelMonAnTrenBan.getValueAt(i, 5); 

	
		        MonAnUong monAnUong = new MonAnUong(maMonAn); 
		        Ban ban = new Ban(txtMaBan.getText()); 

		 
		        ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(soLuongMon, monAnUong, phieuDat, ban);

		        if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt cho món: " + maMonAn);
		        }
		    }
		    JOptionPane.showMessageDialog(null, "Phiếu đặt và chi tiết phiếu đặt đã được lưu thành công.");
//		    BanDAO.updateThoiGianDatBan(luuMaBan,ngaytao);
//	        BanDAO banDAO = new BanDAO();
//	        if (!banDAO.capNhatTrangThaiBan(txtMaBan.getText(), true)) {
//	            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái bàn.");
//	        } else {
//	            JOptionPane.showMessageDialog(null, "Phiếu đặt đã được xác nhận và bàn đã được cập nhật trạng thái.");
//	        }
		    
		}
		else if(e.getSource()==btnChonMon) {
			new ThemMonDatTruoc().setVisible(true);
		}
		else if(e.getSource()==btnChonBan) {
			new ChonBanDatTruoc().setVisible(true);
		}
		else if(e.getSource()==btnLamMoi) {
			hienThiDanhSachPhieuDat();
		}


		}
}
