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
public class Developer extends Employee{
protected String teamName;
protected ArrayList<String> programmingLanguages;
protected int expYear;


    public Developer(String empID, String empName,String teamName, int expYear, int baseSal, ArrayList<String> programmingLanguages) {
        super(empID, empName, baseSal);
        this.teamName = teamName;
        this.programmingLanguages = programmingLanguages;
        this.expYear = expYear;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public int getExpYear() {
        return expYear;
    }

   

    @Override
    public double getSalary() {
        double salary;
        if(expYear >= 5){
            return salary = baseSal + expYear*2000000 ;
        }else if ( expYear<5 && expYear >=3){
             return salary = baseSal + expYear*1000000 ;
        }else {
            return salary = baseSal;
        }
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", empName=" + empName + ", baseSal=" + baseSal + ", teamName= " +teamName + ",expYear = " + expYear +
                ",ProgrammingLanguages ="+getProgrammingLanguages()+'}';
    }
    
}
