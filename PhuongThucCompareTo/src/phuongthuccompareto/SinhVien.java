/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongthuccompareto;

/**
 *
 * @author thien
 */
public class SinhVien implements Comparable<SinhVien>{
    private int maSinhVien;
    private String hoVaTen;
    private String tenLop;
    private double diemTrungBinh;

    public SinhVien(int maSinhVien, String hoVaTen, String tenLop, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.tenLop = tenLop;
        this.diemTrungBinh = diemTrungBinh;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
    
    public String getTen(){
        String s =this.hoVaTen.trim();
        if(s.indexOf(" ")>=0){
          int vt =  s.lastIndexOf(" ");
          return s.substring(vt+1); 
        }else{
            return s;
        }
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSinhVien=" + maSinhVien + ", hoVaTen=" + hoVaTen + ", tenLop=" + tenLop + ", diemTrungBinh=" + diemTrungBinh + '}';
    }

    @Override
    public int compareTo(SinhVien o) {
        
        String tenThis = this.getTen();
        String ten0=o.getTen();// 2 cái tên đưa về đêr so sánh
       return tenThis.compareTo(ten0);
    //dua tren so sanh ten           
     
    }
    
}
