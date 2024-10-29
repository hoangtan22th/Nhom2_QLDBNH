package entity;

public class MonAnUong {
	private String maMonAnUong;
	private String tenMonAnUong;
	private double giaTien;
	private String loai;

	public MonAnUong(String maMonAnUong, String tenMonAnUong, double giaTien, String loai) {
		super();
		this.maMonAnUong = maMonAnUong;
		this.tenMonAnUong = tenMonAnUong;
		this.giaTien = giaTien;
		this.loai = loai;
		
	}
	public MonAnUong() {
		
	}
public MonAnUong(String maMonAnUong) {
	super();
	this.maMonAnUong = maMonAnUong;
	}
	public String getMaMonAnUong() {
		return maMonAnUong;
	}
	public void setMaMonAnUong(String maMonAnUong) {
		this.maMonAnUong = maMonAnUong;
	}
	public String getTenMonAnUong() {
		return tenMonAnUong;
	}
	public void setTenMonAnUong(String tenMonAnUong) {
		this.tenMonAnUong = tenMonAnUong;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;}
	
	@Override
	public String toString() {
		return "MonAnUong [monAnUong=" + maMonAnUong + ", tenMonAnUong=" + tenMonAnUong + ", giaTien=" + giaTien
				+ ", loai=" + loai + ",]";
	}
	
}
