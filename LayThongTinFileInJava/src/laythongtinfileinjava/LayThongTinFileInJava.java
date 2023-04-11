/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laythongtinfileinjava;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class LayThongTinFileInJava {

    File file;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        System.out.println("Nhập tên file ");
        String tenFile = sc.nextLine();
        LayThongTinFileInJava vdf = new LayThongTinFileInJava(tenFile);
        do {
            System.out.println("----MENU----");

            System.out.println("1.Kiểm tra file có thể thực thi");
            System.out.println("2.Kiểm tra file có thể đọc");
            System.out.println("3.Kiểm tra file có thể ghi");
            System.out.println("4.In đường dẫn");
            System.out.println("5.Kiểm tra file là thư mục");
            System.out.println("6.Kiểm tra file là tập tin");
            System.out.println("7.Kiểm tra file là thư mục hoặc tập tin");
            System.out.println("8.In ra cây thư mục");
            System.out.println("0.Thoát chương trình");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    System.out.println(vdf.kiemTraThucThi());
                    break;
                case 2:
                    System.out.println(vdf.kiemTraDoc());
                    break;
                case 3:
                    System.out.println(vdf.kiemTraGhi());
                    break;
                case 4:
                    vdf.inDuongDan();
                    break;
                case 5:
                    vdf.inTen();
                    break;
                case 6:
                    vdf.kiemTraLaThuMucHoacTapTin();
                    break;
                case 7:
                    vdf.inDanhSachCacFileCon();
                    break;
                case 8:
                    vdf.inCayThuMuc();
                    break;
                default:
                    break;
            }
        } while (luaChon != 0);

    }

    public LayThongTinFileInJava(String tenFile) {
        this.file = new File(tenFile);
    }

    public boolean kiemTraThucThi() {
        //kiểm tra file có thể thực thi
        return this.file.canExecute();
    }

    public boolean kiemTraDoc() {
        //kiểm tra file có thể thực thi
        return this.file.canRead();
    }

    public boolean kiemTraGhi() {
        //kiểm tra file có thể thực thi
        return this.file.canWrite();
    }

    public void inDuongDan() {
        System.out.println(this.file.getAbsolutePath());
    }

    public void inTen() {
        System.out.println(this.file.getName());
    }

    public void kiemTraLaThuMucHoacTapTin() {
        if (this.file.isDirectory()) {
            System.out.println("Đây là thư mục");
        } else if (this.file.isFile()) {
            System.out.println("Đây là tập tin");

        }

    }

    public void inDanhSachCacFileCon() {
        if (this.file.isDirectory()) {
            System.out.println("Các tập tin con/ thư mục con là: ");
            File[] mangCon = this.file.listFiles();
            for (File file1 : mangCon) {
                System.out.println(file1.getAbsolutePath());
            }
        } else if (this.file.isFile()) {
            System.out.println("Đây là tập tin, không có dữ liệu bên trong");

        }

    }

    public void inCayThuMuc() {
        this.inChiTietCayThuMuc(this.file, 1);
    }

    public void inChiTietCayThuMuc(File f, int bac) {
       
        for (int i = 0; i < bac; i++) {
            System.out.print("\t");

        }
        System.out.print("|_");
        System.out.println(f.getName());
        if (f.canRead() && f.isDirectory()) {
            File[] mangCon = f.listFiles();
            for (File file1 : mangCon) {
                inChiTietCayThuMuc(file1, bac + 1);
            }
        }
    }

}
