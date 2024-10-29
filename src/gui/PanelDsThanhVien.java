package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import connectDB.connectDB;
import dao.KhachHangDAO;
import dao.TheThanhVienDAO;
import entity.KhachHang;
import entity.LoaiThe;
import entity.TheThanhVien;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.EtchedBorder;

public class PanelDsThanhVien extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTextField txtMaThe;
    private JTextField txtTenTV;
    private JTextField txtSDT;
    private JTextField txtSoDiem;
    private JTable table;
    
    private TheThanhVienDAO ttv_dao;
    private KhachHangDAO kh_dao;
    private JTextField txtTim;
    private JDatePickerImpl datePicker;
    @SuppressWarnings("rawtypes")
	private JComboBox cbxLoaiThe;
    private JButton btnXoa,btnSua,btnThem,btnLuu;
    private JLabel lblDiem;

    /**
     * Create the panel.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelDsThanhVien() {
    	ttv_dao = new TheThanhVienDAO();
    	kh_dao = new KhachHangDAO();
    	
    	setForeground(new Color(255, 255, 255));
        setLayout(null);
        
        Label lblTT = new Label("Thông tin");
        lblTT.setBackground(new Color(65, 41, 224));
        lblTT.setBounds(10, 10, 150, 40);
        add(lblTT);
        lblTT.setAlignment(Label.CENTER);
        lblTT.setForeground(new Color(255, 255, 255));
        lblTT.setFont(new Font("Arial", Font.BOLD, 17));
        
        lblDiem = new JLabel("0 đ");
        lblDiem.setForeground(new Color(244, 0, 6));
        lblDiem.setFont(new Font("Arial", Font.BOLD, 22));
        lblDiem.setBounds(171, 10, 105, 58);
        add(lblDiem);
        
        JPanel pnlTT = new JPanel();
        pnlTT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
        pnlTT.setForeground(new Color(192, 192, 192));
        pnlTT.setBounds(10, 56, 367, 939);
        add(pnlTT);
        pnlTT.setLayout(null);
        
        txtMaThe = new JTextField();
        txtMaThe.setEditable(false);
        txtMaThe.setFont(new Font("Arial", Font.PLAIN, 14));
        txtMaThe.setBounds(10, 30, 347, 35);
        pnlTT.add(txtMaThe);
        txtMaThe.setColumns(10);
        
        JLabel lblMaThe = new JLabel("Mã thẻ");
        lblMaThe.setForeground(new Color(0, 0, 0));
        lblMaThe.setFont(new Font("Arial", Font.PLAIN, 15));
        lblMaThe.setBounds(20, 10, 45, 18);
        pnlTT.add(lblMaThe);
        
        JLabel lblTenTV = new JLabel("Tên thành viên");
        lblTenTV.setForeground(Color.BLACK);
        lblTenTV.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTenTV.setBounds(20, 72, 98, 18);
        pnlTT.add(lblTenTV);
        
        txtTenTV = new JTextField();
        txtTenTV.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTenTV.setColumns(10);
        txtTenTV.setBounds(10, 92, 347, 35);
        pnlTT.add(txtTenTV);
        
        JLabel lblSDT = new JLabel("Số điện thoại");
        lblSDT.setForeground(Color.BLACK);
        lblSDT.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSDT.setBounds(20, 134, 88, 18);
        pnlTT.add(lblSDT);
        
        txtSDT = new JTextField();
        txtSDT.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSDT.setColumns(10);
        txtSDT.setBounds(10, 156, 347, 35);
        pnlTT.add(txtSDT);
        
        JLabel lblNgayTao = new JLabel("Ngày tạo");
        lblNgayTao.setForeground(Color.BLACK);
        lblNgayTao.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNgayTao.setBounds(20, 201, 59, 18);
        pnlTT.add(lblNgayTao);
        
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
        datePicker.setBounds(10, 229, 180, 35);
        pnlTT.add(datePicker);

        // Đặt kích thước và font chữ cho trường nhập ngày
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePicker.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));   
        
        JLabel lblLoaiThe = new JLabel("Loại thẻ");
        lblLoaiThe.setForeground(Color.BLACK);
        lblLoaiThe.setFont(new Font("Arial", Font.PLAIN, 15));
        lblLoaiThe.setBounds(239, 201, 59, 18);
        pnlTT.add(lblLoaiThe);
        
        cbxLoaiThe = new JComboBox();
        cbxLoaiThe.setModel(new DefaultComboBoxModel(new String[] {"LT001", "LT002", "LT003", "LT004"}));
        cbxLoaiThe.setFont(new Font("Arial", Font.PLAIN, 15));
        cbxLoaiThe.setBounds(239, 229, 118, 35);
        pnlTT.add(cbxLoaiThe);
        
        JLabel lblSoDiem = new JLabel("Số điểm");
        lblSoDiem.setForeground(Color.BLACK);
        lblSoDiem.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSoDiem.setBounds(20, 272, 88, 18);
        pnlTT.add(lblSoDiem);
        
        txtSoDiem = new JTextField();
        txtSoDiem.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSoDiem.setColumns(10);
        txtSoDiem.setBounds(10, 290, 347, 35);
        pnlTT.add(txtSoDiem);
        
        btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSua.setBackground(new Color(255, 128, 64));
        btnSua.setForeground(new Color(255, 255, 255));
        btnSua.setFont(new Font("Arial", Font.BOLD, 12));
        btnSua.setBounds(98, 347, 80, 26);
        pnlTT.add(btnSua);
        
        btnXoa = new JButton("Xóa trắng");
        btnXoa.setForeground(new Color(255, 255, 255));
        btnXoa.setBackground(new Color(255, 0, 0));
        btnXoa.setFont(new Font("Arial", Font.BOLD, 12));
        btnXoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnXoa.setBounds(187, 347, 80, 26);
        pnlTT.add(btnXoa);
        
        btnLuu = new JButton("Cập nhật");
        btnLuu.setForeground(new Color(255, 255, 255));
        btnLuu.setBackground(new Color(0, 128, 0));
        btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
        btnLuu.setBounds(277, 347, 80, 26);
        pnlTT.add(btnLuu);
        
        btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.WHITE);
        btnThem.setFont(new Font("Arial", Font.BOLD, 12));
        btnThem.setBackground(new Color(0, 0, 255));
        btnThem.setBounds(8, 347, 80, 26);
        pnlTT.add(btnThem);
        
        JPanel panel = new JPanel();
        panel.setBounds(385, 10, 1526, 985);
        add(panel);
        panel.setLayout(null);
        
        JLabel lblDsTV = new JLabel("    Danh sách thành viên");
        lblDsTV.setOpaque(true);
        lblDsTV.setHorizontalAlignment(SwingConstants.LEFT);
        lblDsTV.setForeground(Color.WHITE);
        lblDsTV.setFont(new Font("Arial", Font.BOLD, 18));
        lblDsTV.setBackground(new Color(65, 41, 224));
        lblDsTV.setBounds(0, 0, 1524, 40);
        panel.add(lblDsTV);
        
        txtTim = new JTextField();
        txtTim.setColumns(10);
        txtTim.setBounds(295, 51, 974, 37);
        panel.add(txtTim);
        
        JLabel lblSapXep = new JLabel("Sắp xếp theo:");
        lblSapXep.setBounds(1031, 97, 97, 30);
        panel.add(lblSapXep);
        
        JComboBox cboTim = new JComboBox();
        cboTim.setModel(new DefaultComboBoxModel(new String[] {"Loại thẻ", "Số điểm"}));
        cboTim.setToolTipText("Sắp xếp theo");
        cboTim.setBounds(1138, 97, 386, 30);
        panel.add(cboTim);
        
        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setFont(new Font("Arial", Font.BOLD, 18));
        btnTimKiem.setBackground(new Color(0, 128, 255));
        btnTimKiem.setBounds(1383, 46, 141, 37);
        panel.add(btnTimKiem);
        
        String row[] = {"Mã thẻ", "Tên khách hàng", "Số điện thoại", "Loại thẻ", "Số điểm", "Ngày đăng ký" };
		model = new DefaultTableModel(row, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setRowHeight(30);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 137, 1524, 848);
		panel.add(scrollPane);
		
		JLabel lblTim = new JLabel("Tìm thẻ qua số điện thoại:");
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTim.setBounds(27, 48, 206, 40);
		panel.add(lblTim);
		
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
	
		docDL();
		
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();
						txtMaThe.setText(table.getValueAt(row, 0).toString());
						txtTenTV.setText(table.getValueAt(row, 1).toString());
						txtSDT.setText(table.getValueAt(row, 2).toString());
						LocalDateTime ngayDangKy = (LocalDateTime) table.getValueAt(row, 5);
						Date date = Date.from(ngayDangKy.atZone(ZoneId.systemDefault()).toInstant());
						datePicker.getModel().setDate(date.getYear() + 1900, date.getMonth(), date.getDate());
						datePicker.getModel().setSelected(true);
						cbxLoaiThe.setSelectedItem(table.getValueAt(row, 3).toString()); 
						txtSoDiem.setText(table.getValueAt(row, 4).toString());
						lblDiem.setText(table.getValueAt(row, 4).toString()+"đ");
					}
				});
				txtTim.addKeyListener((KeyListener) new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						
//						// Tìm theo SDT
							List<TheThanhVien> list1 = ttv_dao.timTTVTheoSDT(txtTim.getText());
							xoaDL();
							list1.forEach(i -> {

								model.addRow(new Object[] {
								        i.getMaTTV(), 
								        i.getKhachHang().getTenKH(),
								        i.getKhachHang().getSdt(), 
								        i.getLoaiThe().getTenLoaiTTV(), 
								        i.getDiemTichLuy(), 
								        i.getNgayDangKy()
								    });
							});
					}
					
				});	
				
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			xoaTrang();
		} else if(o.equals(btnThem)) {
			if(true) {
				String mattv = ttv_dao.generateMaTTV();
				txtMaThe.setText(mattv);
				String tenttv = txtTenTV.getText();
				String sdt = txtSDT.getText();
				Date selectedDate = (Date) datePicker.getModel().getValue();

				LocalDateTime ngaytao = null;
				if (selectedDate != null) {
				    ngaytao = selectedDate.toInstant()
				                          .atZone(ZoneId.systemDefault())
				                          .toLocalDateTime();
				} else {
				    System.out.println("Không có ngày nào được chọn");
				}

				String loaiThe = cbxLoaiThe.getSelectedItem().toString();
				Double soDiem = Double.parseDouble(txtSoDiem.getText());
				
				TheThanhVien ttv = new TheThanhVien(mattv, new KhachHang(tenttv, sdt), new LoaiThe(loaiThe, null), soDiem, ngaytao);
				if (ttv_dao.themTTV(ttv)) {
					table.clearSelection();
					xoaTrang();
					JOptionPane.showMessageDialog(null, "Thêm thẻ thành viên thành công !");
				} else {
					JOptionPane.showMessageDialog(null, "Trùng số điện thoại");
				}
			}
		} else if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn thẻ thành viên cần sửa!");
			} else {
				if(true) {
					String mattv = txtMaThe.getText();
					String tenttv = txtTenTV.getText();
					String sdt = txtSDT.getText();
					Date selectedDate = (Date) datePicker.getModel().getValue();

					LocalDateTime ngaytao = null;
					if (selectedDate != null) {
					    ngaytao = selectedDate.toInstant()
					                          .atZone(ZoneId.systemDefault())
					                          .toLocalDateTime();
					} else {
					    System.out.println("Không có ngày nào được chọn");
					}

					String loaiThe = cbxLoaiThe.getSelectedItem().toString();
					Double soDiem = Double.parseDouble(txtSoDiem.getText());
					
					TheThanhVien ttv = new TheThanhVien(mattv, new KhachHang(tenttv, sdt), new LoaiThe(loaiThe, null), soDiem, ngaytao);
					int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi ?","Cập nhật",
					JOptionPane.YES_NO_OPTION);
					if (t == JOptionPane.YES_OPTION) {
						if (ttv_dao.updateTTV(ttv)) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
						}
					}
				}
			}
		} else if(o.equals(btnLuu)) {
			   refreshTableData();
		}
	}
	public void xoaTrang() {
	    txtMaThe.setText("");
	    txtTenTV.setText("");
	    txtSDT.setText("");
	    datePicker.getModel().setValue(null);
	    cbxLoaiThe.setFocusable(true); 
	    cbxLoaiThe.setSelectedIndex(0); 
	    txtSoDiem.setText("");
	}
		public void xoaDL() {
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
		}
		public void docDL() {
			List<TheThanhVien> listTTV = ttv_dao.getAllTheThanhVien();
			listTTV.forEach(e -> {
			    model.addRow(new Object[] {
			        e.getMaTTV(), 
			        e.getKhachHang().getTenKH(),
			        e.getKhachHang().getSdt(), 
			        e.getLoaiThe().getTenLoaiTTV(), 
			        e.getDiemTichLuy(), 
			        e.getNgayDangKy()
			    });
			});

		}
		public void refreshTableData() {
		    // Lấy dữ liệu mới từ cơ sở dữ liệu hoặc danh sách
		    List<TheThanhVien> newData = ttv_dao.getAllTheThanhVien();
		    
		    // Xóa toàn bộ dữ liệu cũ trong DefaultTableModel
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0); 
		    // Thêm dữ liệu mới vào model
		    for (TheThanhVien ttv : newData) {
		        Object[] row = {
		            ttv.getMaTTV(),                           
		            ttv.getKhachHang().getTenKH(),            
		            ttv.getKhachHang().getSdt(),              
		            ttv.getLoaiThe().getTenLoaiTTV(),        
		            ttv.getDiemTichLuy(),                     
		            ttv.getNgayDangKy()                        
		        };
		        model.addRow(row);
		    }

		    table.revalidate();
		    table.repaint();
		}
		
}

class DateLabelFormatter extends AbstractFormatter {

    private static final long serialVersionUID = 1L;
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}
