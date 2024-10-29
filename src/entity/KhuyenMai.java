package entity;

import java.time.LocalDate;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private double giaTriKhuyenMai;
	private LocalDate ngayApDung;
	private LocalDate ngayKetThuc;
	private String moTa;
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, double giaTriKhuyenMai, LocalDate ngayApDung,
			LocalDate ngayKetThuc, String moTa) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.giaTriKhuyenMai = giaTriKhuyenMai;
		this.ngayApDung = ngayApDung;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public double getGiaTriKhuyenMai() {
		return giaTriKhuyenMai;
	}
	public void setGiaTriKhuyenMai(double giaTriKhuyenMai) {
		this.giaTriKhuyenMai = giaTriKhuyenMai;
	}
	public LocalDate getNgayApDung() {
		return ngayApDung;
	}
	public void setNgayApDung(LocalDate ngayApDung) {
		this.ngayApDung = ngayApDung;
	}
	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", giaTriKhuyenMai="
				+ giaTriKhuyenMai + ", ngayApDung=" + ngayApDung + ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa
				+ "]";
	}
	
	
}
