/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codejavataixiu;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class TaiXiu {

    public static void main(String[] args) {
        double taiKhoanNguoiChoi = 5000;
        double datCuoc = 0;
        Scanner sc = new Scanner(System.in);
        int luachon = 1;
       
        do {
            System.out.println("----Mời bạn lựa chọn-----");
            System.out.println("Chọn (1) để tiếp tục chơi ");
            System.out.println("Chọn phím bất kì để thoát ");
            luachon = sc.nextInt();
            if (luachon == 1) {
                System.out.println("**** Bắt đầu****");
                System.out.println("**** Tài khoản của bạn là : ****" + taiKhoanNguoiChoi + "bạn muốn cược bao nhiêu: ");
                do {
                    System.out.println("Số tiền cược > 0 : ");

                    datCuoc = sc.nextDouble();

                } while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);
            }
            int luaChonTaiXiu = 0;
            do {
                System.out.println("Chọn 1 = Tài --- Chọn 2 = Xỉu");
                luaChonTaiXiu =sc.nextInt();
            } while (luaChonTaiXiu != 1&& luaChonTaiXiu != 2);

            //Tung xúc xắc
            Random xucXac1 = new Random();
            Random xucXac2 = new Random();

            Random xucXac3 = new Random();
            
           int giaTri1= xucXac1.nextInt(5)+1;// +1 vì hàm random chạy từ 0
            int giaTri2= xucXac2.nextInt(5)+1;
            int giaTri3= xucXac3.nextInt(5)+1;
            int tong = giaTri1 + giaTri2 + giaTri3;
                        System.out.println("Kết quả: "+ giaTri1 +"+" + giaTri2 + "+" + giaTri3);

            System.out.println("Kết quả: "+tong);
        } while (luachon == 1);

    }
}
//