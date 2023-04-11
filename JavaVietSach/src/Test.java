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
     Ngay ngay1 = new Ngay(15,5,2021);   
     Ngay ngay2 = new Ngay(15,9,2030);  
     Ngay ngay3 = new Ngay(15,9,2025); 
     
     TacGia tacGia1 = new TacGia("Hoàng Thiên", ngay1);
     TacGia tacGia2 = new TacGia("Huyền", ngay2);
     TacGia tacGia3 = new TacGia("Ngọc", ngay3);
     
     Sach sach1= new Sach("Mộng mơ", 5000, 2023, tacGia1);
     Sach sach2= new Sach("Thiên Thần", 10000, 2021, tacGia2);
     Sach sach3= new Sach("Không Thật", 15000, 2023, tacGia2);
     
     sach1.inTenSach();
     sach2.inTenSach();
     sach3.inTenSach(); 
     
        System.out.println("So sanh nxb sach 1 va 3 "+sach1.kiemTraCungNamXuatBan(sach3));
        System.out.println("So sanh nxb sach 1 va 2 "+sach1.kiemTraCungNamXuatBan(sach2));
        System.out.println("Gia Ban la "+sach1.getGiaBan());
        System.out.println("Gia sau khi giam: " +sach1.giaSauKhiGiam(20));
        System.out.println("Gia Ban la "+sach2.getGiaBan());
        System.out.println("Gia sau khi giam: " +sach2.giaSauKhiGiam(10));
        System.out.println("Gia Ban la "+sach3.getGiaBan());
        System.out.println("Gia sau khi giam: " +sach3.giaSauKhiGiam(10));
        
    }
}
