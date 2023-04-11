/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CD_Manager;

/**
 *
 * @author thien
 */
public class CD{
    public static final String CD_FORMAT = "^\\d+$";
    private String cdColName;
    private String cdType;
    private String cdTitle;
    private double cdUPrice;
    private int cdID;
    private int cdPubYear;

    public CD( int cdID, String cdTitle ,String cdColName, String cdType,int cdPubYear, double cdUPrice) {
        this.cdID = cdID;
        this.cdTitle = cdTitle;
        this.cdColName = cdColName;
        this.cdType = cdType;
        this.cdUPrice = cdUPrice;
        this.cdPubYear = cdPubYear;
    }
   

    public String getCdColName() {
        return cdColName;
    }

    public void setCdColName(String cdColName) {
        this.cdColName = cdColName;
    }

    public String getCdType() {
        return cdType;
    }

    public void setCdType(String cdType) {
        this.cdType = cdType;
    }

    public String getCdTitle() {
        return cdTitle;
    }

    public void setCdTitle(String cdTitle) {
        this.cdTitle = cdTitle;
    }

    public double getCdUPrice() {
        return cdUPrice;
    }

    public void setCdUPrice(double cdUPrice) {
        this.cdUPrice = cdUPrice;
    }

    public int getCdID() {
        return cdID;
    }

    public void setCdID(int cdID) {
        this.cdID = cdID;
    }

    public int getCdPubYear() {
        return cdPubYear;
    }

    public void setCdPubYear(int cdPubYear) {
        this.cdPubYear = cdPubYear;
    }

    @Override
    public String toString() {
        return cdID+ "," +  cdTitle + "," + cdColName + "," + cdType + "," +   cdPubYear +  "," + cdUPrice +  '\n';
    }
    
    
    public void makeTable() {       //int cdID, String cdTitle ,String cdColName, String cdType,int cdPubYear, double cdUPrice
                                    //
        System.out.printf("|%-9s|%-21s|%-20s|%-15s|%-14s|%-14s|\n",cdID,cdTitle,cdColName,cdType,cdPubYear,cdUPrice);//
    }
}
