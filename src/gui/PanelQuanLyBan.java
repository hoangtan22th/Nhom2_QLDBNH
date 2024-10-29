package gui;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // Import ArrayList
import java.util.List;
import java.util.Properties;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dao.BanDAO;
import dao.KhuVucBanDAO;
import entity.Ban;
import entity.KhuVucBan;

import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;

public class PanelQuanLyBan extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JTextField txtMaBan;
   
    
    private ArrayList<String> banNames; // Danh sách tên bàn
    private static JTextField txtTen;
    private static JTextField txtSo;
	private static JPanel pnlBan;
	private ButtonGroup group_1;
	private static JComboBox cbThuong;
	private JButton btnThem;
	private static JRadioButton rdbThuong;
	private static JRadioButton rdbVIP;
	private JButton btnLamMoi;
	private JLabel lblLoaiBan;
	private JLabel lblTen;
	private ButtonGroup buttonGroup;
	private AbstractButton btnXoa;
	private JButton btnSua;
	private static JLabel lblMaBan;
	private static JLabel lblMa;

    public PanelQuanLyBan() {
        setLayout(null);
        createHeaderLabels();
        createInputPanel();
        createActionButtons();
      
       
    }

    private void createHeaderLabels() {
        Label lblTT = new Label("Thông tin");
        lblTT.setBackground(new Color(65, 41, 224));
        lblTT.setBounds(10, 10, 150, 40);
        add(lblTT);
        lblTT.setAlignment(Label.CENTER);
        lblTT.setForeground(Color.WHITE);
        lblTT.setFont(new Font("Arial", Font.BOLD, 17));

        JLabel lblDatCho = new JLabel("    Quản lý bàn");
        lblDatCho.setHorizontalAlignment(SwingConstants.LEFT);
        lblDatCho.setBackground(new Color(65, 41, 224));
        lblDatCho.setForeground(Color.WHITE);
        lblDatCho.setFont(new Font("Arial", Font.BOLD, 18));
        lblDatCho.setBounds(390, 10, 1524, 40);
        lblDatCho.setOpaque(true);
        add(lblDatCho);
    }

    private void createInputPanel() {
        JPanel pnlTT = new JPanel();
        pnlTT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
        pnlTT.setBounds(9, 99, 371, 929);
        add(pnlTT);
        pnlTT.setLayout(null);

        // Create the radio buttons
    
        JTextPane txpGhiChu = new JTextPane();
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
        panel.setBounds(10, 273, 351, 99);
        panel.setLayout(null);
        txpGhiChu.setBounds(0, 0, 348, 96);
        panel.add(txpGhiChu);
        pnlTT.add(panel);
        
        btnThem = new JButton("Thêm");
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setBackground(new Color(0, 191, 0));
        btnThem.setBounds(10, 434, 82, 30);
        pnlTT.add(btnThem);
        
        btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSua.setBackground(new Color(255, 128, 64));
        btnSua.setForeground(new Color(255, 255, 255));
        btnSua.setBounds(102, 434, 76, 30);
        pnlTT.add(btnSua);
        
        btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnXoa.setForeground(new Color(255, 255, 255));
        btnXoa.setBackground(new Color(255, 0, 0));
        btnXoa.setBounds(188, 434, 76, 30);
        pnlTT.add(btnXoa);
        
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setBackground(new Color(0, 0, 255));
        btnLamMoi.setForeground(new Color(255, 255, 255));
        btnLamMoi.setBounds(274, 434, 87, 30);
        pnlTT.add(btnLamMoi);
        
        lblLoaiBan = new JLabel("Chọn loại bàn");
        lblLoaiBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLoaiBan.setBounds(10, 10, 103, 35);
        pnlTT.add(lblLoaiBan);
        
        lblTen = new JLabel("Tên bàn");
        lblTen.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTen.setBounds(10, 141, 70, 21);
        pnlTT.add(lblTen);
        
        txtTen = new JTextField();
        txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTen.setColumns(10);
        txtTen.setBounds(10, 173, 202, 35);
        pnlTT.add(txtTen);
        
        JLabel lblSoCho = new JLabel("Số chỗ");
        lblSoCho.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSoCho.setBounds(251, 141, 70, 21);
        pnlTT.add(lblSoCho);
        
        txtSo = new JTextField();
        txtSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtSo.setBounds(222, 173, 139, 35);
        pnlTT.add(txtSo);
        txtSo.setColumns(10);
        
        cbThuong= new JComboBox();
        cbThuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbThuong.setBounds(10, 95, 351, 35);
        pnlTT.add(cbThuong);
        
        JLabel lblKhuVucBan = new JLabel("Chọn khu vực");
        lblKhuVucBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblKhuVucBan.setBounds(10, 54, 97, 30);
        pnlTT.add(lblKhuVucBan);
        KhuVucBanDAO khuVucBanDAO = new KhuVucBanDAO();
		List<String> khuVucBans = khuVucBanDAO.getAllTenKhuVucBan();

		for (String khuVucBan : khuVucBans) {
			cbThuong.addItem(khuVucBan);
		}
        
        JLabel lblGhiChu = new JLabel("Ghi chú");
        lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGhiChu.setBounds(10, 230, 70, 21);
        pnlTT.add(lblGhiChu);
        
 
        buttonGroup = new ButtonGroup();

        rdbThuong = new JRadioButton("Bàn thường");
        rdbThuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbThuong.setBounds(119, 16, 109, 23);
        pnlTT.add(rdbThuong);

   
        buttonGroup.add(rdbThuong);

        rdbVIP = new JRadioButton("Bàn VIP");
        rdbVIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbVIP.setBounds(252, 16, 109, 23);
        pnlTT.add(rdbVIP);

    
        buttonGroup.add(rdbVIP);

        
        pnlBan = new JPanel();
        pnlBan.setBounds(390, 60, 1524, 922);
        add(pnlBan);
        pnlBan.setLayout(new GridLayout(0, 1, 6, 15));
        
        btnThem.addActionListener(this);
        btnLamMoi.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        
        lblMaBan = new JLabel("Mã bàn:");
        lblMaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMaBan.setBounds(10, 60, 53, 28);
        add(lblMaBan);
        
        lblMa = new JLabel("");
        lblMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMa.setBounds(73, 60, 88, 28);
        add(lblMa);
        
    }

    public static void loadBanButtons() {
        BanDAO banDAO = new BanDAO();
        List<Ban> listBan = banDAO.getAllBans();

        pnlBan.removeAll(); 

        pnlBan.setLayout(new GridLayout(0, 4, 10, 10)); 

        for (Ban ban : listBan) {
            String buttonLabel = ban.getTenBan() + " - " + ban.getSoChoNgoi() + " chỗ";
            JButton btnBan = new JButton(buttonLabel);

            btnBan.setForeground(new Color(255, 255, 255));
            btnBan.setBackground(new Color(0, 117, 225));

        
            btnBan.addActionListener(e -> {
                loadBanInfo(ban); 
            });

            pnlBan.add(btnBan); 
        }

        pnlBan.revalidate();
        pnlBan.repaint();    
        cbThuong.revalidate();
        cbThuong.repaint();
    }


    private static void loadBanInfo(Ban ban) {
        txtTen.setText(ban.getTenBan()); 
        txtSo.setText(String.valueOf(ban.getSoChoNgoi())); 
        lblMa.setText(ban.getMaBan());
       
        cbThuong.setSelectedItem(ban.getKhuVucBan().getTenKhu());


        if (ban.getLoaiBan()) {
            rdbVIP.setSelected(true); 
        } else {
            rdbThuong.setSelected(true); 
        }
//    	JOptionPane.showMessageDialog(null, ban.getTenBan());
    }


    private void createActionButtons() {
        JPanel pnlTT = (JPanel) getComponent(2);
        
        JButton btnSua = createButton(pnlTT, "Sửa", new Color(255, 128, 64), Color.WHITE, 10, 382);
        JButton btnXoa = createButton(pnlTT, "Xóa", new Color(255, 0, 0), Color.WHITE, 115, 382);
        JButton btnLuu = createButton(pnlTT, "Lưu", new Color(0, 128, 0), Color.WHITE, 223, 382);
    }

   
    private JButton createButton(JPanel panel, String text, Color bgColor, Color fgColor, int x, int y) {
        JButton button = new JButton(text);
        button.setForeground(fgColor);
        button.setBackground(bgColor);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        
        
        if (panel != null) {
            panel.add(button);
        }
        return button;
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThem ) {
			String maBan1= lblMa.getText();
			BanDAO banDAO = new BanDAO();
			boolean check = banDAO.isMaBanExists(maBan1);
	        if (check == true) {
	            JOptionPane.showMessageDialog(null, "Mã bàn đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
            String tenBan = txtTen.getText();
            
            int soChoNgoi;
            try {
                soChoNgoi = Integer.parseInt(txtSo.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Số chỗ ngồi không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            boolean trangThai = false; 
            Boolean loaiBan;

     
            if (rdbThuong.isSelected()) {
                loaiBan = false;
            } else if (rdbVIP.isSelected()) {
                loaiBan = true;
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn loại bàn.");
                return;
            }
     

     
            
            String maBan = banDAO.generateMaBan();
            
            String tenKhu = (String) cbThuong.getSelectedItem();
            KhuVucBan khuVuc = banDAO.getKhuVucByTenKhu(tenKhu);
            String maKhu = khuVuc.getMaKhu(); 
            
            banDAO.insertBan(maBan, tenBan, soChoNgoi, trangThai, loaiBan, maKhu);
           
            
            txtTen.setText("");
            txtSo.setText("");
            cbThuong.setSelectedIndex(0);
   
            JOptionPane.showMessageDialog(null, "Thêm bàn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource() == btnSua) {
			
	        String maBan = lblMa.getText();
	      
	        String tenBan = txtTen.getText();
	        int soChoNgoi = Integer.parseInt(txtSo.getText());
	        boolean trangThai = false; 
	        boolean loaiBan;
	        if (rdbThuong.isSelected()) {
	            loaiBan = false;
	        } else if (rdbVIP.isSelected()) {
	            loaiBan = true;
	        } else {
	            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại bàn.");
	            return;
	        }
	        BanDAO banDAO = new BanDAO();	    
	        banDAO.updateBan(maBan, tenBan, soChoNgoi, trangThai, loaiBan);	        
	        JOptionPane.showMessageDialog(null, "Cập nhật bàn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        loadBanButtons(); 
	    } 
	    else if (e.getSource() == btnXoa) {
	     
	        String maBan = lblMa.getText(); 
	        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bàn này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            BanDAO banDAO = new BanDAO();
	            banDAO.deleteBan(maBan);            
	            JOptionPane.showMessageDialog(null, "Xóa bàn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            loadBanButtons(); 
	        }
	    }
	    else if (e.getSource() == btnLamMoi) {
	    	
	        loadBanButtons(); 
	    }
		
	}


}
