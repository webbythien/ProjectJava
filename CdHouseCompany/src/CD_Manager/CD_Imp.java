/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CD_Manager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thien
 */
public interface CD_Imp {
     public ArrayList<CD> getAllProduct(String file);
    public ArrayList<CD> SearchByCdTitle(String product);
     public ArrayList<CD> SearchByCdTitleCheck(String cd);
     
    public void printAllCD();
    

    public int searchCdID(String cdID);
    
    public boolean validTP(String title,int year);
    
    public void addProduct();
    
    
    public void updateCD();
    public void deleteCD();
    
    public void saveToFile(String filename, List list);
    
    public ArrayList<CD> printAllListFristName();
    
    public int CreateLayout(String[] options, String title);
}
