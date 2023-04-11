/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thien
 */
public class Film {

    private String nameFilm;
    private int yearMake;
    private BrandFilm brandName;
    private double ticketPrice;
    private PublishDay publishDay;

    public Film(String nameFilm, int yearMake, BrandFilm brandName, double ticketPrice, PublishDay publishDay) {
        this.nameFilm = nameFilm;
        this.yearMake = yearMake;
        this.brandName = brandName;
        this.ticketPrice = ticketPrice;
        this.publishDay = publishDay;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public int getYearMake() {
        return yearMake;
    }

    public void setYearMake(int yearMake) {
        this.yearMake = yearMake;
    }

    public BrandFilm getBrandName() {
        return brandName;
    }

    public void setBrandName(BrandFilm brandName) {
        this.brandName = brandName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public PublishDay getPublishDay() {
        return publishDay;
    }

    public void setPublishDay(PublishDay publishDay) {
        this.publishDay = publishDay;
    }

    public Boolean checkTicketPriceCheaper(Film phimKhac) {
        return this.ticketPrice < phimKhac.ticketPrice;
    }

    public String printBrandName() {
        return this.brandName.getNameBrand();
    }

    public double discount(double x) {
        return this.ticketPrice - this.ticketPrice * (x / 100);

    }
}
