/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlydanhsachsinhvien;

import java.util.Scanner;

/**
 *
 * @author thien
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();// gọi r khởi tạo
        int luaChon = 0;
        do {

            System.out.println("---MENU---");
            System.out.println("Vui lòng chọn loại chức năng");

            System.out.println(
                    "1.	Thêm sinh viên vào danh sách.\n"
                    + "2.	In danh sách sinh viên ra màn hình.\n"
                    + "3.	Kiểm tra danh sách có rỗng hay không.\n"
                    + "4.	Lấy ra số lượng sinh viên trong danh sách.\n"
                    + "5.	Làm rỗng danh sách sinh viên.\n"
                    + "6.	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.\n"
                    + "7.	Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.\n"
                    + "8.	Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.\n"
                    + "9.	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.\n"
                    + "0.   Thoát khỏi chương trình");
            System.out.println();
            System.out.print("Select: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // chứa ký tự enter để khỏi nhảy

            if (luaChon == 1) {
                System.out.println("Nhập mã sinh viên: ");
                String maSinhVien = sc.nextLine();
                System.out.println("Nhập họ và tên: ");
                String hoVaTen = sc.nextLine();
                System.out.println("Nhập năm sinh: ");
                int namSinh = sc.nextInt();
                System.out.println("Nhập điểm trung bình: ");
                double diemTrungBinh = sc.nextDouble();
                SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);// khởi tạo sinh viên
                dssv.themSinhVien(sv);
            } else if (luaChon == 2) {
// in ra danh sách sinh viên
                dssv.inDanhSachSinhVien();
            } else if (luaChon == 3) {
                // kiểm tra danh sách rỗng hay không 

                System.out.println("Danh sách có rỗng hay không : " + dssv.kiemTraDanhSachRong());
            } else if (luaChon == 4) {
                // lấy số lượng sv trong list
                System.out.println("Số lượng sinh viên là : " + dssv.laySoLuongSinhVien());

            } else if (luaChon == 5) {
                    dssv.lamRong();
            } else if (luaChon == 6) {
// kiểm tra sv có tồn tại trong dánh sachs hay không 
                System.out.println("Nhập mã sinh viên: ");
                String maSinhVien = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien);
                System.out.println("Kiểm tra sinh viên có trong danh sách"+dssv.kiemTraTonTai(sv));
                
            } else if (luaChon == 7) {
// xóa sinh viên
 System.out.println("Nhập mã sinh viên xóa :");
                String maSinhVien = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien);
                System.out.println("Kiểm tra sinh viên có trong danh sách"+dssv.xoaSinhVien(sv));
            } else if (luaChon == 8) {
//tìm sunh viên dựa trên tên được nhập
 System.out.println("Nhập tên sinh viên cần tìm : ");
                String ten = sc.nextLine();
                
                System.out.println("Kiểm tra sinh viên có trong danh sách");
                dssv.timSinhVien(ten);
            } else if (luaChon == 9) {
// xuất danh sách siên viên điểm tuừ thấp cao
            dssv.sapXepSinhVienGiamDanTheoDiem();
            dssv.inDanhSachSinhVien();
            }
        } while (luaChon != 0);
    }
}
