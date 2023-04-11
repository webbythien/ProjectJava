package java8;

import java.util.Scanner;

public class trycatchfinally {

	public static void main(String[] args) {
		int n=0;
		 Scanner sc = new Scanner(System.in);
		 try {
			 System.out.println("Nhap vao 1 so nguyen");
			 n=sc.nextInt();
			 
		} catch (Exception e) {
			System.out.println("Lỗi chương trình");
		}
		 System.out.println("Giá trị a= "+n);
		 System.out.println("chương trình kết thúc");
	}

}
