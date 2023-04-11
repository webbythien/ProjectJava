
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thien
 */
public class ViDuGhiDoiTuong {
    public static void main(String[] args) throws IOException {
       
        try {
            File file = new File("C:\\Java\\JavaWriterOBJ\\file.data");
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
           SinhVien sv = new SinhVien("001","TITV", 2002, 10);
           
           oos.writeObject(sv);
           oos.flush();
           oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViDuGhiDoiTuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
