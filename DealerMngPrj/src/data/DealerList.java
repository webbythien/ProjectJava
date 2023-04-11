/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import mng.LogIn;
import tools.MyTool;

/**
 *
 * @author thien
 */
public class DealerList extends ArrayList<Dealer> {

    LogIn loginObj = null;//E002,23456789,ACC-1
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile = "";
    boolean changed = false;

    public DealerList(LogIn loginObj) {//\
        super();
        this.loginObj = loginObj;
    }

    private void loadDealerFromFile() {
        List<String> lines = MyTool.readLinesFromFile(dataFile);
        for (String line : lines) {
            Dealer dl = new Dealer(line);
            this.add(dl);// = ArrayList<> mang = new arraylist<>();
        }
    }

    public void initWithFile() {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }

    public DealerList getContinuingList() {
        ArrayList<Dealer> result = new DealerList(loginObj);//D001,Adam,432 street A,123456789,false
        for (Dealer d : this) {
            if (d.isContinuing() == true) {
                result.add(d);
            }
        }
        return (DealerList) result;
    }

    public DealerList getUnContinuingList() {
        ArrayList<Dealer> result = new DealerList(loginObj);//D001,Adam,432 street A,123456789,false
        for (Dealer d : this) {
            if (d.isContinuing() == false) {
                result.add(d);
            }
        }
        return (DealerList) result;
    }

    private int searchDealer(String ID) {
        try {
            ID = ID.toUpperCase();
            int N = this.size();
            for (int i = 0; i < N; i++) {
                if (this.get(i).getID().equalsIgnoreCase(ID)) {
                    return i;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public void searchDealer() {
        System.out.print("Input ID: ");
        String id = MyTool.SC.nextLine();
        int pos = searchDealer(id);
        if (pos < 0) {
            System.out.println("Not Found!");
        } else {
            System.out.println(id.toUpperCase() + " dealer in this ist.");
            System.out.println(this.get(pos));
        }
    }

    public void addDealer() {
        String ID;
        String name;
        String addr;
        String phone;
        boolean continuing;
        int pos;
        do {
            ID = MyTool.readPattern("ID of new dealer", Dealer.ID_FORMAT);
            ID = ID.toUpperCase();
            pos = searchDealer(ID);
            if (pos >= 0) {
                System.out.println("ID is duplicated");
            }
        } while (pos >= 0);
        name = MyTool.readNonBlank("Name of new dealer: ").toUpperCase();
        addr = MyTool.readNonBlank("Address of new dealer: ");
        phone = MyTool.readPattern("Phone number: ", Dealer.PHONE_FORMAT);
        continuing = true;
        Dealer d = new Dealer(ID, name, addr, phone, continuing);
        this.add(d);
        System.out.println("New dealer has been added");
        changed = true;
    }

    public void removeDealer() {
        boolean continuing;
        printAllDealer();
        System.out.println("");
        System.out.print("ENTER ID to remove: ");
        String ID = MyTool.SC.nextLine();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Not Found");
        } else {
            this.remove(this.get(pos));
            System.out.println("-----Removed-----");
            changed = true;
            continuing = false;
        }
    }

    public void updateDealer() {
        printAllDealer();
        System.out.println("");
        System.out.print("Dealer's ID needs updating: ");
        String ID = MyTool.SC.nextLine();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Dealer " + ID + " not found!");
        } else {
            Dealer d = this.get(pos);
            String newName = "";
            System.out.print("new name, ENTER for omitting: ");
            newName = MyTool.SC.nextLine().trim().toUpperCase();
            if (!newName.isEmpty()) {
                d.setName(newName);
                changed = true;
            }
            String newAddr = "";
            System.out.print("new address, ENTER for omitting: ");
            newAddr = MyTool.SC.nextLine().trim().toUpperCase();
            if (!newAddr.isEmpty()) {
                d.setAddr(newAddr);
                changed = true;
            }
            String newPhone = "";
            System.out.print("new phone, ENTER for omitting: ");
            newPhone = MyTool.SC.nextLine().trim().toUpperCase();
            if (!newPhone.isEmpty()) {
                d.setPhone(newPhone);
                changed = true;
            }//
        }
    }

    public void printAllDealer() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {                    
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("|        ID     |       Name    |         Address       |      Phone Number     |   Continuing   |");
            System.out.println("-------------------------------------------------------------------------------------------------");
            for (Dealer d : this) {
                System.out.println(d.makeString());
                System.out.println("-------------------------------------------------------------------------------------------------");
            }

        }
    }

    public void printContinuingDealer() {
        this.getContinuingList().printAllDealer();
    }

    public void printUnContinuingDealer() {
        this.getUnContinuingList().printAllDealer();
    }

    public void writeDealerToFile() {
        if (changed) {
            MyTool.writeFile(dataFile, this);
            changed = false;
        }
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }

}
