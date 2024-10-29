package entity;
import java.time.LocalDate;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private LocalDate ngaySinh;
	private String sdt;
	private TheThanhVien theThanhVien;
	public KhachHang(String maKH, String tenKH, LocalDate ngaySinh, String sdt, TheThanhVien theThanhVien) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.theThanhVien = theThanhVien;
	}
	public KhachHang(String maKH, String tenKH, LocalDate ngaySinh, String sdt) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
	}
	public KhachHang(String tenKH,String sdt) {
		super();
		this.tenKH = tenKH;
		this.sdt = sdt;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public TheThanhVien getTheThanhVien() {
		return theThanhVien;
	}
	public void setTheThanhVien(TheThanhVien theThanhVien) {
		this.theThanhVien = theThanhVien;
	}
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt
				+ ", theThanhVien=" + theThanhVien + "]";
	}
	
}
