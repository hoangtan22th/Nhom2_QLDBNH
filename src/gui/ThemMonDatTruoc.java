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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class ThemMonDatTruoc extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_4;
	private JTable tbMonAn;
	private int STT = 1;
	private Container pnlTT;
	private JButton btnXacNhan;
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
					ThemMonDatTruoc frame = new ThemMonDatTruoc();
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
	
	public ThemMonDatTruoc() {
		
		setBounds(100, 100, 908, 812);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 35, 800, 706);
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
		
		btnXacNhan = new JButton("Thêm món");
		btnXacNhan.setBackground(Color.ORANGE);
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXacNhan.setBounds(672, 654, 118, 41);
		panel_1.add(btnXacNhan);
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
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	 if(e.getSource() == btnXacNhan) {
	
			// Chọn món ăn từ bảng tbMonAn (có thể là JTable khác)
			int selectedRow = tbMonAn.getSelectedRow();
			if (selectedRow != -1) {
			    DefaultTableModel modelMonAn = (DefaultTableModel) tbMonAn.getModel();

			    String maMonAnUong = (String) modelMonAn.getValueAt(selectedRow, 1);
			    String tenMonAnUong = (String) modelMonAn.getValueAt(selectedRow, 2);
			    double giaTien = (double) modelMonAn.getValueAt(selectedRow, 3);
			    String loai = (String) modelMonAn.getValueAt(selectedRow, 4);

			    // Truy cập modelMonAnTrenBan từ lớp PhieuDat thông qua biến static
			    DefaultTableModel modelMonAnTrenBan = PhieuDat.modelMonAnTrenBan;
			    
			    boolean daTonTai = false;
			    for (int i = 0; i < modelMonAnTrenBan.getRowCount(); i++) {
			        String maMonAnTrenBan = (String) modelMonAnTrenBan.getValueAt(i, 1);
			        
			        if (maMonAnTrenBan.equals(maMonAnUong)) {
			            int soLuongHienTai = (int) modelMonAnTrenBan.getValueAt(i, 5);
			            modelMonAnTrenBan.setValueAt(soLuongHienTai + 1, i, 5); // Cập nhật số lượng món
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
			            1,  // Số lượng mặc định là 1
			        });
			    }

			    // Cập nhật bảng trong giao diện PhieuDat
			    PhieuDat.tbMonAnTrenBan.setModel(modelMonAnTrenBan);
			} else {
			    JOptionPane.showMessageDialog(null, "Vui lòng chọn một món ăn để thêm.");
			}
		}}
}
