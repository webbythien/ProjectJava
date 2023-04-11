/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe_laptrinhgiaodien;

import javax.swing.JFrame;

/**
 *
 * @author thien
 */
public class MyWindow extends JFrame{
    public MyWindow(){
        
    }
    
    public void showIt(){
    this.setVisible(true);
    }
    public void showIt(String title){
        this.setTitle(title);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        MyWindow m1 = new MyWindow();
        m1.showIt();
    }
}

