/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renameandreplacefile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thien
 */

public class RenameAndReplaceFile {
    public static void copyAll(File f1, File f2){
        try {
            Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(RenameAndReplaceFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(f1.isDirectory()){
            File[] mangCon = f1.listFiles();
            for (File file : mangCon) {
                File file_new =new File(f2.getAbsoluteFile()+"/"+file.getName());
                copyAll(file,file_new);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f0 = new File("C:\\Java\\RenameAndReplaceFile\\File_1.txt");
        File f1 = new File("C:\\Java\\RenameAndReplaceFile\\File_2.txt");
        File f2 = new File("C:\\Java\\RenameAndReplaceFile\\File_2xyz.txt");
        /*
        try {
            //1 thay đổi tập tin hoặc thư mục
            //sử dụng fle đê thay đổi tên
            //f0.renameTo(f1);
            
            //sử dụng files để thay đổi tên
            //topath là lấy đường dẫn
            //replace exist là đè lên nêu file có sẵn
            Files.move(f1.toPath(),f2.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(RenameAndReplaceFile.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        //di chuyển file
        /* File f_2new = new File("C:\\Java\\RenameAndReplaceFile\\F0\\File_2xyz.txt");   
        try {
            Files.move(f2.toPath(), f_2new.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(RenameAndReplaceFile.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        //3 copy file
        File f_0 = new File("C:\\Java\\RenameAndReplaceFile\\F0");
        File f_0_copy = new File("C:\\Java\\RenameAndReplaceFile\\F0_copy");
        
       /* try {
            Files.copy(f_0.toPath(), f_0_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(RenameAndReplaceFile.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        RenameAndReplaceFile.copyAll(f_0, f_0_copy);
    }

}
