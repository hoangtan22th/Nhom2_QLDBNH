package gui;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class loading extends JFrame {
    private JProgressBar progressBar;
    private JLabel messageLabel;

    public loading() {
        setTitle("Loading...");
        setSize(860, 308);
        setLocationRelativeTo(null); // Canh giữa màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Tạo thanh tiến trình
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(0, 88, 844, 179);
        progressBar.setStringPainted(true); // Hiển thị % tải
        getContentPane().add(progressBar);

        // Tạo nhãn hiển thị thông điệp
        messageLabel = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ ĐẶT BÀN NHÀ HÀNG", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        messageLabel.setBounds(0, 0, 844, 77);
        getContentPane().add(messageLabel);
        
        JLabel lblNewLabel = new JLabel("Đang khởi động...");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 54, 148, 23);
        getContentPane().add(lblNewLabel);

        // Hiển thị giao diện
        setVisible(true);

        // Bắt đầu tiến trình tải
        startLoadingProcess();
    }

    // Phương thức bắt đầu tiến trình tải
    private void startLoadingProcess() {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            String[] messages = {
                "Đang tải dữ liệu...",
                "Đang tải database...",
                "Đang tải modules...",
                "Đang chuẩn bị giao diện..."
            };

            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(20); // Tạm dừng 20 milliseconds
                    publish(i); // Cập nhật tiến trình
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int i = chunks.get(chunks.size() - 1); // Lấy giá trị cuối cùng được cập nhật
                progressBar.setValue(i);

                // Cập nhật thông báo theo tỷ lệ phần trăm
                int index = i / (100 / messages.length);
                if (index < messages.length) {
                    messageLabel.setText(messages[index]);
                }
            }

            @Override
            protected void done() {
                // Sau khi hoàn thành, đóng giao diện load và mở giao diện chính
                dispose(); // Đóng cửa sổ loading
                new DangNhap().setVisible(true);; // Mở giao diện chính
            }
        };

        worker.execute(); // Bắt đầu tiến trình tải
    }



    public static void main(String[] args) {
        // Chạy chương trình
        SwingUtilities.invokeLater(() -> new loading());
    }
}
