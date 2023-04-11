/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import tools.MyTool;

/**
 *
 * @author thien
 */
public class Dealer implements Comparable<Dealer> {

    public static final char SEPARATOR = ',';
    public static final char PLUS = '|';
    public static final String ID_FORMAT = "[Dd]\\d{3}";
    public static final String PHONE_FORMAT = "\\d{9}|\\d{11}";
    private String ID; //template D000
    private String name; // dealer's name
    private String addr;//dealer's address
    private String phone; //9 or 11  digits
    private boolean continuing;// whether this dealer still cooperates or not

    public Dealer(String ID, String name, String addr, String phone, boolean continuing) {
        this.ID = ID;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.continuing = continuing;
    }

    public Dealer(String line) {//d123,fdgdfg,sdfsfsdf,dsfsfsdf,true 
        String[] parts = line.split("" + this.SEPARATOR);
        ID = parts[0].trim();
        name = parts[1].trim();
        addr = parts[2].trim();
        phone = parts[3].trim();
        continuing = MyTool.parseBool(parts[4]);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isContinuing() {
        return continuing;
    }

    public void setContinuing(boolean continuing) {
        this.continuing = continuing;
    }

    @Override
    public String toString() {
        return ID + SEPARATOR + name + SEPARATOR + addr + SEPARATOR + phone + SEPARATOR + continuing + "\n";
//        /ID + SEPARATOR + name + SEPARATOR + addr + SEPARATOR + phone + SEPARATOR + continuing + "\n";
    }

    public String makeString() {

        return PLUS + "\t" + ID + "\t" + PLUS + "\t" + name + "\t" + PLUS + "\t" + addr + "\t" + PLUS + "\t" + phone + "\t" + PLUS + "\t" + continuing + "\t" + PLUS + "\n";
    }

    @Override
    public int compareTo(Dealer o) {
        return this.getID().compareTo(o.getID());
    }

}
