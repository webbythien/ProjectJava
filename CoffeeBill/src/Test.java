/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thien
 */
public class Test {
    public static void main(String[] args) {
        CoffeeBill hd = new CoffeeBill("Cà Phê G7 ", 100, 1.5);
        CoffeeBill hd1 = new CoffeeBill("Cà Phê G7 ", 100, 5.5);
        System.out.println("Tong tien : "+hd.tinhTongTien());
        System.out.println("Kiem Tra Ca Phe(Lon Hoac Nho) : "+hd.kiemTraKhoiLuongLon(2));
        System.out.println("Kiem Tra Ca Phe(Lon Hoac Nho) : "+hd1.kiemTraKhoiLuongLon(1));
        System.out.println("Kiem Tra Gia Tien Co Lon Hon 500K : "+hd.kiemTraTienLonHon500());
        System.out.println("Kiem Tra Giam Gia : "+hd1.giamGia(10));
        System.out.println("Total: "+hd1.giaSauGiam(10));
    }
}
