package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

import dao.TaiKhoanDAO;
import entity.TaiKhoan;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;

public class PanelTaiKhoanMenu extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JTextField txtTenDangNhap;
    private JTextField txtMatKhau;
    private JTextField txtTim;
    private DefaultTableModel modalTable;
    private JDatePickerImpl datePicker;
    private JTable table;
    private JButton btnThem,btnXoa,btnSua,btnLuu;
    private JComboBox cbxChucVu;
    private TaiKhoanDAO tk_dao;
    /**
     * Create the panel.
     */
    public PanelTaiKhoanMenu() {
    	tk_dao = new TaiKhoanDAO();
    	setForeground(new Color(255, 255, 255));
        setLayout(null);
        
        Label lblTT = new Label("Thông tin");
        lblTT.setBackground(new Color(65, 41, 224));
        lblTT.setBounds(10, 10, 150, 40);
        add(lblTT);
        lblTT.setAlignment(Label.CENTER);
        lblTT.setForeground(new Color(255, 255, 255));
        lblTT.setFont(new Font("Arial", Font.BOLD, 17));
        
        JPanel pnlTT = new JPanel();
        pnlTT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
        pnlTT.setForeground(new Color(192, 192, 192));
        pnlTT.setBounds(10, 56, 367, 939);
        add(pnlTT);
        pnlTT.setLayout(null);
        
        txtTenDangNhap = new JTextField();
        txtTenDangNhap.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTenDangNhap.setBounds(10, 30, 347, 35);
        pnlTT.add(txtTenDangNhap);
        txtTenDangNhap.setColumns(10);
        
        JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
        lblTenDangNhap.setForeground(new Color(0, 0, 0));
        lblTenDangNhap.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTenDangNhap.setBounds(20, 10, 118, 18);
        pnlTT.add(lblTenDangNhap);
        
        JLabel lblMatKhau = new JLabel("Mật khẩu");
        lblMatKhau.setForeground(Color.BLACK);
        lblMatKhau.setFont(new Font("Arial", Font.PLAIN, 15));
        lblMatKhau.setBounds(20, 72, 98, 18);
        pnlTT.add(lblMatKhau);
        
        txtMatKhau = new JTextField();
        txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 14));
        txtMatKhau.setColumns(10);
        txtMatKhau.setBounds(10, 92, 347, 35);
        pnlTT.add(txtMatKhau);
        
        JLabel lblNgayTao = new JLabel("Ngày tạo");
        lblNgayTao.setForeground(Color.BLACK);
        lblNgayTao.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNgayTao.setBounds(20, 201, 59, 18);
        pnlTT.add(lblNgayTao);
        
        // Date picker setup
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hôm nay");
        properties.put("text.month", "Tháng");
        properties.put("text.year", "Năm");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Tải icon từ đường dẫn
        ImageIcon calendarIcon = new ImageIcon("D:\\Data\\tailieuvuive\\PTUD\\N2_QuanLyDatBanNhahang\\N2_QuanLyDatBanNhaHang\\img\\lich.png");

        // Lấy nút của datePicker và đặt icon cho nó
        JButton calendarButton = (JButton) datePicker.getComponent(1); // Lấy nút calendar
        calendarButton.setIcon(calendarIcon);

        // Set vị trí và kích thước của datePicker
        datePicker.setBounds(10, 229, 180, 35);
        pnlTT.add(datePicker);

        // Đặt kích thước và font chữ cho trường nhập ngày
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePicker.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));   
        
        JLabel lblChucVu = new JLabel("Chức vụ");
        lblChucVu.setForeground(Color.BLACK);
        lblChucVu.setFont(new Font("Arial", Font.PLAIN, 15));
        lblChucVu.setBounds(20, 138, 59, 18);
        pnlTT.add(lblChucVu);
        
        cbxChucVu = new JComboBox();
        cbxChucVu.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Nhân viên"}));
        cbxChucVu.setFont(new Font("Arial", Font.PLAIN, 15));
        cbxChucVu.setBounds(10, 160, 118, 35);
        pnlTT.add(cbxChucVu);
        
        btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSua.setBackground(new Color(255, 128, 64));
        btnSua.setForeground(new Color(255, 255, 255));
        btnSua.setFont(new Font("Arial", Font.BOLD, 12));
        btnSua.setBounds(98, 275, 80, 26);
        pnlTT.add(btnSua);
        
        btnXoa = new JButton("Xóa trắng");
        btnXoa.setForeground(new Color(255, 255, 255));
        btnXoa.setBackground(new Color(255, 0, 0));
        btnXoa.setFont(new Font("Arial", Font.BOLD, 12));
        btnXoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnXoa.setBounds(187, 275, 80, 26);
        pnlTT.add(btnXoa);
        
        btnLuu = new JButton("Cập nhật");
        btnLuu.setForeground(new Color(255, 255, 255));
        btnLuu.setBackground(new Color(0, 128, 0));
        btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
        btnLuu.setBounds(277, 275, 80, 26);
        pnlTT.add(btnLuu);
        
        btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.WHITE);
        btnThem.setFont(new Font("Arial", Font.BOLD, 12));
        btnThem.setBackground(new Color(0, 0, 255));
        btnThem.setBounds(8, 275, 80, 26);
        pnlTT.add(btnThem);
        
        JLabel lblDsTV = new JLabel("    Danh sách tài khoản");
        lblDsTV.setHorizontalAlignment(SwingConstants.LEFT);
        lblDsTV.setBackground(new Color(65, 41, 224));  // Set màu nền
        lblDsTV.setForeground(new Color(255, 255, 255));  // Set màu chữ
        lblDsTV.setFont(new Font("Arial", Font.BOLD, 18));
        lblDsTV.setBounds(387, 10, 1524, 40);
        lblDsTV.setOpaque(true);  // Bật hiển thị nền
        add(lblDsTV);
        
        JPanel panel = new JPanel();
        panel.setBounds(387, 56, 1524, 939);
        add(panel);
        panel.setLayout(null);
        
        JLabel lblTimKiem = new JLabel("Tìm kiếm tài khoản theo mã:");
        lblTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTimKiem.setBounds(47, 0, 212, 39);
        panel.add(lblTimKiem);
        
        txtTim = new JTextField();
        txtTim.setColumns(10);
        txtTim.setBounds(313, 2, 974, 37);
        panel.add(txtTim);
        
        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setFont(new Font("Arial", Font.BOLD, 18));
        btnTimKiem.setBackground(new Color(0, 128, 255));
        btnTimKiem.setBounds(1383, 0, 141, 37);
        panel.add(btnTimKiem);
        String row[] = {"Tài khoản", "Mật khẩu", "Chức vụ", "Ngày tạo"};
        modalTable = new DefaultTableModel(row, 0);
		table = new JTable(modalTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setRowHeight(30);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 50, 1524, 889);
		panel.add(scrollPane);
		
		
		docDL();
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtTenDangNhap.setText(table.getValueAt(row, 0).toString());
				txtMatKhau.setText(table.getValueAt(row, 1).toString());
				
				LocalDateTime ngayDangKy = (LocalDateTime) table.getValueAt(row, 3);
				Date date = Date.from(ngayDangKy.atZone(ZoneId.systemDefault()).toInstant());
				datePicker.getModel().setDate(date.getYear() + 1900, date.getMonth(), date.getDate());
				datePicker.getModel().setSelected(true);
				cbxChucVu.setSelectedItem(table.getValueAt(row, 2).toString()); 
			}
		});
		txtTim.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
					List<TaiKhoan> list1 = tk_dao.timTKbyMa(txtTim.getText());
					xoaDL();
					list1.forEach(i -> {

						modalTable.addRow(new Object[] {
						        i.getTaiKhoan(),
						        i.getMatKhau(),
						        i.isRole()?"Quản lý":"Nhân viên",
						        i.getNgayTaoTK()
						        
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
			if (true) {
				String taiKhoan = txtTenDangNhap.getText();
				String matKhau = txtMatKhau.getText();
				Boolean role = Boolean.parseBoolean(cbxChucVu.getSelectedItem().toString());
				Date selectedDate = (Date) datePicker.getModel().getValue();

				LocalDateTime ngaytao = null;
				if (selectedDate != null) {
				    ngaytao = selectedDate.toInstant()
				                          .atZone(ZoneId.systemDefault())
				                          .toLocalDateTime();
				} else {
				    System.out.println("Không có ngày nào được chọn");
				}
				TaiKhoan tk = new TaiKhoan(taiKhoan, matKhau, role, ngaytao);
				if (tk_dao.themTK(tk)) {
					table.clearSelection();
					xoaTrang();
					JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công !");
				} else {
					JOptionPane.showMessageDialog(null, "Tài khoản nhân viên không tồn tại !");
				}
			}
		} else if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn tài khoản cần sửa !");
			}else {
				if(true) {
					String taiKhoan = txtTenDangNhap.getText();
					String matKhau = txtMatKhau.getText();
					Boolean role = Boolean.parseBoolean(cbxChucVu.getSelectedItem().toString());
					Date selectedDate = (Date) datePicker.getModel().getValue();

					LocalDateTime ngaytao = null;
					if (selectedDate != null) {
					    ngaytao = selectedDate.toInstant()
					                          .atZone(ZoneId.systemDefault())
					                          .toLocalDateTime();
					} else {
					    System.out.println("Không có ngày nào được chọn");
					}
					TaiKhoan tk = new TaiKhoan(taiKhoan, matKhau, role, ngaytao);
					int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi ?","Cập nhật",
							JOptionPane.YES_NO_OPTION);
							if (t == JOptionPane.YES_OPTION) {
								if (tk_dao.updateTK(tk)) {
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
	//Hàm xóa DL  table model
		public void xoaDL() {
			modalTable.getDataVector().removeAllElements();
			modalTable.fireTableDataChanged();
		}
		//Hàm đọc DL  table model
		public void docDL() {
			List<TaiKhoan> listTK = tk_dao.getAllTK();
			listTK.forEach(e -> {
				modalTable.addRow(
						new Object[] { e.getTaiKhoan(),e.getMatKhau(),e.isRole()?"Quản lý":"Nhân viên",e.getNgayTaoTK()});

			});
		}
		public void xoaTrang() {
			txtTenDangNhap.setText("");
			txtMatKhau.setText("");
			cbxChucVu.setFocusable(true); 
			cbxChucVu.setSelectedIndex(0); 
			datePicker.getModel().setValue(null);
		}
		public void refreshTableData() {
		    // Lấy dữ liệu mới từ cơ sở dữ liệu hoặc danh sách
		    List<TaiKhoan> newData = tk_dao.getAllTK();
		    
		    // Xóa toàn bộ dữ liệu cũ trong DefaultTableModel
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0); 
		    // Thêm dữ liệu mới vào model
		    for (TaiKhoan tk : newData) {
		        Object[] row = {
		            tk.getTaiKhoan(),
		            tk.getMatKhau(),
		            tk.isRole()?"Quản lý":"Nhân viên",
		            tk.getNgayTaoTK()
		        };
		        model.addRow(row);
		    }

		    table.revalidate();
		    table.repaint();
		}
}

class CustomDateLabelFormatter extends AbstractFormatter {
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
