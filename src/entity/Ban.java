package entity;

import java.time.LocalDateTime;

public class Ban {
	private String maBan;
	private String tenBan;
	private LocalDateTime thoiGianDatBan;
	private int soChoNgoi;
	private boolean trangThai;
	private boolean loaiBan;
	private KhuVucBan khuVucBan;
	public Ban(String maBan, String tenBan, LocalDateTime thoiGianDatBan, int soChoNgoi, boolean trangThai,
			boolean loaiBan, KhuVucBan khuVucBan) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.thoiGianDatBan = thoiGianDatBan;
		this.soChoNgoi = soChoNgoi;
		this.trangThai = trangThai;
		this.loaiBan = loaiBan;
		this.khuVucBan = khuVucBan;
	}
	public Ban() {
		super();
	}
	public Ban(String maBan) {
		super();
		this.maBan = maBan;
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getTenBan() {
		return tenBan;
	}
	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
	public LocalDateTime getThoiGianDatBan() {
		return thoiGianDatBan;
	}
	public void setThoiGianDatBan(LocalDateTime thoiGianDatBan) {
		this.thoiGianDatBan = thoiGianDatBan;
	}
	public int getSoChoNgoi() {
		return soChoNgoi;
	}
	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public boolean getLoaiBan() {
		return loaiBan;
	}
	public void setLoaiBan(boolean loaiBan) {
		this.loaiBan = loaiBan;
	}
	public KhuVucBan getKhuVucBan() {
		return khuVucBan;
	}
	public void setKhuVucBan(KhuVucBan khuVucBan) {
		this.khuVucBan = khuVucBan;
	}
	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", tenBan=" + tenBan + ", thoiGianDatBan=" + thoiGianDatBan + ", soChoNgoi="
				+ soChoNgoi + ", trangThai=" + trangThai + ", loaiBan=" + loaiBan + ", khuVucBan=" + khuVucBan + "]";
	}
	
}
