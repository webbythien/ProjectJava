/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangcopymangjava;

import java.util.Arrays;

/**
 *
 * @author thien
 */
public class MangCopyMangJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // kiểu nguyên thủy
       int[] mang1 = {1,2,3};
       
       //copy mảng
       int[] mang1_a = mang1 ;
       mang1_a[0] =100;
       System.out.println("mang1  "+Arrays.toString(mang1));
        System.out.println("mang1_a  "+Arrays.toString(mang1_a));
        
        //copy mảng 1 cách dùng hàm clone 
        
        int[] mang1_b = mang1.clone();
        mang1_a[0] =50;
        System.out.println("Mang 1 _b "+Arrays.toString(mang1_b));
        System.out.println("Mang 1  "+Arrays.toString(mang1));
        
        
        //C3 copy mảng system.arraycopy
        int[] mang1_c= new int[mang1.length]; 
        System.arraycopy(mang1, 0, mang1_c, 0, mang1.length);
        mang1_c[0]=90;
        System.out.println("Mange 1 c :" + Arrays.toString(mang1_c));
        
        // kiểu đối tượng
        String [] mang_doi_tuong = {"TITV",".vn"};
    }
    
}
