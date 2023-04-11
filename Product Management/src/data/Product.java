/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author thien
 */
           public class Product {
    public static final String ID_FORMAT = "[Pp]\\d{0,}";
    public static final String PRODUCT_FORMAT = "\\w{5,}";
    public static final String QUANTITY_FORMAT = "^([1-9][0-9]{0,2}|1000)$";
    private String id;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String status;
    public Product(String id,String productName, double unitPrice, int quantity, String status) {
        this.id = id;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+","+productName + "," + unitPrice + "," + quantity + "," + status + "\n";
    }

    public void makeTable() {
        System.out.printf("|%-9s|%-21s|%-20s|%-15s|%-14s|\n", id,productName, unitPrice, quantity, status);
    }

}
