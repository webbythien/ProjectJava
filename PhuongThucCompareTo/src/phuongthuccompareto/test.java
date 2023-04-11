/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongthuccompareto;

/**
 *
 * @author thien
 */
public class test {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(100,"Nguyen Hoang Thien","Lop 1", 9);
                SinhVien sv2 = new SinhVien(150,"Nguyen Hoang Thien An","Lop 2", 8);
        System.out.println(sv1.compareTo(sv2));
    }
}
