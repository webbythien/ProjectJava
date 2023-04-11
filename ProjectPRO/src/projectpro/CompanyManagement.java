/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpro;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class CompanyManagement<E> {

    private ArrayList<Employee> empList;

    public CompanyManagement(String path, String path1) throws FileNotFoundException, IOException {
        empList = getEmployeeFromFile(path, path1);
    }

    public ArrayList<Employee> getEmployeeFromFile(String path, String path1) throws FileNotFoundException, IOException {
        ArrayList<Employee> result = null;
        try{ 
            Hashtable plInfo = new Hashtable();
            String thisLine;
            BufferedReader myInput = null;
            File f = new File(path1);
            String fullPath = f.getAbsolutePath();
            FileInputStream file = new FileInputStream(fullPath);
            myInput = new BufferedReader(new InputStreamReader(file));
            while((thisLine = myInput.readLine()) != null){
                if(!thisLine.isEmpty()){
                    String[] split = thisLine.split(",");
                    ArrayList<String> programmingLanguagues = new ArrayList<>();
                    for(int i =1 ; i < split.length;i++){
                        programmingLanguagues.add(split[i]);
                    }
                    plInfo.put(split[0], programmingLanguagues);
                    
                }
            }
            myInput.close();
            
            f = new File(path);
            fullPath = f.getAbsolutePath();
            file = new FileInputStream(fullPath);
            myInput = new BufferedReader(new InputStreamReader(file));
            Employee emp = null;
            while ((thisLine = myInput.readLine())!=null){
                if(!thisLine.isEmpty()){
                    String[] split = thisLine.split(",");
                    if(empList==null){
                        empList = new ArrayList<>();
                    }
                    if (split[1].charAt(0)=='T'){
                        emp = new Tester(split[1], split[2], Integer.parseInt(split[split.length-1]), Double.parseDouble(split[3]),split[4]);
                        empList.add(emp);
                    }
                    else if(split[5].equals("L")){
                        emp = new TeamLeader(split[1], split[2], Integer.parseInt(split[split.length-1]),split[3], (ArrayList<String>) plInfo.get(split[1]), Integer.parseInt(split[4]), Double.parseDouble(split[6]));
                       empList.add(emp); 
                    }
                    else{
                        emp = new Developer(split[1],split[2],  split[3], Integer.parseInt(split[4]), Integer.parseInt(split[split.length-1]), (ArrayList<String>) plInfo.get(split[1]));
                        //(split[1], split[2], Integer.parseInt(split[split.length-1]), split[3],(ArrayList<String>) plInfo.get(split[1]), Integer.parseInt(split[4]))
                        empList.add(emp);
                    }
                    
                }
            }
            myInput.close();
        }
           catch(Exception e){
               e.printStackTrace();
           }
        finally{
            return empList;
        }
    }

    public ArrayList<Developer> getDeveloperByProgrammingLanguage(String pl) {
        if(empList==null){
            return null;
        }
        ArrayList<Developer> listExpert = null;
        for(Employee emp : empList){
            if(emp instanceof Developer){
                for(String plOfDev :((Developer ) emp).getProgrammingLanguages() ){
                    if((plOfDev).equals(pl)){
                        if(listExpert ==null){
                            listExpert = new ArrayList<>();
                        }
                        listExpert.add(((Developer) emp));
                    }
                }
            }
        }
        return listExpert;
    }

    public ArrayList<Tester> getTestersHaveSalaryGreaterThan(double value) {
        if(empList ==null){
            return null;
            
        }
        if(value<0){
            return null;
        }
        ArrayList<Tester> salaryGreaterValue = null;
        for(Employee emp : empList){
            if(emp instanceof Tester){
                if(emp.getSalary()>value){
                    if(salaryGreaterValue==null){
                        salaryGreaterValue = new ArrayList<>();
                    }
                    salaryGreaterValue.add(((Tester)emp));
                    
                }
            }
        }
        return salaryGreaterValue;
    }

    public Employee getEmployeeWithHigestSalary(){
        if(empList == null){
            return null;
        }
        Employee e = null;
        for(Employee emp : empList){
            if(e == null){
                e = emp;
            }
            if(e.getSalary()<= emp.getSalary()){
                e = emp;
            }
        }
        for(int i = empList.size()-1;i>=0;i--){
            if(empList.get(i).getSalary()==e.getSalary()){
                e = empList.get(i);
                break;
            }
        }
        return e ;
    }
    //trả vê trường nhóm của nhóm cos nhiều lập trình viên nhất 
    public TeamLeader getLeaderWithMostEmployee(){
        if(empList==null){
            return null;
        }
        TeamLeader leader = null;
        int count = 0;
        for(Employee emp : empList){
            if(emp instanceof TeamLeader){
                if(leader == null){
                    leader = (TeamLeader) emp;
                    for (Employee empCount : empList) {
                        if(empCount instanceof Developer){
                            if(((Developer)empCount).getTeamName().equals(leader.getTeamName())){
                                count ++;
                            }
                        }
                    }
                }
                int count1 = 0;
                if(((Developer)emp).getTeamName().compareTo(leader.getTeamName())!=0){
                    for (Employee empCount1 : empList) {
                        if(empCount1 instanceof Developer){
                            if(((Developer)empCount1).getTeamName().equals(((TeamLeader)emp).getTeamName())){
                                count1 ++;
                            }
                                    
                        }
                    }
                    if(count1 > count){
                        leader = (TeamLeader) emp;
                        count= count1 ;
                    }
                    else if (count1 == count ){
                        if(((TeamLeader)emp).getExpYear() > leader.getExpYear()){
                            leader = (TeamLeader) emp;
                            count = count1 ;
                        }
                    }
                }
            }
        }
        return leader;
    }
    
    public ArrayList<Employee>sorted(){
        if(empList==null){
            return null;
        }
        ArrayList<Employee> sortList = null;
        sortList = (ArrayList<Employee>)empList.clone();//copy emplist
        Comparator com = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
               if(e1.getSalary()==e2.getSalary()){
                   int lastIndexName1 = e1.getEmpName().lastIndexOf(" ");
                   
                   int lastIndexName2 = e2.getEmpName().lastIndexOf(" ");
                   
                   return (e1.getEmpName().charAt(lastIndexName1+1 ) - e2.getEmpName().charAt(lastIndexName2+1));
               }
               else{
                   return ( int) (e2.getSalary()-e1.getSalary());
                   
               }
            }
        };
    sortList.sort(com);
    return sortList;
    }
    
    public void printEmplist(){
        for (Employee tmp : empList) {
            System.out.println(tmp);
        }
    }
    
    //methods for writing file
    public <E> boolean writeFile(String path, ArrayList<E> list){
        try{
            FileWriter writer = new FileWriter(path);
            for (E tmp : list) {
                writer.write(tmp.toString());
                writer.write("\r\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file");
            
        }catch(IOException e){
            System.out.println("Error.");
            return false;
        }
        return true;
    }
    public <E> boolean writeFile(String path, E object) {
        try{
            FileWriter writer = new FileWriter(path);
            writer.write(object.toString());
            writer.close();
            System.out.println("Successfully wrote to the file ");
            
        }catch (IOException e){
            System.out.println("Error.");
            return false;
        }
        return true;
    }
    
}
