/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtiendichuyen;

/**
 *
 * @author thien
 */
public abstract class  PhuongTienDiCHuyen {
    protected String loaiPhuongTien;
    private HangSanXuat tenHang;

    public PhuongTienDiCHuyen(String loaiPhuongTien, HangSanXuat tenHang) {
        this.loaiPhuongTien = loaiPhuongTien;
        this.tenHang = tenHang;
    }

    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }

    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    public HangSanXuat getTenHang() {
        return tenHang;
    }

    public void setTenHang(HangSanXuat tenHang) {
        this.tenHang = tenHang;
    }

    public String layTenHang(){
        return this.tenHang.getTenHangSanXuat();
    }
    public void batDau(){
        System.out.println("Start...");
    }
     public void tangToc(){
        System.out.println("Speed....");
    }
      public void dungLai(){
        System.out.println("Stop....");
    }
      public abstract double layVanToc();
      
      public void catCanh(){
          System.out.println("Bat Che Do Bay Lennnn ");
      }
      
      public void haCanh(){
          System.out.println("Bat Che Do Downnn ");
      }
}

