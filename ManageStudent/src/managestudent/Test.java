/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudent;

/**
 *
 * @author thien
 */
public class Test {
    public static void main(String[] args) {
        Date d1 = new Date(4, 7, 2002);
        Date d2 = new Date(4, 10, 2002);
        Date d3 = new Date(10, 10, 2003);
        Date d4 = new Date(10, 10, 2003);
        
        Class c1 = new Class("SE1747", "Software Engineering ");
        Class c2 = new Class("SE1727", "AI ");
        Class c3 = new Class("SA1006", "Marketing");
        Class c4 = new Class("SB1999", "Design");
        
        Student s1 = new Student("Se162099", "Hoàng Thiên", d1, 10, c1);
        Student s2 = new Student("Se167899", "Ngọc Huyền", d2, 9.8, c2);
        Student s3 = new Student("Se189233", "Anh Minh", d3, 4.5, c3);
        Student s4 = new Student("Se77700", "Ngọc Phú", d4, 5.5, c4);
        
        System.out.println("Major s1 "+s1.printMajor());
        System.out.println("Major s2 "+s2.printMajor());
        System.out.println("Major s3 "+s3.printMajor());
        System.out.println("Major s4 "+s4.printMajor());
        
        System.out.println("Pass or Fail s1 "+s1.passOrFail());
        System.out.println("Pass or Fail s2 "+s2.passOrFail());
        System.out.println("Pass or Fail s3 "+s3.passOrFail());
        System.out.println("Pass or Fail s4 "+s4.passOrFail());
        
        System.out.println("Ngay sinh cua 1 va 3 "+s1.checkDateStu(s3));
        System.out.println("Ngay sinh cua 1 va 2 "+s1.checkDateStu(s2));
        System.out.println("Ngay sinh cua 2 va 4 "+s2.checkDateStu(s4));
        System.out.println("Ngay sinh cua 3 va 4 "+s3.checkDateStu(s4));
    }
    
}
