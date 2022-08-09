package baitap;

public class SanPham {
	private int maSP, giaSP;
	private String tenSP;

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(int giaSP) {
		this.giaSP = giaSP;
	}

	public SanPham(int maSP, int giaSP, String tenSP) {
		super();
		this.maSP = maSP;
		this.giaSP = giaSP;
		this.tenSP = tenSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", giaSP=" + giaSP + ", tenSP=" + tenSP + "]";
	}

}
