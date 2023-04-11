/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaenum1;

/**
 *
 * @author thien
 */
public class ThoiKhoaBieu {
    private Day thu;
    private String cacMonHoc;
    private GioiTinh gioiTinh;

    public ThoiKhoaBieu(Day thu, String cacMonHoc) {
        this.thu = thu;
        this.cacMonHoc = cacMonHoc;
    }

    public Day getThu() {
        return thu;
    }

    public void setThu(Day thu) {
        this.thu = thu;
    }

    public String getCacMonHoc() {
        return cacMonHoc;
    }

    public void setCacMonHoc(String cacMonHoc) {
        this.cacMonHoc = cacMonHoc;
    }

    @Override
    public String toString() {
        return "ThoiKhoaBieu{" + "thu=" + thu + ", cacMonHoc=" + cacMonHoc + '}';
    }
    
    
}
