/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Tools.MyTool;
import java.io.IOException;

/**
 *
 * @author thien
 */
public class ProductDaoDemo {

    public static void main(String[] args) throws IOException, Exception {
        String[] options = {"Print", "Create a Product",
            "Check to exist Product", "Search Product information by name",
            "Update Product", "Save to file",
            "Print all lists from file"};
        final String fileEmp = "src\\ProductData\\product.dat";//path
        int choice = 0;
        boolean valid = true;
        ProductDaoImpl pl = new ProductDaoImpl(fileEmp);

        do {
            System.out.println("\nCompany Employee Management Program");
            choice = pl.CreateLayout(options, "Manage Product"); // show Menu options
            switch (choice) {
                case 1:
                    pl.printAllProduct();
                    break;
                case 2:
                    pl.addProduct();
                    break;
                case 3:
                    pl.searchProduct();
                    break;
                case 4:
                    String name = MyTool.readNonBlank("Enter name to find: ");
                    MyTool.printAllProduct(pl.SearchByName(name));
                    break;
                case 5:
                    int choiceTemp;
                    String[] optionTemp = {"Update product information",
                        "Delet Product information"};
                    do {

                        choiceTemp = pl.CreateLayout(optionTemp, "Update Product");
                        switch (choiceTemp) {
                            case 1:// chỉ update 1 cái
                                pl.updateProduct();
                                break;
                            case 2:
                                pl.deleteProduct();
                                break;
                            default:
                                break;
                        }

                    } while (choiceTemp > 0 && choiceTemp <= optionTemp.length);
                    break;

                case 6:
                    pl.saveToFile(fileEmp, pl.getProList());
                    break;
                case 7:
                    MyTool.printAllProduct(pl.printAllList());
                    break;
                default:
                    if (pl.isChanged()) {
                        boolean res = MyTool.readBool("Data changed. Write to file?");
                        if (res == true) {
                            pl.saveToFile(fileEmp, pl.getProList());
                        }
                    }
                    break;
            }

        } while (choice > 0 && choice <= options.length);
    }
}
