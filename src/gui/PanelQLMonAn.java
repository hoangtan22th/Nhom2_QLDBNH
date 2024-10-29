package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dao.MonAnUongDAO;
import entity.MonAnUong;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class PanelQLMonAn extends JPanel implements ActionListener,MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtGia;
	private JTextField textField;
	private JTable tbDsMonAn;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLamMoi;
	private JTextArea txtGhiChu;
	private JTextField txtTimKiem;


	public void loadDataToTable(){
		MonAnUongDAO monAnUongDAO = new MonAnUongDAO();
		List<MonAnUong> listMonAn = monAnUongDAO.loadAllMonAnUong();
		
		DefaultTableModel model = (DefaultTableModel) tbDsMonAn.getModel();
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

	public PanelQLMonAn(){
		setLayout(null);
		
	
		Label lblTT = new Label("Thông tin");
		lblTT.setBackground(new Color(65, 41, 224));
		lblTT.setBounds(10, 10, 150, 40);
		lblTT.setAlignment(Label.CENTER);
		lblTT.setForeground(Color.WHITE);
		lblTT.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblTT);
		
		JLabel lblDsMonAn = new JLabel("    Danh sách món ăn");
		lblDsMonAn.setHorizontalAlignment(SwingConstants.LEFT);
		lblDsMonAn.setBackground(new Color(65, 41, 224));
		lblDsMonAn.setForeground(Color.WHITE);
		lblDsMonAn.setFont(new Font("Arial", Font.BOLD, 18));
		lblDsMonAn.setBounds(387, 10, 1524, 40);
		lblDsMonAn.setOpaque(true);
		add(lblDsMonAn);
		
		JPanel pnlTT = new JPanel();
		pnlTT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		pnlTT.setBounds(10, 56, 367, 935);
		add(pnlTT);
		pnlTT.setLayout(null);
		

		JLabel lblMa = new JLabel("Mã món");
		lblMa.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMa.setBounds(20, 10, 89, 24);
		pnlTT.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setBounds(10, 35, 347, 35);
		pnlTT.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblTen = new JLabel("Tên món");
		lblTen.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTen.setBounds(20, 80, 89, 24);
		pnlTT.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(10, 105, 347, 35);
		pnlTT.add(txtTen);
		
		JLabel lblGia = new JLabel("Giá tiền");
		lblGia.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGia.setBounds(20, 149, 89, 24);
		pnlTT.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(10, 175, 347, 35);
		pnlTT.add(txtGia);
		
		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGhiChu.setBounds(20, 221, 114, 29);
		pnlTT.add(lblGhiChu);
		
		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(10, 261, 347, 99);
		pnlTT.add(txtGhiChu);
		
	
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 191, 0));
		btnThem.setBounds(10, 385, 76, 30);
		btnThem.addActionListener(this);
		pnlTT.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(255, 128, 64));
		btnSua.setBounds(96, 385, 76, 30);
		btnSua.addActionListener(this);
		pnlTT.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(182, 385, 76, 30);
		btnXoa.addActionListener(this);
		pnlTT.add(btnXoa);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setBackground(Color.BLUE);
		btnLamMoi.setBounds(268, 385, 89, 30);
		btnLamMoi.addActionListener(this);
		pnlTT.add(btnLamMoi);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 191, 1524, 800);
		add(scrollPane);
		
		tbDsMonAn = new JTable();
		tbDsMonAn.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"STT", "Mã món", "Tên món", "Giá tiền", "Loại món", "Ghi chú"
			}
		));
		scrollPane.setViewportView(tbDsMonAn);
		tbDsMonAn.setRowHeight(30);
		
	
		tbDsMonAn.addMouseListener(this);
		
		JLabel lblLoaiMon = new JLabel("Loại món");
		lblLoaiMon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoaiMon.setBounds(387, 61, 71, 40);
		add(lblLoaiMon);
		
		JComboBox cbLoaiMon = new JComboBox();
		cbLoaiMon.setBounds(468, 61, 150, 40);
		add(cbLoaiMon);
		
		JLabel lblTimKiem = new JLabel("Nhập tên món cần tìm");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimKiem.setBounds(387, 124, 162, 38);
		add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(559, 124, 568, 40);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(1137, 124, 124, 40);
		add(btnTimKiem);
		loadDataToTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnThem) {
	        addMonAn();
	    } else if (e.getSource() == btnSua) {
	        updateMonAn();
	    } else if (e.getSource() == btnXoa) {
	        deleteMonAn();
	    } else if (e.getSource() == btnLamMoi) {
	        clearFields();
	    }
	}

	private void addMonAn() {
	    MonAnUongDAO monAnUongDAO = new MonAnUongDAO();
	    MonAnUong newMonAn = new MonAnUong();
	    
	    newMonAn.setMaMonAnUong(txtMa.getText());
	    newMonAn.setTenMonAnUong(txtTen.getText());
	 
	    newMonAn.setGiaTien(Double.parseDouble(txtGia.getText()));
	 

	    monAnUongDAO.addMonAnUong(newMonAn);
	    loadDataToTable(); 
	}

	private void updateMonAn() {
	    MonAnUongDAO monAnUongDAO = new MonAnUongDAO();
	    MonAnUong updatedMonAn = new MonAnUong();

	    updatedMonAn.setMaMonAnUong(txtMa.getText());
	    updatedMonAn.setTenMonAnUong(txtTen.getText());
	    
	    updatedMonAn.setGiaTien(Double.parseDouble(txtGia.getText()));
	

	    monAnUongDAO.updateMonAnUong(updatedMonAn);
	    loadDataToTable(); 
	}

	private void deleteMonAn() {
	    MonAnUongDAO monAnUongDAO = new MonAnUongDAO();
	    String maMonAn = txtMa.getText();
	    monAnUongDAO.deleteMonAnUong(maMonAn);
	    loadDataToTable(); 
	}

	private void clearFields() {
	    txtMa.setText("");
	    txtTen.setText("");
	    txtGia.setText("");
	  
	    txtGhiChu.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// THIẾU LOẠI MÓN MAI CẬP NHẬT
	    if (e.getClickCount() == 1) { 
	        int row = tbDsMonAn.getSelectedRow(); 
	        if (row != -1) { 
	
	            String maMonAn = tbDsMonAn.getValueAt(row, 1).toString(); 
	            String tenMonAn = tbDsMonAn.getValueAt(row, 2).toString(); 
	            
	            String giaTien = tbDsMonAn.getValueAt(row, 3).toString();
	            String loaiMon = "Chưa có";

	        
	            txtMa.setText(maMonAn);
	            txtTen.setText(tenMonAn);
	       
	            txtGia.setText(giaTien);
	            
	        }
	    }
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
