/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_abstract;

/**
 *
 * @author thien
 */
public class Test {
    public static void main(String[] args) {
        ToaDO td1 = new ToaDO(5, 5);
        ToaDO td2 = new ToaDO(7, 9);
        ToaDO td3 = new ToaDO(12, 1);
        
       // Hinh h = new Hinh(1); lỗi 
       Hinh h1 = new Diem(td1);
       Hinh h2=new HinhTron(10, td2);
       Hinh h3 = new HinhChuNhat(5, 10, td3);
       
        System.out.println("DT1 :"+     h1.tinhDienTich());
        System.out.println("DT2 :"+     h2.tinhDienTich());
        System.out.println("DT3 :"+     h3.tinhDienTich());
       
    }
}
