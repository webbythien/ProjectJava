/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thien
 */
public interface ProductDao {
    
    public ArrayList<Product> getAllProduct(String file);
    
    public void printAllProduct();
    
    public void searchProduct();
    public int searchProduct(String nameProduct);
    public int searchProductID(String IDProduct);
    
    public void addProduct();
    
    public ArrayList<Product> SearchByName(String product);
    
    public void updateProduct();
    public void deleteProduct();
    
    public void saveToFile(String filename, List list);
    
    public ArrayList<Product> printAllList();
    
    public int CreateLayout(String[] options, String title);
    
    
}
