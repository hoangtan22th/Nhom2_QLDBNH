package entity;

import java.time.LocalDate;

public class HoaDon {
	private String maHoaDon;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDate ngayLapHoaDon;
	private Thue thue;
	public HoaDon(String maHoaDon, NhanVien nhanVien, KhachHang khachHang, LocalDate ngayLapHoaDon, Thue thue) {
		super();
		this.maHoaDon = maHoaDon;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.thue = thue;
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
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ ", ngayLapHoaDon=" + ngayLapHoaDon + ", thue=" + thue + "]";
	}
	
	
}
