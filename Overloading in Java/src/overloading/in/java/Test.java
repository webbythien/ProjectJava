/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overloading.in.java;

/**
 *
 * @author thien
 */
public class Test {
    public static void main(String[] args) {
        MyMath mm= new MyMath();
        System.out.println("tim min double  : "+mm.timMin(3.5, 9.4));
        System.out.println("tim min int "+mm.timMin(9, 5));
        System.out.println("tinh tong 5 va 6 "+mm.tinhTong(05, 06));
        
        double arr[] = new double[] {1,2,3,4,5};
         System.out.println("tinh tong cho mang "+mm.tinhTong(arr));
        }
       
    }
