package entity;

import java.time.LocalDateTime;

public class ChiTietPhieuDat {
	private int soLuong;
	private MonAnUong monAnUong;
	private PhieuDatBan phieuDatBan;
	private Ban ban;
	public ChiTietPhieuDat(int soLuong, MonAnUong monAnUong, PhieuDatBan phieuDatBan, Ban ban) {
		super();
		this.soLuong = soLuong;
		this.monAnUong = monAnUong;
		this.phieuDatBan = phieuDatBan;
		this.ban = ban;
	}
	public ChiTietPhieuDat() {
		
	}
	

	public ChiTietPhieuDat(int soLuong2, MonAnUong monAnUong2, LocalDateTime thoiGianDen, int soLuongKhach) {
		// TODO Auto-generated constructor stub
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public MonAnUong getMonAnUong() {
		return monAnUong;
	}
	public void setMonAnUong(MonAnUong monAnUong) {
		this.monAnUong = monAnUong;
	}
	public PhieuDatBan getPhieuDatBan() {
		return phieuDatBan;
	}
	public void setPhieuDatBan(PhieuDatBan phieuDatBan) {
		this.phieuDatBan = phieuDatBan;
	}
	public Ban getBan() {
		return ban;
	}
	public void setBan(Ban ban) {
		this.ban = ban;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuDat [soLuong=" + soLuong + ", monAnUong=" + monAnUong + ", phieuDatBan=" + phieuDatBan
				+ ", ban=" + ban + "]";
	}
	
}
