package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PhieuDatBan {
	private String maPhieuDat;
	private String tenKhachDat;
	private int soLuongKhach;
	private LocalDateTime ngayDat;
	private String ghiChu;
	private boolean trangThai;
	private NhanVien nhanVien;
	
	public PhieuDatBan(String maPhieuDat, String tenKhachDat, int soLuongKhach, LocalDateTime ngayDat, String ghiChu,
			boolean trangThai, NhanVien nhanVien) {
		super();
		this.maPhieuDat = maPhieuDat;
		this.tenKhachDat = tenKhachDat;
		this.soLuongKhach = soLuongKhach;
		this.ngayDat = ngayDat;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
	}
	public String getMaPhieuDat() {
		return maPhieuDat;
	}
	public void setMaPhieuDat(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
	}
	public String getTenKhachDat() {
		return tenKhachDat;
	}
	public void setTenKhachDat(String tenKhachDat) {
		this.tenKhachDat = tenKhachDat;
	}
	public int getSoLuongKhach() {
		return soLuongKhach;
	}
	public void setSoLuongKhach(int soLuongKhach) {
		this.soLuongKhach = soLuongKhach;
	}
	public LocalDateTime getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(LocalDateTime ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "PhieuDatBan [maPhieuDat=" + maPhieuDat + ", tenKhachDat=" + tenKhachDat + ", soLuongKhach="
				+ soLuongKhach + ", ngayDat=" + ngayDat + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai
				+ ", nhanVien=" + nhanVien + "]";
	}
	
	
}
