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
public class XeOto extends PhuongTienDiCHuyen {

    private String tenNhienLieu;

    public XeOto(String tenNhienLieu, HangSanXuat tenHang) {
        super("Xe Oto", tenHang);
        this.tenNhienLieu = tenNhienLieu;
    }

    public String getTenNhienLieu() {
        return tenNhienLieu;
    }

    public void setTenNhienLieu(String tenNhienLieu) {
        this.tenNhienLieu = tenNhienLieu;
    }

    @Override
    public double layVanToc() {
        return 60;
    }

}
