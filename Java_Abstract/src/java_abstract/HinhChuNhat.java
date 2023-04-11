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
public class HinhChuNhat extends Hinh{
    private double chieuRong;
    private double chieuCao;

    public HinhChuNhat(double chieuRong, double chieuCao, ToaDO toaDo) {
        super(toaDo);
        this.chieuRong = chieuRong;
        this.chieuCao = chieuCao;
    }

    @Override
    public double tinhDienTich() {
        return this.chieuRong*this.chieuCao;
    }
    
}
