/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpro;

/**
 *
 * @author thien
 */
public class Tester extends Employee{
    protected double bonusRate;
    protected String type;

    public Tester(String empID, String empName, int baseSal,double bonusRate, String type) {
        super(empID, empName, baseSal);
        this.bonusRate = bonusRate;
        this.type = type;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getSalary() {
       double salary;
        return salary = baseSal + bonusRate*baseSal;
    }
    
}
