package entity;
import java.time.LocalDateTime;

public class TheThanhVien {
	private String maTTV;
	private KhachHang khachHang;
	private LoaiThe loaiThe;
	private double diemTichLuy;
	private LocalDateTime ngayDangKy;
	public TheThanhVien(String maTTV, KhachHang khachHang, LoaiThe loaiThe, double diemTichLuy,
			LocalDateTime ngayDangKy) {
		super();
		this.maTTV = maTTV;
		this.khachHang = khachHang;
		this.loaiThe = loaiThe;
		this.diemTichLuy = diemTichLuy;
		this.ngayDangKy = ngayDangKy;
	}
	public String getMaTTV() {
		return maTTV;
	}
	public void setMaTTV(String maTTV) {
		this.maTTV = maTTV;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public LoaiThe getLoaiThe() {
		return loaiThe;
	}
	public void setLoaiThe(LoaiThe loaiThe) {
		this.loaiThe = loaiThe;
	}
	public double getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(double diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	public LocalDateTime getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(LocalDateTime ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	@Override
	public String toString() {
		return "TheThanhVien [maTTV=" + maTTV + ", khachHang=" + khachHang + ", loaiThe=" + loaiThe + ", diemTichLuy="
				+ diemTichLuy + ", ngayDangKy=" + ngayDangKy + "]";
	}
	
	
	
}
