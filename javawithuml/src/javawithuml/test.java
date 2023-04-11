package javawithuml;

public class test {

	public static void main(String[] args) {
		HoaDonCaPhe hd = new HoaDonCaPhe("TrungNguyen", 100, 1.5);
		HoaDonCaPhe hd2 = new HoaDonCaPhe("TrungNguyen", 100, 5.5);
		System.out.println("Tong Tien chua giam gia : "+hd.tinhTongTien());
		System.out.println("Tong Tien chua giam gia : "+hd2.tinhTongTien());
		System.out.println("Kiem Tra khoi luong > 2kg "+hd.kiemTra(2));
		System.out.println("Kiem Tra Gia Tien > 500 "+hd.kiemTraGia());
		System.out.println("Kiem Tra Gia Tien > 500 "+hd2.kiemTraGia());
		System.out.println("Kiem tra giam gia hd: "+hd.giamGia(10));
		System.out.println("Kiem tra giam gia hd2: "+hd2.giamGia(10));
		System.out.println("Total hd1: "+hd.tongTien(10));
		System.out.println("Total hd2: "+hd2.tongTien(10));
	}

}
