/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thien
 */
public class Test {

    public static void main(String[] args) {
        PublishDay d1 = new PublishDay(15, 9, 2030);
        PublishDay d2 = new PublishDay(4, 7, 2035);
        PublishDay d3 = new PublishDay(4, 10, 2025);

        BrandFilm bf1 = new BrandFilm("Đất Việt", "Việt Nam");
        BrandFilm bf2 = new BrandFilm("Marvel", "Mỹ");
        BrandFilm bf3 = new BrandFilm("DC comics", "Mỹ");

        Film f1 = new Film("Trịnh và Em", 2020, bf1, 60000, d1);
        Film f2 = new Film("Avengers", 2021, bf2, 65000, d2);
        Film f3 = new Film("Batman", 2019, bf3, 50000, d3);

        System.out.println("So sanh gia film 1 re hon film 3" + f1.checkTicketPriceCheaper(f3));
        System.out.println("So sanh gia film 1 re hon film 2" + f1.checkTicketPriceCheaper(f2));

        System.out.println("Ten hang phim 1 "+f1.printBrandName());
        System.out.println("Ten hang phim 2 "+f2.printBrandName());
        System.out.println("Ten hang phim 3 "+f3.printBrandName());
        
        System.out.println("film 1 Gia sau khi giam 10%: "+f1.discount(10));
        System.out.println("film 2 Gia sau khi giam 10%: "+f2.discount(10));
        System.out.println("film 3 Gia sau khi giam 10%: "+f3.discount(10));
    } 

}
