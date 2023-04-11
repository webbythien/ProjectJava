/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudent;

/**
 *
 * @author thien
 */
public class Student {
    private String studentID;
    private String nameStudent;
    private Date stuDate;
    private double mark;
    private Class className;

    public Student(String studentID, String nameStudent, Date stuDate, double mark, Class className) {
        this.studentID = studentID;
        this.nameStudent = nameStudent;
        this.stuDate = stuDate;
        this.mark = mark;
        this.className = className;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Date getStuDate() {
        return stuDate;
    }

    public void setStuDate(Date stuDate) {
        this.stuDate = stuDate;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }
    
    public String printMajor(){
        return this.className.getMajorName();
    }
    
    public Boolean passOrFail(){
    return this.mark > 5 ;
    }
    public Boolean checkDateStu(Student hskhac ){
        return this.stuDate.equals(hskhac.stuDate);
    }
} 
