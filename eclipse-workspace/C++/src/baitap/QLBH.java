package baitap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LookaheadCharInputReader;

public class QLBH {
	List<KhachHang> khachHangs = new ArrayList<KhachHang>();
	List<SanPham> sanPhams = new ArrayList<SanPham>();

	public void addCustomer(int maKH, String name) {
		khachHangs.add(new KhachHang(maKH, name, null));
	}

	public KhachHang findCustomer(int idKH) {
		KhachHang result = null;
		for (KhachHang khachHang : khachHangs) {
			if (idKH == khachHang.getMaKH()) {
				result = khachHang;
			}
		}
		return result;

	}

	public SanPham findStuff(String tenSp) {
		SanPham s = null;
		for (SanPham sanPham : sanPhams) {
			if (tenSp == sanPham.getTenSP()) {
				s = sanPham;
			}
		}
		return s;
	}

	public boolean addStuff(int idKH, String tenSp) {
		boolean result = false;
		for (KhachHang khachHang : khachHangs) {
			if (idKH == khachHang.getMaKH()) {
				if (khachHang.getList() == null) {
					List<SanPham> s = new ArrayList<SanPham>();
					s.add(this.findStuff(tenSp));
					khachHang.setList(s);
				} else
					for (SanPham sanPham : khachHang.getList()) {
						if (tenSp != sanPham.getTenSP()) {
							khachHang.getList().add(this.findStuff(tenSp));
						}
					}
			}
		}
		return result;
	}

	public int getTotalPrice(KhachHang k) {
		int total = 0;
		if (k.getList() != null) {
			for (SanPham sanPham : k.getList()) {
				total += sanPham.getGiaSP();
			}
		}
		return total;
	}

	public List<KhachHang> sortByPrice(List<KhachHang> list) {

		Collections.sort(list, new Comparator<KhachHang>() {

			@Override
			public int compare(KhachHang o2, KhachHang o1) {
				return Integer.valueOf(new QLBH().getTotalPrice(o1))
						.compareTo(Integer.valueOf(new QLBH().getTotalPrice(o2)));
			}

		});
		return list;
	}

	public static void main(String[] args) {
		SanPham s1 = new SanPham(1, 1000, "com");
		SanPham s2 = new SanPham(2, 500, "me");
		SanPham s3 = new SanPham(3, 400, "ga");
		QLBH ql = new QLBH();
		ql.sanPhams.add(s1);
		ql.sanPhams.add(s2);
		ql.sanPhams.add(s3);
		ql.addCustomer(1, "huy");
		ql.addCustomer(2, "tuyen");
		ql.addStuff(1, "ga");
		ql.addStuff(2, "com");

		for (KhachHang khachHang : ql.sortByPrice(ql.khachHangs)) {
			System.out.println(khachHang.toString());
		}

	}
}