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
public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        
        
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(this.day>=1&&this.day<=31){
        this.day = day;
        }else{
        this.day=1;
        }
      }
 

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
    if(month>=1&&month<=12){
        this.month = month;
    }else{
        this.month=1;
    }
   }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(this.year>0){
        this.year = year;
        }else{
        this.year=2022;
        }
       }
    }
   
