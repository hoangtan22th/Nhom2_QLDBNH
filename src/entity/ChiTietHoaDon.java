package entity;

public class ChiTietHoaDon {
	private String soLuongMonAn;
	private HoaDon hoaDon;
	private MonAnUong monAnUong;
	private KhuyenMai khuyenMai;
	private Ban ban;
	public ChiTietHoaDon(String soLuongMonAn, HoaDon hoaDon, MonAnUong monAnUong, KhuyenMai khuyenMai, Ban ban) {
		super();
		this.soLuongMonAn = soLuongMonAn;
		this.hoaDon = hoaDon;
		this.monAnUong = monAnUong;
		this.khuyenMai = khuyenMai;
		this.ban = ban;
	}
	public String getSoLuongMonAn() {
		return soLuongMonAn;
	}
	public void setSoLuongMonAn(String soLuongMonAn) {
		this.soLuongMonAn = soLuongMonAn;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public MonAnUong getMonAnUong() {
		return monAnUong;
	}
	public void setMonAnUong(MonAnUong monAnUong) {
		this.monAnUong = monAnUong;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public Ban getBan() {
		return ban;
	}
	public void setBan(Ban ban) {
		this.ban = ban;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuongMonAn=" + soLuongMonAn + ", hoaDon=" + hoaDon + ", monAnUong=" + monAnUong
				+ ", khuyenMai=" + khuyenMai + ", ban=" + ban + "]";
	}
	
}
