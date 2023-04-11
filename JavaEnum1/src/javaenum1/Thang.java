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
public enum Thang {
    January(31),
    February(29),
    March(31),
    April(30),
    May(31),
    June(30),
    July(31),
    August(31),
    Sep(30),
    Oct(31),
    Nov(30),
    Dec(31);

    private final int soNgay;
    Thang(int soNgay) {
        this.soNgay = soNgay;
    }

    public int soNgay() {
        return soNgay;
    }
}
