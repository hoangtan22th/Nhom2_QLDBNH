package entity;

public class KhuVucBan {
	private String maKhu;
	private String tenKhu;
	private int soBan;
	public KhuVucBan(String maKhu, String tenKhu, int soBan) {
		super();
		this.maKhu = maKhu;
		this.tenKhu = tenKhu;
		this.soBan = soBan;
	}
	public String getMaKhu() {
		return maKhu;
	}
	public void setMaKhu(String maKhu) {
		this.maKhu = maKhu;
	}
	public String getTenKhu() {
		return tenKhu;
	}
	public void setTenKhu(String tenKhu) {
		this.tenKhu = tenKhu;
	}
	public int getSoBan() {
		return soBan;
	}
	public void setSoBan(int soBan) {
		this.soBan = soBan;
	}
	@Override
	public String toString() {
		return "KhuVucBan [maKhu=" + maKhu + ", tenKhu=" + tenKhu + ", soBan=" + soBan + "]";
//		return tenKhu;
	}
	
}
