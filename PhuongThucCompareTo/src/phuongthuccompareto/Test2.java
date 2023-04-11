/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongthuccompareto;

import java.util.Arrays;

/**
 *
 * @author thien
 */
public class Test2 {
    
    //đối tượng chạy String
    public static void main(String[] args) {
         SinhVien sv1 = new SinhVien(100,"Nguyen Hoang Thien","Lop 1", 9);
         SinhVien sv2 = new SinhVien(150,"Nguyen Hoang Thien An","Lop 2", 8);
             SinhVien sv3 = new SinhVien(199,"Nguyen Hoang B","Lop 1", 9);
             SinhVien[] a_sv = new SinhVien[]{sv1,sv2,sv3};
             System.out.println("Ban đầu: "+Arrays.toString(a_sv));
             
             // hàm sắp xếp
             Arrays.sort(a_sv);
    System.out.println("Sau khi sắp xếp: " +Arrays.toString(a_sv));
    //tìm kiếm
    
        System.out.println("Tìm kiếm An "+Arrays.binarySearch(a_sv, sv1));
             System.out.println("Tìm kiếm An "+Arrays.binarySearch(a_sv, sv3));
        
    }
    
}
