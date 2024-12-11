package entity;

import java.time.LocalDate;

public class HoaDon {
	private String maHoaDon;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDate ngayLapHoaDon;
	private Thue thue;
	private Ban ban;
	private double thanhTien;
	private double tongTien;
	private boolean trangThai;
	public HoaDon(String maHoaDon, NhanVien nhanVien, KhachHang khachHang, LocalDate ngayLapHoaDon, Thue thue, Ban ban,
			double thanhTien, double tongTien, boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.thue = thue;
		this.ban = ban;
		this.thanhTien = thanhTien;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}
	public HoaDon() {
		
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public Thue getThue() {
		return thue;
	}
	public void setThue(Thue thue) {
		this.thue = thue;
	}
	public Ban getBan() {
		return ban;
	}
	public void setBan(Ban ban) {
		this.ban = ban;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ ", ngayLapHoaDon=" + ngayLapHoaDon + ", thue=" + thue + ", ban=" + ban + ", thanhTien=" + thanhTien
				+ ", tongTien=" + tongTien + ", trangThai=" + trangThai + "]";
	}
	
	
}
