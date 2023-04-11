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
public class HinhTron extends Hinh{
private double r;

    public HinhTron(double r, ToaDO toaDo) {
        super(toaDo);
        this.r = r;
    }

    public HinhTron(ToaDO toaDo) {
        super(toaDo);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double tinhDienTich() {
        return this.r*this.r*Math.PI;
    }
}

 
