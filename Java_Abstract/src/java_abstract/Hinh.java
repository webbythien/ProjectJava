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
public abstract class Hinh {
    protected ToaDO toaDo;

    public Hinh(ToaDO toaDo) {
        this.toaDo = toaDo;
    }

    public ToaDO getToaDo() {
        return toaDo;
    }

    public void setToaDo(ToaDO toaDo) {
        this.toaDo = toaDo;
    }
   public abstract double tinhDienTich();
}
