package entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String diaChi;
	private String sdt;
	private LocalDate ngaySinh;
	private LocalDate ngayVaoLam;
	private String gmail;
	private boolean chucVu;
	private double luongCB;
	public NhanVien(String maNV, String tenNV, String diaChi, String sdt, LocalDate ngaySinh, LocalDate ngayVaoLam,
			String gmail, boolean chucVu, double luongCB) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.gmail = gmail;
		this.chucVu = chucVu;
		this.luongCB = luongCB;
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVien() {
		super();
		
	}
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public boolean isChucVu() {
		return chucVu;
	}
	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}
	public double getLuongCB() {
		return luongCB;
	}
	public void setLuongCB(double luongCB) {
		this.luongCB = luongCB;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", diaChi=" + diaChi + ", sdt=" + sdt + ", ngaySinh="
				+ ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", gmail=" + gmail + ", chucVu=" + chucVu + ", luongCB="
				+ luongCB + "]";
	}
	
}
