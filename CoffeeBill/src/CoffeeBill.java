/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thien
 */
public class CoffeeBill {
    private String nameCoffee ;
    private double priceOneKg;
    private double weight ;
    
    public CoffeeBill(String name, double price,double kg){
        this.nameCoffee = name;
        this.priceOneKg=price;
        this.weight=kg;
    }
    
    public double tinhTongTien(){
        return this.priceOneKg * this.weight ;
    }
    public boolean kiemTraKhoiLuongLon(double kg){
    /*if(this.weight > kg){
        return true ;
    }else {
        return false;
    }*/
    return (this.weight > kg);
  }
    public boolean kiemTraTienLonHon500(){
   return this.tinhTongTien()>500;
}
    public double giamGia(double x){
        if(this.tinhTongTien()>500){
        return (x/100)*this.tinhTongTien();
    }else{
      return 0;      
     }
  }
    public double giaSauGiam(double x){
        return this.tinhTongTien() -  this.giamGia(x);
    }
}

