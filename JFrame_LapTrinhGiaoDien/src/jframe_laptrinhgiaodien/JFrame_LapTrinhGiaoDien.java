/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe_laptrinhgiaodien;

import javax.swing.JFrame;

/**
 *
 * @author thien
 */
public class JFrame_LapTrinhGiaoDien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Vi Du Jframe");//gắn tênn
        jf.setSize(600, 400);// tạo kích cỡ cửa sổ 

//        while(true){
//            System.out.println("Chương trình đang chạy!");
//        }
        jf.setLocation(300, 300);// gán vị trí hiển thị;
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// đóng khi nhân x
        jf.setVisible(true);// tạo ra cửa sổ--- để dưới cùng
    }
}
