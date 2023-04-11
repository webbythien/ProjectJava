/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import data.Account;
import data.AccountChecker;
import data.Config;
import data.DealerList;
import java.util.ArrayList;
import tools.MyTool;

/**
 *
 * @author thien
 */
public class LogIn {

    private Account acc = null;

    public LogIn(Account acc) {
        this.acc = acc;
    }

    public static Account inputAccount() {
        String accName;
        String pwd;
        String role;
        System.out.print("ENTER acc name: ");
        accName =MyTool.SC.nextLine();
        System.out.print("ENTER password: ");
        pwd = MyTool.SC.nextLine();
        System.out.print("ENTER role: ");
        role = MyTool.SC.nextLine();
        Account newAcc = new Account(accName, pwd, role);
        return newAcc;
    }

    public Account getAcc() {
        return acc;
    }

    public static void main(String[] args) {
        int choice = 0;
        Account acc = null;
        boolean cont = false;
        boolean valid = false;
        do {
            AccountChecker accChk = new AccountChecker();
            acc = inputAccount();
            valid = accChk.check(acc);// false //true
            if (valid == true) {
                cont = false;
            }
            if (!valid) {
                cont = MyTool.readBool("Invalid account- Try again?");//Y true không out
            }
            if (!valid && !cont) {
                System.exit(0);
            }
        } while (cont);
        LogIn loginObj = new LogIn(acc);

        if (acc.getRole().equalsIgnoreCase("ACC-1")||acc.getRole().equalsIgnoreCase("ACC-2")) {
            String  add ;
            if(acc.getRole().equalsIgnoreCase("ACC-2")){
                add = "";
            }
        if(cont==false){
            System.out.println("-----Log in was successful!-----");
        }
            String[] options = {"Add new dealer", "Search a dealer",
                "Remove a dealer", "Update a dealer", "Print all dealers",
                "Print continuing dealers", "Print UN-continuing dealers",
                "Write to file"};
            Menu mnu = new Menu(options);
            DealerList dList = new DealerList(loginObj);
            dList.initWithFile();
            do {
                choice = mnu.getChoice("Managing dealers");
                switch (choice) {
                    case 1:
                        dList.addDealer();
                        break;
                    case 2:
                        dList.searchDealer();
                        break;
                    case 3:
                        dList.removeDealer();
                        break;
                    case 4:
                        dList.updateDealer();
                        break;
                    case 5:
                        dList.printAllDealer();
                        break;
                    case 6:
                        dList.printContinuingDealer();
                        break;
                    case 7:
                        dList.printUnContinuingDealer();
                        break;
                    case 8:
                        dList.writeDealerToFile();
                        break;
                    default:
                        if (dList.isChanged()) {
                            boolean res = MyTool.readBool("Data changed. Write to file?");
                            if (res == true) {
                                dList.writeDealerToFile();
                            }
                        }
                }
            } while (choice > 0 && choice <= mnu.size());
            System.out.println("Bye.");
        }

        if (acc.getRole().equalsIgnoreCase("BOSS")) {
            String[] options = {"Add new user", "Search a user",
                "Remove a user", "Update a user", "Print all users",
                "Save"};
            Menu mnu = new Menu(options);
            AccountChecker accChk = new AccountChecker();
            accChk.initWithFile();
            do {
                choice = mnu.getChoice("Managing users");
                switch (choice) {
                    case 1:
                        accChk.addAccount();
                        break;
                    case 2:
                        accChk.searcAccount();
                        break;
                    case 3:
                        accChk.removeAccount();
                        break;
                    case 4:
                        accChk.updateAccount();
                        break;
                    case 5:
                        accChk.printAllAccount();
                        break;
                    case 6:
                        accChk.writeAccountToFile();
                        break;
                    default:
                        if (accChk.isChanged()) {
                            boolean res = MyTool.readBool("Data changed. Write to file?");
                            if (res == true) {
                                accChk.writeAccountToFile();
                            }
                        }
                }
            } while (choice > 0 && choice <= mnu.size());
            System.out.println("Bye.");
        }
        
        
    }
}

