/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlimaytinh;

/**
 *
 * @author thien
 */
public class MayTinh {
   private HangSanXuat tenHang;
   private Date ngaySanXuat;
   private double price;
   private int baoHanh;

    public MayTinh(HangSanXuat tenHang, Date ngaySanXuat, double price, int baoHanh) {
        this.tenHang = tenHang;
        this.ngaySanXuat = ngaySanXuat;
        this.price = price;
        this.baoHanh = baoHanh;
    }

    public HangSanXuat getTenHang() {
        return tenHang;
    }

    public void setTenHang(HangSanXuat tenHang) {
        this.tenHang = tenHang;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(int baoHanh) {
        this.baoHanh = baoHanh;
    }
   
   public Boolean checkPricePC(MayTinh mayTinhKhac ){
       return this.price < mayTinhKhac.price;
   }
    
   public String showNameCountry (){
     return  this.tenHang.getQuocGia();
   }
}
