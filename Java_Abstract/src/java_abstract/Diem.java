/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_abstract;

/**
 *
 * @author thien
 */
public class Diem extends Hinh{

    public Diem(ToaDO toaDo) {
        super(toaDo);
    }

    @Override
    public double tinhDienTich() {
       return 1;
    }
    
}
