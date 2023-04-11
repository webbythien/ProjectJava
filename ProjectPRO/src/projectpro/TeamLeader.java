/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpro;

import java.util.ArrayList;


/**
 *
 * @author thien
 */
public class TeamLeader extends Developer{
    private double bonus_rate;

    public TeamLeader( String empID, String empName, int baseSal, String teamName, ArrayList<String> programmingLanguages, int expYear,double bonus_rate) {
        super(empID, empName, teamName, expYear, baseSal, programmingLanguages);
        this.bonus_rate = bonus_rate;
    }

    public double getBonus_rate() {
        return bonus_rate;
    }

    
    public double getSalary() {
       double salary;
        return salary =  super.getSalary() + bonus_rate*super.getSalary() ;// tu khoa super lay tu lop cha 
    }
}
