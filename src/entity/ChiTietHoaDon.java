package entity;

public class ChiTietHoaDon {
	private int soLuongMonAn;
	private HoaDon hoaDon;
	private MonAnUong monAnUong;
	private KhuyenMai khuyenMai;
	public ChiTietHoaDon(int soLuongMonAn, HoaDon hoaDon, MonAnUong monAnUong, KhuyenMai khuyenMai) {
		super();
		this.soLuongMonAn = soLuongMonAn;
		this.hoaDon = hoaDon;
		this.monAnUong = monAnUong;
		this.khuyenMai = khuyenMai;
	
	}
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}
	public int getSoLuongMonAn() {
		return soLuongMonAn;
	}
	public void setSoLuongMonAn(int soLuongMonAn) {
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
	
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuongMonAn=" + soLuongMonAn + ", hoaDon=" + hoaDon + ", monAnUong=" + monAnUong
				+ ", khuyenMai=" + khuyenMai + "]";
	}
	
}
