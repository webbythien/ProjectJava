/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydate;

/**
 *
 * @author thien
 */
public class test {
    public static void main(String[] args) {
     MyDate md = new MyDate(31,1,2021) ;
        System.out.println("My Day is : "+md.getDay());
        md.setDay(30);
        System.out.println("My Day is : "+md.getDay());
        md.setMonth(13);
 
         System.out.println("My Month is : "+md.getMonth());
        
         md.setMonth(5);
         System.out.println("My Month is : "+md.getMonth());
          System.out.println("My Year is : "+md.getYear());
          System.out.println();
    }
}
