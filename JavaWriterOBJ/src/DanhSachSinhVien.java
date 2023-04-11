/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author thien
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanhSachSinhVien {

    private ArrayList<SinhVien> danhSach;   //đánh vào class muốn sử dụng

    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }

    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>(); //cch khai b ArrayList

    }
// 1 thêm sinh viên vào danh sách

    public void themSinhVien(SinhVien sv) {
        this.danhSach.add(sv);  // gọi đối tượng r chấm hàm
    }
    //2 in danh sách sinh viên 

    public void inDanhSachSinhVien() {
        for (SinhVien sinhVien : danhSach) {// tạo 1 biến tên sinhVien lấy hết phần tử trong danhsach
            System.out.println(sinhVien.toString());
        }
    }

    public boolean kiemTraDanhSachRong() {
        return this.danhSach.isEmpty(); // class.phương thức . hàm

    }
    //số lượng sv trong list

    public int laySoLuongSinhVien() {
        return this.danhSach.size();
    }

    //rỗng ds sinh viên
    public void lamRong() {
        this.danhSach.removeAll(danhSach);
    }

    public boolean kiemTraTonTai(SinhVien sv) {
        return this.danhSach.contains(sv);
    }
    // xóa 1 sinh viên ra khỏi danh sách sinh viên

    public boolean xoaSinhVien(SinhVien sv) {// so sánh sv đã tồn tại nên lấy trong lớp
        return this.danhSach.remove(sv);
    }
    // tìm kiếm sinh viên theo tên

    public void timSinhVien(String ten) {// ng mmowis nhập nên dùng mới
        for (SinhVien sinhVien : danhSach) {
            if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
                System.out.println(sinhVien);

            } 
        }
    }


    public void sapXepSinhVienGiamDanTheoDiem() {
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh()) {
                    return 1;
                } else if (sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
    //10 ghi xuống file
   public void ghiDuLieuXuongFile(File file) throws IOException{
        try {
           
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (SinhVien sinhVien : danhSach) {
                oos.writeObject(sinhVien);
            }
          
           oos.flush();
           oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViDuGhiDoiTuong.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}

    