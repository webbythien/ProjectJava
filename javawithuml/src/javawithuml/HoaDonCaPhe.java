package javawithuml;

public class HoaDonCaPhe {

	private String tenLoaiCaPhe ;
	private double giaTien1kg ;
	private double khoiLuong;
	
	public HoaDonCaPhe(String ten, double gia, double kl ) {
		this.tenLoaiCaPhe= ten;
		this.giaTien1kg = gia;
		this.khoiLuong=kl;
	}
	public double tinhTongTien() {
		return this.giaTien1kg * this.khoiLuong;
	}
	public boolean kiemTra(double kl) {
/*	if(this.khoiLuong>kl) {
		return true ;
	}else {
		return false ;
	}*/
		return this.khoiLuong > kl;
	}
	
	public boolean kiemTraGia() {
		return this.tinhTongTien()>500 ;
	}
	public double giamGia(double x) {
		if(this.tinhTongTien()>500) {
		return (x/100)*this.tinhTongTien(); 
		}else {
			return 0;
		}
	}
	public double tongTien(double x) {
		return this.tinhTongTien()- this.giamGia(x);
	}
}
