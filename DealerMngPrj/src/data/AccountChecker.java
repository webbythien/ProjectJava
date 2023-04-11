/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import tools.MyTool;

/**
 *
 * @author thien
 */
public class AccountChecker extends ArrayList<Account> {

    boolean changed = false;
    private String accFile;
    private static String SEPARATOR = ",";
    private String dataFile = "";

    public AccountChecker() {
        setupAccFile();
    }

    private void setupAccFile() {
        Config cR = new Config();
        accFile = cR.getAccountFile();
    }

    public boolean check(Account acc) {
        List<String> lines = MyTool.readLinesFromFile(accFile);

        for (String line : lines) {
            String[] parts = line.split(this.SEPARATOR);
            if (parts.length < 3) {
                return false;
            }
            if (parts[0].equalsIgnoreCase(acc.getAccName())
                    && parts[1].equals(acc.getPwd())
                    && parts[2].equalsIgnoreCase(acc.getRole())) {
                return true;
            }
        }
        return false;
    }

    private void loadAccountFromFile() {
        List<String> lines = MyTool.readLinesFromFile(dataFile);
        for (String line : lines) {
            Account acc = new Account(line);
            this.add(acc);
        }
    }

    public void initWithFile() {
        Config cR = new Config();
        dataFile = cR.getAccountFile();
        loadAccountFromFile();
    }

    private int searchAccount(String accName) {
        try {
            accName = accName.toUpperCase();
            int N = this.size();
            for (int i = 0; i < N; i++) {
                if (this.get(i).getAccName().equalsIgnoreCase(accName)) {
                    return i;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public void searcAccount() {
        System.out.print("Input acc name: ");
        String accName = MyTool.SC.nextLine();
        int pos = searchAccount(accName);
        if (pos < 0) {
            System.out.println("Not Found!");
        } else {
            System.out.println(accName.toUpperCase() + " dealer in this ist.");
            System.out.println("");
            System.out.println("-----" + this.get(pos) + "-----");
        }
    }

    public void addAccount() {
        String accName;
        String pwd;
        String role;
        int pos;
        do {
            accName = MyTool.readPattern("Acc name of new account", Account.ID_FORMAT);
            accName = accName.toUpperCase();
            pos = searchAccount(accName);
            if (pos >= 0) {
                System.out.println("ID is duplicated");
            }
        } while (pos >= 0);
        pwd = MyTool.readPattern("Password of new account", Account.PWD_FORMAT);
        do {
            role = MyTool.readNonBlank("Role: ");
        } while (!(role.equalsIgnoreCase("ACC-2")) && !(role.equalsIgnoreCase("ACC-1")));

        Account newAcc = new Account(accName, pwd, role);
        this.add(newAcc);
        System.out.println("New account has been added");
        changed = true;
    }

    public void removeAccount() {
        System.out.println("ENTER acc name: ");
        String accName = MyTool.SC.nextLine();
        int pos = searchAccount(accName);
        if (pos < 0) {
            System.out.println("");
            System.out.println("Not Found");
        } else {
            this.remove(this.get(pos));
            System.out.println("");
            System.out.println("Removed");
            changed = true;
        }
    }

    public void updateAccount() {
        System.out.print("Account's employee needs updating: ");
        String ID = MyTool.SC.nextLine();
        int pos = searchAccount(ID);
        if (pos < 0) {
            System.out.println("Dealer " + ID + " not found!");
        } else {
            Account acc = this.get(pos);
            String newName = "";
            newName = MyTool.readPattern("Enter new acc name: ", Account.ID_FORMAT);
            if (!newName.isEmpty()) {
                acc.setAccName(newName);
                changed = true;
            }
            String newPwd = "";
            newPwd = MyTool.readPattern("Enter new password: ", Account.PWD_FORMAT);
            if (!newPwd.isEmpty()) {
                acc.setPwd(newPwd);
                changed = true;
            }
            String newRole = "";
            do {
                newRole = MyTool.readNonBlank("Enter new Role: ");
            } while (!(newRole.equalsIgnoreCase("ACC-2")) && !(newRole.equalsIgnoreCase("ACC-1")));
            if (!newRole.isEmpty()) {
                acc.setRole(newRole);
                changed = true;
            }//
        }
    }

    public void printAllAccount() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (Account acc : this) {
                System.out.println(acc.toString());
            }
        }
    }

    public void writeAccountToFile() {
        if (changed) {
            MyTool.writeFile(dataFile, this);
            changed = false;
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public static void main(String[] args) {
        AccountChecker aChk = new AccountChecker();
        Account acc = new Account("E002", "23456789", "ACC-1");
        boolean valid = aChk.check(acc);
        System.out.println(valid);
    }
}
