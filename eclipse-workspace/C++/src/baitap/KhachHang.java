package baitap;

import java.util.List;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private List<SanPham> list;

	public KhachHang(int maKH, String tenKH, List<SanPham> list) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.list = list;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public List<SanPham> getList() {
		return list;
	}

	public void setList(List<SanPham> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", list=" + list + "]";
	}

}
