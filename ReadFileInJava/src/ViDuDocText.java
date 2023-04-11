
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thien
 */
public class ViDuDocText {

    public static void main(String[] args) {
        /*cách 1
        File f = new File("C:\\Java\\ReadFileInJava\\file.txt");
        
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(),StandardCharsets.UTF_8);
        String line = null;
        while(true){
            line = br.readLine();// đọc từng dòng
            if(line==null){
                break;
            }else{
                System.out.println(line);
            }
        }
        } catch (IOException ex) {
            Logger.getLogger(ViDuDocText.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        // cách 2
        File f2 = new File("C:\\Java\\ReadFileInJava\\file.txt");
        try {
            List<String> allText = Files.readAllLines(f2.toPath(),StandardCharsets.UTF_8);
            for (String line : allText) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
