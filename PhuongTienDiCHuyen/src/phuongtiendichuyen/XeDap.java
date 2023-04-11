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
public class XeDap  extends PhuongTienDiCHuyen{

    public XeDap( HangSanXuat tenHang) {
        super("Xe Dap", tenHang);
    }

    @Override
    public double layVanToc() {
        return 20;
    }
 
}
