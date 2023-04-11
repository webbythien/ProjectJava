/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CD_Manager;

import Tools.MyTool;
import java.io.IOException;

/**
 *
 * @author thien
 */
public class CD_DEMO {
    public static void main(String[] args) throws IOException, Exception {
        String[] options = {"Add CD to the catalog", "Search CD by CD title",
            "Display the catalog", "Update CD",
            "Save CD to file.", "Print list CDs from file.",
            };
        final String fileEmp = "src\\CD_data\\CD_data.txt";//path
        int choice = 0;
        boolean valid = true;
        CD_List pl = new CD_List(fileEmp);

        do {
            System.out.println("\nCompany Employee Management Program");
            choice = pl.CreateLayout(options, "Manage Product"); // show Menu options
            switch (choice) {
                case 1:
                    pl.addProduct();
                    break;
                case 2:
                    String titleFind = MyTool.readNonBlank("Enter title to search: ").toUpperCase();
                    MyTool.printAllCD(pl.SearchByCdTitle(titleFind));
                    break;
                case 3:
                    pl.printAllCD();
                    break;
                case 5:
                    pl.saveToFile(fileEmp, pl.getCdList());
                    break;
                case 4:
                    int choiceTemp;
                    String[] optionTemp = {"Update CD",
                        "Delet CD"};
                    do {

                        choiceTemp = pl.CreateLayout(optionTemp, "Update CD");
                        switch (choiceTemp) {
                            case 1:// chỉ update 1 cái
                                pl.updateCD();
                                break;
                            case 2:
                                pl.deleteCD();
                                break;
                            default:
                                break;
                        }

                    } while (choiceTemp > 0 && choiceTemp <= optionTemp.length);
                    break;

                case 6:
                   MyTool.printAllCD(pl.printAllListFristName());
                    break;
                default:
                    if (pl.isChanged()) {
                        boolean res = MyTool.readBool("Data changed. Write to file?");
                        if (res == true) {
                            pl.saveToFile(fileEmp, pl.getCdList());
                        }
                    }
                    break;
            }

        } while (choice > 0 && choice <= options.length);
    }
}
