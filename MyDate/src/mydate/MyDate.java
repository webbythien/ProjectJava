/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydate;

/**
 *
 * @author thien
 */
public class MyDate {

private int day;
private int month;
private int year; 

    public MyDate(int day, int month, int year) {
        if(day>=1 && day<=31){
        this.day = day;
        }else{
        this.day=1;    
        }
        if(month>1 && month<=12){
        this.month = month;
        }else{
           this.month = 1 ;
        }
        if(year>=0){
            this.year = year;
        }else{
            this.year=1;
        }
        
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        if(day>=1 && day<=31)
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if(month>=1&&month<=12)
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if(year>0)
        this.year = year;
    }
    
    
}
