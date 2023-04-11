/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtiendichuyen;

/**
 *
 * @author thien
 */
public class Test {
    public static void main(String[] args) {
        HangSanXuat h1= new HangSanXuat("Toyota", "Japan");
        HangSanXuat h2= new HangSanXuat("Mercedes", "Germany");
        HangSanXuat h3= new HangSanXuat("VinFast", "VietNam");
        
        PhuongTienDiCHuyen p1 = new MayBay("Dau Diesel", h1);
        PhuongTienDiCHuyen p2 = new XeOto("Xang ", h3);
        PhuongTienDiCHuyen p3= new XeDap(h2);
        
        System.out.println("Lay Hang San Xuat"+p1.layTenHang());
        System.out.println("Toc DO"+ p1.layVanToc());
    }
    
}
