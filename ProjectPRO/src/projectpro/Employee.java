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
public abstract class Employee {
    protected String empID;
    protected String empName;
    protected int baseSal;

    public Employee(String empID, String empName, int baseSal) {
        this.empID = empID;
        this.empName = empName;
        this.baseSal = baseSal;
    }

    public String getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public int getBaseSal() {
        return baseSal;
    }
    public abstract double getSalary();

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", empName=" + empName + ", baseSal=" + baseSal + '}';
    }
    
}
