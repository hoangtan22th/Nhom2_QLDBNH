package entity;

import java.time.LocalDate;

public class Thue {
	private String maThue;
	private boolean giaTriThue;
	private String tenThue;
	private LocalDate ngayApDung;
	private LocalDate ngayKetThuc;
	private String moTa;
	private String doiTuongChiuThue;
	public Thue(String maThue, boolean giaTriThue, String tenThue, LocalDate ngayApDung, LocalDate ngayKetThuc,
			String moTa, String doiTuongChiuThue) {
		super();
		this.maThue = maThue;
		this.giaTriThue = giaTriThue;
		this.tenThue = tenThue;
		this.ngayApDung = ngayApDung;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.doiTuongChiuThue = doiTuongChiuThue;
	}
	public String getMaThue() {
		return maThue;
	}
	public void setMaThue(String maThue) {
		this.maThue = maThue;
	}
	public boolean isGiaTriThue() {
		return giaTriThue;
	}
	public void setGiaTriThue(boolean giaTriThue) {
		this.giaTriThue = giaTriThue;
	}
	public String getTenThue() {
		return tenThue;
	}
	public void setTenThue(String tenThue) {
		this.tenThue = tenThue;
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
	public String getDoiTuongChiuThue() {
		return doiTuongChiuThue;
	}
	public void setDoiTuongChiuThue(String doiTuongChiuThue) {
		this.doiTuongChiuThue = doiTuongChiuThue;
	}
	@Override
	public String toString() {
		return "Thue [maThue=" + maThue + ", giaTriThue=" + giaTriThue + ", tenThue=" + tenThue + ", ngayApDung="
				+ ngayApDung + ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa + ", doiTuongChiuThue="
				+ doiTuongChiuThue + "]";
	}
	
}
