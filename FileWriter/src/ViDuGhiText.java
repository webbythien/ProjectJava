
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thien
 */
public class ViDuGhiText {

    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("C:\\Java\\FileWriter\\file.txt", "UTF-8");
            pw.println("Xin chào, mình là TITV ");
            pw.print("Dữ liệu: ");
            pw.print(3.14);
            pw.print(' ');
            pw.print("là số pi");
            pw.println();
            Student st = new Student(100, "Nguyen Hoang Thien");
            pw.println(st);

            pw.println();
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
