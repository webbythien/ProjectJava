/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlimaytinh;

/**
 *
 * @author thien
 */
public class Test {
    public static void main(String[] args) {
        HangSanXuat br1 = new HangSanXuat(" Intel ", "USA");
        HangSanXuat br2 = new HangSanXuat(" AMD ", "Taiwan");
        HangSanXuat br3= new HangSanXuat(" Xiaomy ", "China");
        HangSanXuat br4= new HangSanXuat("Samsung ", "Korea");
        
        Date d1= new Date(19, 5, 2022);
        Date d2= new Date(5, 6, 2022);
        Date d3= new Date(4, 7, 2022);
        Date d4= new Date(4, 10, 2022);
        
        MayTinh pc1 = new MayTinh(br1, d1, 25, 24);
        MayTinh pc2 = new MayTinh(br2, d2, 20, 24);
        MayTinh pc3 = new MayTinh(br3, d3, 10, 12);
        MayTinh pc4 = new MayTinh(br4, d4, 15, 12);
        
        System.out.println("So sanh gia m1 vs m2 "+pc1.checkPricePC(pc2));
        System.out.println("So sanh gia m1 vs m3 "+pc1.checkPricePC(pc3));
        System.out.println("So sanh gia m3 vs m4 "+pc3.checkPricePC(pc4));
        System.out.println("So sanh gia m2 vs m3 "+pc2.checkPricePC(pc3));
        
        System.out.println("Ten quoc gia m1 "+pc1.showNameCountry());
        System.out.println("Ten quoc gia m2 "+pc2.showNameCountry());
        System.out.println("Ten quoc gia m3 "+pc3.showNameCountry());
        System.out.println("Ten quoc gia m4 "+pc4.showNameCountry());
    }
    
}
