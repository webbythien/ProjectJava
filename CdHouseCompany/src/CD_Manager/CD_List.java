/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CD_Manager;

import Tools.MyTool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author thien
 */
public class CD_List implements CD_Imp {

    private boolean changed;
    ArrayList<CD> cdList = new ArrayList<>();
    private int CDcounter = cdList.size();

    public int getCDcounter() {
        return CDcounter;
    }

    public void setCDcounter(int CDcounter) {
        this.CDcounter = CDcounter;
    }

    public ArrayList<CD> getCdList() {
        return cdList;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void setCdList(ArrayList<CD> cdList) {
        this.cdList = cdList;
    }

    public CD_List(String filename) {
        getAllProduct(filename);
    }

    @Override
    public ArrayList<CD> getAllProduct(String filename) {
        String thisLine;
        CD cd = null;
        try {
            BufferedReader myInput = null;
            File f = new File(filename);
            String fullPath = f.getAbsolutePath();
            FileReader file = new FileReader(fullPath);
            myInput = new BufferedReader(file);
            while ((thisLine = myInput.readLine()) != null) {
                thisLine = thisLine.toUpperCase();
                if (!thisLine.isEmpty()) {
                    String[] split = thisLine.split(",");
                    if (cdList == null) {
                        cdList = new ArrayList<>();
                    }
                    cd = new CD(Integer.parseInt(split[0]), split[1], split[2], split[3], Integer.parseInt(split[4]), Double.parseDouble(split[5]));
                    cdList.add(cd);
                }
            }
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return cdList;
        }
    }

    @Override
    public ArrayList<CD> SearchByCdTitle(String cd) {
        if (cdList == null) {
            return null;
        }
        ArrayList<CD> byTitle = new ArrayList<>();
        try {
            for (CD p1 : cdList) {
                if (p1.getCdTitle().toUpperCase().equals(cd.toUpperCase())) {
                    byTitle.add(p1);
                }

            }
            if (byTitle.isEmpty()) {
                System.out.println("Have no CD's title is : " + cd);
            } else {
                System.out.println("List " + cd + " is: ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return byTitle;
    }

    public ArrayList<CD> SearchByCdTitleCheck(String cd) {
        if (cdList == null) {
            return null;
        }
        ArrayList<CD> byTitle = new ArrayList<>();
        try {
            for (CD p1 : cdList) {
                if (p1.getCdTitle().toUpperCase().equals(cd.toUpperCase())) {
                    byTitle.add(p1);
                }

            }
            if (byTitle.isEmpty()) {
                return null;
            } else {
                return byTitle;
            }
        } catch (Exception e) {
            System.out.println();
        }
        return byTitle;
    }

    @Override
    public void printAllCD() {
        MyTool.printAllCD(cdList);
    }

    @Override
    public boolean validTP(String titleName, int year) {
        try{
            ArrayList<CD> tiList = (ArrayList<CD>) SearchByCdTitleCheck(titleName).clone();
        if (tiList.isEmpty()) {
            return true;
        } else {
            for (CD cd : tiList) {
                if (cd.getCdPubYear() == year) {
                    return false;
                }
            }
        }
        return true;
        }catch(Exception e){
            System.out.println();
        }finally{
            return true;
        }
        
    }

    @Override
    public int searchCdID(String idCD) {
        try {
            int N = cdList.size();
            for (int i = 0; i < N; i++) {
                if (cdList.get(i).getCdID() == Integer.parseInt(idCD)) {
                    return i;
                }
            }

        } catch (Exception e) {
            System.out.println("Does not exist " + idCD + " in product list.");
        }
        return -1;
    }

    @Override
    public void addProduct() {
        String colName;
        String type;
        String title;
        String price;
        int iD;
        String pubYear;
        boolean check = true;
        String status;
        boolean checkStatus;
        if (CDcounter >= 700) {
            System.out.println("Free space not available");
            System.out.println("Add new cd is fail");
        } else {
            do {
                colName = MyTool.readNonBlank("Enter CD's collection: ").toUpperCase();
            } while (!colName.equalsIgnoreCase("game")
                    && !colName.equalsIgnoreCase("movie")
                    && !colName.equalsIgnoreCase("music"));

            do {
                type = MyTool.readNonBlank("Enter CD's type: ").toUpperCase();
            } while (!type.equalsIgnoreCase("audio")
                    && !type.equalsIgnoreCase("video"));

            do {
                price = MyTool.readNonBlank("Enter CD's price: ");
                if (!MyTool.isDouble(price) || (Double.parseDouble(price) < 0)) {
                    System.out.println("-----Enter double number only-----");
                } else if (Double.parseDouble(price) > 0) {
                    break;
                }
            } while (true);

            iD = CDcounter + 1;
            do {
                title = MyTool.readNonBlank("Enter CD's title: ").toUpperCase();
                pubYear = MyTool.readPattern("Enter CD's year: ", CD.CD_FORMAT);
                if (validTP(title, Integer.parseInt(pubYear))) {// đúng ko trùng cho thoát ra
                    check = false;
                } else {//sai có trùng cho lặp lại
                    check = true;
                }
            } while (check);
            CD cd_new = new CD(iD, title, colName, type, Integer.parseInt(pubYear), Double.parseDouble(price));
            cdList.add(cd_new);
            setChanged(true);
            System.out.println("Add new cd successfully");

        }
    }

    @Override
    public void updateCD() {
        printAllCD();
        System.out.println("");
        String id;
        id = MyTool.readNonBlank("Enter product's id: ");
        int pos = searchCdID(id);
        if (pos < 0) {
            System.out.println(id + " does not exist");
        } else {
            CD cd = cdList.get(pos);
            String colName;
            String type;
            String title;
            String price;
            int iD;
            String pubYear;
            int CDcounter = cdList.size();
            boolean check = true;

            do {
                System.out.print("new collection, ENTER for omitting: ");
                colName = MyTool.SC.nextLine().trim().toUpperCase();
                if (!colName.isEmpty()) {
                    cd.setCdColName(colName);
                    setChanged(changed);
                } else {
                    break;
                }

            } while (!colName.equalsIgnoreCase("game")
                    && !colName.equalsIgnoreCase("movie")
                    && !colName.equalsIgnoreCase("music"));

            do {
                System.out.print("new TYPE, ENTER for omitting: ");
                type = MyTool.SC.nextLine().trim().toUpperCase();
                if (!type.isEmpty()) {
                    cd.setCdType(type);

                } else {
                    break;
                }
            } while (!type.equalsIgnoreCase("audio")
                    && !type.equalsIgnoreCase("video"));

            do {

                System.out.print("new PRICE, ENTER for omitting: ");
                price = MyTool.SC.nextLine().trim();
                if (!price.isEmpty()) {
                    if (!MyTool.isDouble(price) || (Double.parseDouble(price) < 0)) {
                        System.out.println("-----Enter double number only-----");
                    } else if (Double.parseDouble(price) > 0) {
                        break;
                    }
                    cd.setCdType(type);
                    setChanged(changed);
                } else {
                    break;
                }

            } while (true);

            do {
                System.out.print("new TITLE, ENTER for omitting: ");
                title = MyTool.SC.nextLine().trim().toUpperCase();

                System.out.print("new Public Year, ENTER for omitting: ");
                pubYear = MyTool.SC.nextLine().trim();

                if (!title.isEmpty() && !pubYear.isEmpty()) {
                    if (validTP(title, Integer.parseInt(pubYear))) {// đúng ko trùng cho thoát ra
                        check = false;
                        cd.setCdTitle(title);
                        cd.setCdPubYear(Integer.parseInt(pubYear));
                        setChanged(true);
                    } else {//sai có trùng cho lặp lại
                        check = true;
                    }
                } else {
                    break;
                }
            } while (check);
        }

    }

    @Override
    public void deleteCD() {
        int idTemp;
        printAllCD();
        System.out.println("");
        System.out.print("ENTER product's ID to remove: ");
        String ID = MyTool.SC.nextLine();// tài id 2
        int pos = searchCdID(ID);
        if (pos < 0) {//1
            System.out.println(ID + " does not exist");
        } else {
            cdList.remove(cdList.get(pos));//16
            System.out.println("-----Removed-----");
            int n = cdList.size();
            idTemp = Integer.parseInt(ID);
            for (int i = pos; i < n; i++) {// 
                cdList.get(i).setCdID(idTemp);//2  1
                idTemp++;
            }
            changed = true;
            System.out.println();
        }
    }

    @Override
    public void saveToFile(String filename, List list) {
        if (changed == true) {
            try {
                if (list.isEmpty()) {
                    System.out.println("EMPTY LIST.");
                } else {
                    File f = new File(filename);
                    if (f.exists()) {
                        f.delete();
                    }
                    RandomAccessFile rf = new RandomAccessFile(f, "rw");
                    for (Object object : list) {
                        rf.writeBytes(object.toString() + "\r\n");
                    }
                    rf.close();

                    System.out.println("-----Successfully wrote to the file-----");
                }
                changed = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<CD> printAllListFristName() {
        if (cdList == null) {
            return null;
        }
        ArrayList<CD> sortList = null;
        sortList = (ArrayList<CD>) cdList.clone();
        Comparator com = new Comparator<CD>() {
            @Override
            public int compare(CD c1, CD c2) {
                String[] split1 = c1.getCdTitle().split(" ");
                String[] split2 = c2.getCdTitle().split(" ");

                if (split1[0].equalsIgnoreCase(split2[0])) {
                    return (int) (c2.getCdPubYear() - c1.getCdPubYear());
                } else {
                    return (int) (split1[0].compareToIgnoreCase(split2[0]));
                }

            }

        };
        sortList.sort(com);
        return sortList;
    }

    @Override
    public int CreateLayout(String[] options, String title) {
        ArrayList<String> opList = new ArrayList<>();
        String s = "0";
        String[] optionTemp = {"Update CD information",
            "Delet CD information"};
        for (String item : options) {
            opList.add(item);
        }

        do {
            if (MyTool.isInteger(s) == false) {
                System.out.println("");
                System.out.println("------Please, ENTER only numuber------");
                System.out.println("");
            }
            
            int sizeArr = opList.size();
            System.out.println(title);
            for (int i = 0; i < sizeArr; i++) {
                System.out.println((i + 1) + "-" + opList.get(i));
                if (opList.get(i).equalsIgnoreCase("Update CD")) {
                    for (int k = 0; k < optionTemp.length; k++) {
                        System.out.println("  " + (i + 1) + "." + (k + 1) + "-" + optionTemp[k]);
                    }
                }
            }
            
            System.out.println("Other for quit");
            System.out.print("Choose[1.." + sizeArr + "]: ");
            s = MyTool.SC.nextLine();
        } while (MyTool.isInteger(s) == false);
        return Integer.parseInt(s);
    }
}
