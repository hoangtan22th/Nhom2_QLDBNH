package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaiKhoan {
	private String taiKhoan;
	private String matKhau;
	private boolean role;
	private LocalDateTime ngayTaoTK;
	
	public TaiKhoan(String taiKhoan, String matKhau, boolean role, LocalDateTime ngayTaoTK) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.role = role;
		this.ngayTaoTK = ngayTaoTK;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public LocalDateTime getNgayTaoTK() {
		return ngayTaoTK;
	}
	public void setNgayTaoTK(LocalDateTime ngayTaoTK) {
		this.ngayTaoTK = ngayTaoTK;
	}
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", role=" + role + ", ngayTaoTK=" + ngayTaoTK
				+ "]";
	}
	public boolean checkTK() {
		
		return true;
	}
}
