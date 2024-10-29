package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dao.BanDAO;
import dao.ChiTietPhieuDatDAO;
import dao.MonAnUongDAO;
import dao.PhieuDatBanDAO;
import entity.Ban;
import entity.ChiTietPhieuDat;
import entity.MonAnUong;
import entity.NhanVien;
import entity.PhieuDatBan;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class ThemMon extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenKhach;
	private JTextField txtSoKhach;
	private JTextField textField_4;
	private JTable tbMonAnTrenBan;
	private JTable tbMonAn;
	private JButton btnThemMon;
	public static JLabel lblMaBan;
	private int STT = 1;
	private JDatePickerImpl datePicker;
	private Container pnlTT;
	private JButton btnXacNhan;
	private JTextArea txtGhiChu;
	public static String luuMaBan;
	private JTextField textField;
	public static LocalDateTime ngaytao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemMon frame = new ThemMon();
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
	
	public ThemMon() {
		
		setBounds(100, 100, 1329, 767);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 462, 706);
		contentPane.add(panel);
		
		JLabel lblBanDat = new JLabel();
		lblBanDat.setBounds(88, 11, 69, 25);
		lblBanDat.setText("Bàn đặt: ");
		lblBanDat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		lblMaBan = new JLabel();
		lblMaBan.setBounds(167, 11, 235, 25);
		
		lblMaBan.setForeground(new Color(255, 0, 51));
		lblMaBan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel lblMa = new JLabel();
		lblMa.setBounds(10, 45, 54, 17);
		lblMa.setText("Mã phiếu");
		lblMa.setForeground(new Color(0, 51, 255));
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTenKhach = new JLabel();
		lblTenKhach.setBounds(10, 94, 88, 17);
		lblTenKhach.setText("Tên khách đặt");
		lblTenKhach.setForeground(new Color(0, 51, 255));
		lblTenKhach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTenKhach = new JTextField();
		txtTenKhach.setBounds(10, 117, 427, 33);
		
		JLabel jLabel5_1 = new JLabel();
		jLabel5_1.setBounds(10, 157, 130, 17);
		jLabel5_1.setText("Thời gian bắt đầu đặt");
		jLabel5_1.setForeground(new Color(0, 51, 255));
		jLabel5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel jLabel8_1 = new JLabel();
		jLabel8_1.setBounds(244, 161, 57, 17);
		jLabel8_1.setText("Số khách");
		jLabel8_1.setForeground(new Color(0, 51, 255));
		jLabel8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSoKhach = new JTextField();
		txtSoKhach.setBounds(244, 184, 193, 33);
		
		JLabel jLabel11_1 = new JLabel();
		jLabel11_1.setBounds(10, 228, 46, 17);
		jLabel11_1.setText("Ghi chú");
		jLabel11_1.setForeground(new Color(0, 51, 255));
		jLabel11_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel jLabel19_1 = new JLabel();
		jLabel19_1.setBounds(10, 370, 119, 22);
		jLabel19_1.setText("Tên nhân viên:");
		jLabel19_1.setForeground(Color.MAGENTA);
		jLabel19_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTenNV = new JLabel("Nhân viên A");
		lblTenNV.setBounds(139, 374, 73, 17);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 399, 427, 243);
		
		JLabel lblMaPhieu = new JLabel("");
		lblMaPhieu.setBounds(10, 68, 428, 20);
		lblMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
        datePicker.setBounds(10, 182, 180, 35);
        panel.add(datePicker);

        // Đặt kích thước và font chữ cho trường nhập ngày
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePicker.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));
		tbMonAnTrenBan = new JTable();
		tbMonAnTrenBan.setRowHeight(30); 
		tbMonAnTrenBan.setModel(new DefaultTableModel(
			new Object[][] {
			
			},
			new String[] {
					"STT", "Mã món","Tên món","Giá tiền","Loại","Số lượng món"
			}
		));
		tbMonAnTrenBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tbMonAnTrenBan);
		panel.setLayout(null);
		panel.add(lblBanDat);
		panel.add(lblMaBan);
		panel.add(lblMa);
		panel.add(lblTenKhach);
		panel.add(jLabel11_1);
		panel.add(txtTenKhach);
		panel.add(jLabel5_1);
		panel.add(jLabel8_1);
		panel.add(txtSoKhach);
		panel.add(jLabel19_1);
		panel.add(lblTenNV);
		panel.add(scrollPane);
		panel.add(lblMaPhieu);
		
		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(10, 256, 427, 52);
		panel.add(txtGhiChu);
		
		JLabel jLabel11_1_1 = new JLabel();
		jLabel11_1_1.setText("Tiền cọc");
		jLabel11_1_1.setForeground(new Color(0, 51, 255));
		jLabel11_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel11_1_1.setBounds(10, 319, 88, 17);
		panel.add(jLabel11_1_1);
		
		textField = new JTextField();
		textField.setBounds(12, 339, 119, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(482, 11, 800, 706);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jLabel14 = new JLabel();
		jLabel14.setBackground(new Color(30, 144, 255));
		jLabel14.setToolTipText("");
		jLabel14.setText("Thêm món");
		jLabel14.setForeground(new Color(30, 144, 255));
		jLabel14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel14.setBounds(10, 11, 206, 41);
		panel_1.add(jLabel14);
		
		JButton jButton2 = new JButton();
		jButton2.setText("Món ăn");
		jButton2.setPreferredSize(new Dimension(50, 30));
		jButton2.setForeground(Color.WHITE);
		jButton2.setBackground(new Color(51, 153, 255));
		jButton2.setBounds(10, 63, 100, 48);
		panel_1.add(jButton2);
		
		JButton jButton3 = new JButton();
		jButton3.setText("Nước");
		jButton3.setPreferredSize(new Dimension(50, 30));
		jButton3.setForeground(Color.WHITE);
		jButton3.setBackground(Color.BLUE);
		jButton3.setBounds(116, 63, 100, 48);
		panel_1.add(jButton3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setBounds(230, 123, 450, 30);
		panel_1.add(textField_4);
		
		JLabel lblTimKiem = new JLabel("Nhập tên món cần tìm");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimKiem.setBounds(10, 122, 211, 30);
		panel_1.add(lblTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(690, 122, 100, 31);
		panel_1.add(btnTimKiem);
		
		btnThemMon = new JButton();
		btnThemMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemMon.setText("Thêm");
		btnThemMon.setForeground(Color.WHITE);
		btnThemMon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemMon.setBackground(new Color(51, 153, 0));
		btnThemMon.setBounds(10, 654, 118, 41);
		panel_1.add(btnThemMon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 164, 780, 479);
		panel_1.add(scrollPane_1);
		
		tbMonAn = new JTable();
		tbMonAn.setRowHeight(30);
		tbMonAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbMonAn.setModel(new DefaultTableModel(
			new Object[][] {
			
				
			},
			new String[] {
				"STT", "Mã món","Tên món","Giá tiền","Loại"
			}
		));
		scrollPane_1.setViewportView(tbMonAn);
		loadDataToTable();
		
		tbMonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBackground(Color.ORANGE);
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXacNhan.setBounds(672, 654, 118, 41);
		panel_1.add(btnXacNhan);
		
		btnThemMon.addActionListener(this);
		btnXacNhan.addActionListener(this);
//		btnThemMon.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		        
//		    }
//		});



	}
	public void loadDataToTable(){
		MonAnUongDAO monAnUongDAO = new MonAnUongDAO();
		List<MonAnUong> listMonAn = monAnUongDAO.loadAllMonAnUong();
		
		DefaultTableModel model = (DefaultTableModel) tbMonAn.getModel();
		model.setRowCount(0);

		int stt = 1;
		for (MonAnUong monAn : listMonAn) {
			model.addRow(new Object[] {
				stt++,
				monAn.getMaMonAnUong(),
				monAn.getTenMonAnUong(), 
				
				monAn.getGiaTien(), 
				monAn.getLoai(),
			
			});
		}
	}
	public static void loadThongTinMonAn(String ma) {
		lblMaBan.setText(ma);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnThemMon) {
			int selectedRow = tbMonAn.getSelectedRow();
	        if (selectedRow != -1) {
	            DefaultTableModel modelMonAn = (DefaultTableModel) tbMonAn.getModel();
	            
	          
	            String maMonAnUong = (String) modelMonAn.getValueAt(selectedRow, 1);
	            String tenMonAnUong = (String) modelMonAn.getValueAt(selectedRow, 2);
	            double giaTien = (double) modelMonAn.getValueAt(selectedRow, 3);
	            String loai = (String) modelMonAn.getValueAt(selectedRow, 4);

	            DefaultTableModel modelMonAnTrenBan = (DefaultTableModel) tbMonAnTrenBan.getModel();
	            
	         
	            boolean daTonTai = false;
	            for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
	                String maMonAnTrenBan = (String) modelMonAnTrenBan.getValueAt(i, 1); 
	                
	                if (maMonAnTrenBan.equals(maMonAnUong)) {
	                  
	                    int soLuongHienTai = (int) modelMonAnTrenBan.getValueAt(i, 5);
	                    modelMonAnTrenBan.setValueAt(soLuongHienTai + 1, i, 5); 
	                    daTonTai = true;
	                    break;
	                }
	            }

	            if (!daTonTai) {
	               
	                modelMonAnTrenBan.addRow(new Object[] {
	                    STT++, 
	                    maMonAnUong,
	                    tenMonAnUong,
	                   
	                    giaTien,
	                    loai,
	                    1,  
	                });
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Vui lòng chọn một món ăn để thêm.");
	        }
		}
		else if(e.getSource() == btnXacNhan) {
	
		    String tenKhachDat = txtTenKhach.getText().trim();
		    int soLuongKhach = Integer.parseInt(txtSoKhach.getText().trim());
		    String ghiChu = txtGhiChu.getText().trim();
		    String maNhanVien = "admin";
		    
		    if (tenKhachDat.isEmpty() || soLuongKhach <= 0) {
		        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin khách đặt và mã nhân viên.");
		        return;
		    }


		    PhieuDatBanDAO phieuDatBanDAO = new PhieuDatBanDAO();
		    String maPhieuDatMoi = phieuDatBanDAO.phatSinhMaPhieuDatMoi();
		    Date selectedDate = (Date) datePicker.getModel().getValue();

			ngaytao = null;
			if (selectedDate != null) {
			    ngaytao = selectedDate.toInstant()
			                          .atZone(ZoneId.systemDefault())
			                          .toLocalDateTime();
			} else {
			    System.out.println("Không có ngày nào được chọn");
			}
			
		    PhieuDatBan phieuDatMoi = new PhieuDatBan(maPhieuDatMoi, tenKhachDat, soLuongKhach, LocalDateTime.now(), ghiChu, new NhanVien(maNhanVien));
		    phieuDatBanDAO.themPhieuDat(phieuDatMoi);
		    DefaultTableModel modelMonAnTrenBan = (DefaultTableModel) tbMonAnTrenBan.getModel();
	
		    ChiTietPhieuDatDAO chiTietPhieuDatDAO = new ChiTietPhieuDatDAO();
		    for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
		        String maMonAn = (String) modelMonAnTrenBan.getValueAt(i, 1);
		        int soLuongMon = (int) modelMonAnTrenBan.getValueAt(i, 5); 

	
		        MonAnUong monAnUong = new MonAnUong(maMonAn); 
		        Ban ban = new Ban(lblMaBan.getText()); 

		 
		        ChiTietPhieuDat chiTiet = new ChiTietPhieuDat(soLuongMon, monAnUong, phieuDatMoi, ban);

		        if (!chiTietPhieuDatDAO.themChiTietPhieuDat(chiTiet)) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết phiếu đặt cho món: " + maMonAn);
		        }
		    }
		    JOptionPane.showMessageDialog(null, "Phiếu đặt và chi tiết phiếu đặt đã được lưu thành công.");
		    BanDAO.updateThoiGianDatBan(luuMaBan,ngaytao);
	        BanDAO banDAO = new BanDAO();
	        if (!banDAO.capNhatTrangThaiBan(lblMaBan.getText(), true)) {
	            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái bàn.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Phiếu đặt đã được xác nhận và bàn đã được cập nhật trạng thái.");
	        }
		}

		
		
	}
}
