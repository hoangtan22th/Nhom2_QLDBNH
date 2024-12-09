package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;
import java.util.List;
import java.util.Properties;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.HoaDonDAO;

public class PanelThongKeMonAn extends JPanel {

    private static final long serialVersionUID = 1L;
    private JDatePickerImpl datePickerBD, datePickerKT;
    private JPanel pnlChart;
    private JLabel lblTien,lblTienLoi;
    private JButton btnNewButton;

    /**
     * Create the panel.
     */
    public PanelThongKeMonAn() {
        setLayout(null);

        Label lblTT = new Label("Thống kê món ăn uống");
        lblTT.setBackground(new Color(65, 41, 224));
        lblTT.setBounds(10, 10, 1896, 40);
        add(lblTT);
        lblTT.setForeground(new Color(255, 255, 255));
        lblTT.setFont(new Font("Arial", Font.BOLD, 17));

        JPanel pnlDoanhThu = new JPanel();
        pnlDoanhThu.setBackground(new Color(0, 128, 255));
        pnlDoanhThu.setBounds(10, 56, 327, 147);
        add(pnlDoanhThu);
        pnlDoanhThu.setLayout(null);

        JLabel lblNewLabel = new JLabel("Doanh thu hôm nay");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
        lblNewLabel.setBounds(66, 24, 190, 20);
        pnlDoanhThu.add(lblNewLabel);

        lblTien = new JLabel("100.000đ");
        lblTien.setHorizontalAlignment(SwingConstants.CENTER);
        lblTien.setFont(new Font("Arial", Font.BOLD, 16));
        lblTien.setForeground(new Color(0, 0, 0));
        lblTien.setBounds(81, 80, 175, 20);
        pnlDoanhThu.add(lblTien);
        updateRevenueLabel();

        JPanel pnlTong = new JPanel();
        pnlTong.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnlTong.setBounds(1436, 56, 470, 255);
        add(pnlTong);
        pnlTong.setLayout(null);

        JPanel pnlLoi = new JPanel();
        pnlLoi.setBackground(new Color(0, 128, 255));
        pnlLoi.setBounds(0, 0, 470, 151);
        pnlTong.add(pnlLoi);
        pnlLoi.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Lợi nhuận");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(174, 11, 147, 35);
        pnlLoi.add(lblNewLabel_1);

        lblTienLoi = new JLabel("0đ");
        lblTienLoi.setFont(new Font("Arial", Font.BOLD, 17));
        lblTienLoi.setHorizontalAlignment(SwingConstants.CENTER);
        lblTienLoi.setBounds(167, 72, 154, 47);
        pnlLoi.add(lblTienLoi);

        JLabel lblNewLabel_2 = new JLabel("Thời gian bắt đầu");
        lblNewLabel_2.setBounds(23, 162, 151, 23);
        pnlTong.add(lblNewLabel_2);

        // Date picker setup
        UtilDateModel modelDate = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hôm nay");
        properties.put("text.month", "Tháng");
        properties.put("text.year", "Năm");

        JDatePanelImpl datePanel = new JDatePanelImpl(modelDate, properties);
        datePickerBD = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        JButton calendarButton = (JButton) datePickerBD.getComponent(1);
        calendarButton.setIcon(new ImageIcon("img/lich.png"));
        datePickerBD.setBounds(10, 197, 180, 35);
        pnlTong.add(datePickerBD);

        datePickerBD.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePickerBD.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNewLabel_2_1 = new JLabel("Thời gian kết thúc");
        lblNewLabel_2_1.setBounds(229, 162, 151, 23);
        pnlTong.add(lblNewLabel_2_1);

        UtilDateModel modelDate1 = new UtilDateModel();
        Properties properties1 = new Properties();
        properties1.put("text.today", "Hôm nay");
        properties1.put("text.month", "Tháng");
        properties1.put("text.year", "Năm");

        JDatePanelImpl datePanel1 = new JDatePanelImpl(modelDate1, properties1);
        datePickerKT = new JDatePickerImpl(datePanel1, new DateLabelFormatter());

        JButton calendarButton1 = (JButton) datePickerKT.getComponent(1);
        calendarButton1.setIcon(new ImageIcon("img/lich.png"));
        datePickerKT.setBounds(200, 197, 180, 35);
        pnlTong.add(datePickerKT);

        datePickerKT.getJFormattedTextField().setPreferredSize(new Dimension(100, 35));
        datePickerKT.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 15));

        btnNewButton = new JButton("Lọc");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(2, 204, 73));
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
        btnNewButton.setBounds(390, 197, 70, 35);
        pnlTong.add(btnNewButton);

        // Gọi phương thức xử lý sự kiện lọc khi nhấn nút "Lọc"
        btnNewButton.addActionListener(e -> filterData());

        pnlChart = new JPanel();
        pnlChart.setBounds(10, 322, 1896, 733);
        add(pnlChart);

        // Thêm biểu đồ cột
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(150, "Số lượng", "Pizza");
        dataset.addValue(120, "Số lượng", "Burger");
        dataset.addValue(100, "Số lượng", "Trà sữa");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Top 10 sản phẩm bán chạy", 
                "Sản phẩm", 
                "Số lượng", 
                dataset);
        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 14));
        CategoryAxis xAxis = barChart.getCategoryPlot().getDomainAxis();
        xAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10)); // Giảm kích thước tiêu đề trục X

        // Lấy đối tượng trục Y và thay đổi phông chữ tiêu đề
        NumberAxis yAxis = (NumberAxis) barChart.getCategoryPlot().getRangeAxis();
        yAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10)); 
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMaximumDrawHeight(320);
        chartPanel.setPreferredSize(new Dimension(1896, 755));
        pnlChart.add(chartPanel);
    }

    /**
     * Xử lý sự kiện lọc
     */
    private void updateChartWithTopSellingDish(String topSellingDish) {
        // Tạo dataset mới với dữ liệu món ăn bán chạy nhất
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Thêm dữ liệu vào dataset
        // Đây chỉ là ví dụ với dữ liệu cứng
        dataset.addValue(200, "Số lượng", topSellingDish);  // Replace 200 with actual sales number
        
        // Tạo biểu đồ mới với dataset đã cập nhật
        JFreeChart barChart = ChartFactory.createBarChart(
            "Top 10 sản phẩm bán chạy", 
            "Sản phẩm", 
            "Số lượng", 
            dataset);

        // Cập nhật tiêu đề và các thuộc tính của biểu đồ
        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 14));
        CategoryAxis xAxis = barChart.getCategoryPlot().getDomainAxis();
        xAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10));
        NumberAxis yAxis = (NumberAxis) barChart.getCategoryPlot().getRangeAxis();
        yAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10));

        // Thêm biểu đồ mới vào chart panel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMaximumDrawHeight(320);
        chartPanel.setPreferredSize(new Dimension(1896, 755));
        pnlChart.removeAll();  // Remove old chart
        pnlChart.add(chartPanel);  // Add new chart
        pnlChart.revalidate();  // Revalidate panel
        pnlChart.repaint();  // Repaint panel
    }
    private void filterData() {
        // Lấy giá trị từ datePickerBD và datePickerKT
        Object startDate = datePickerBD.getModel().getValue();
        Object endDate = datePickerKT.getModel().getValue();

        // Kiểm tra ngày được chọn
        if (startDate != null && endDate != null) {
            // Chuyển đổi ngày từ Object sang java.util.Date
            java.util.Date startUtilDate = (java.util.Date) startDate;
            java.util.Date endUtilDate = (java.util.Date) endDate;

            // Kiểm tra nếu ngày bắt đầu lớn hơn ngày kết thúc
            if (startUtilDate.after(endUtilDate)) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc!");
                return; // Dừng lại không thực hiện tiếp các bước phía dưới
            }

            // Chuyển đổi java.util.Date sang java.sql.Date và định dạng theo yyyy-MM-dd
            String startDateStr = new java.sql.Date(startUtilDate.getTime()).toString();
            String endDateStr = new java.sql.Date(endUtilDate.getTime()).toString();

            // Tạo instance của HoaDonDAO
            HoaDonDAO hoaDonDAO = new HoaDonDAO();

            // Lấy danh sách món ăn bán chạy nhất trong khoảng thời gian đã chọn
            List<String> topSellingDishes = hoaDonDAO.findTopSellingDishes(startDateStr, endDateStr);

            if (!topSellingDishes.isEmpty()) {
                System.out.println("Danh sách món ăn bán chạy nhất:");
                for (String dish : topSellingDishes) {
                    System.out.println(dish);
                }

                // Cập nhật biểu đồ với danh sách món ăn bán chạy nhất
                updateChartWithTopSellingDishes(topSellingDishes);
            } else {
               JOptionPane.showMessageDialog(null, "Không có dữ liệu nào trong khoảng thời gian đã chọn.");
            }

            // **Cập nhật tổng doanh thu cho khoảng thời gian đã chọn**
            double totalRevenue = hoaDonDAO.getTotalRevenue(startDateStr, endDateStr);
            double totalRevenueLoi = hoaDonDAO.getTotalRevenue(startDateStr, endDateStr) * 0.45;

            // Định dạng tiền VND
            java.text.NumberFormat currencyFormat = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
            String formattedRevenue = currencyFormat.format(totalRevenue);
            String formattedRevenue1 = currencyFormat.format(totalRevenueLoi);

            // Cập nhật giá trị cho lblTien
            lblTien.setText(formattedRevenue);
            lblTienLoi.setText(formattedRevenue1);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu và ngày kết thúc.");
        }
    }



    private void updateChartWithTopSellingDishes(List<String> topSellingDishes) {
        // Tạo dataset mới
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Thêm dữ liệu vào dataset
        for (String dish : topSellingDishes) {
            // Tách tên món ăn và số lượng từ chuỗi
            String[] parts = dish.split(" \\(Số lượng: ");
            if (parts.length == 2) {
                String dishName = parts[0];
                int quantity = Integer.parseInt(parts[1].replace(")", "").trim());
                dataset.addValue(quantity, "Số lượng", dishName);
            }
        }

        // Tạo biểu đồ mới với dataset đã cập nhật
        JFreeChart barChart = ChartFactory.createBarChart(
            "Top 10 sản phẩm bán chạy", 
            "Sản phẩm", 
            "Số lượng", 
            dataset);

        // Cập nhật tiêu đề và các thuộc tính của biểu đồ
        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 14));
        CategoryAxis xAxis = barChart.getCategoryPlot().getDomainAxis();
        xAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10));
        NumberAxis yAxis = (NumberAxis) barChart.getCategoryPlot().getRangeAxis();
        yAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10));

        // Thêm biểu đồ mới vào chart panel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMaximumDrawHeight(320);
        chartPanel.setPreferredSize(new Dimension(1896, 755));
        pnlChart.removeAll();  // Remove old chart
        pnlChart.add(chartPanel);  // Add new chart
        pnlChart.revalidate();  // Revalidate panel
        pnlChart.repaint();  // Repaint panel
    }
    private void updateRevenueLabel() {
        // Giả sử hôm nay là ngày hiện tại, bạn có thể sử dụng LocalDate để lấy ngày hôm nay
        java.time.LocalDate today = java.time.LocalDate.now();
        String ngayBatDau = today.toString(); // Ngày bắt đầu
        String ngayKetThuc = today.toString(); // Ngày kết thúc (trong ngày hôm nay)

        // Tạo một instance của HoaDonDAO
        HoaDonDAO hoaDonDAO = new HoaDonDAO();

        // Gọi phương thức lấy tổng doanh thu
        double totalRevenue = hoaDonDAO.getTotalRevenue(ngayBatDau, ngayKetThuc);

        // Định dạng tiền VND
        java.text.NumberFormat currencyFormat = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
        String formattedRevenue = currencyFormat.format(totalRevenue);

        // Cập nhật giá trị cho lblTien
        lblTien.setText(formattedRevenue);
    }

}
