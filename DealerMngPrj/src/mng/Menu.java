/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import java.util.ArrayList;
import java.util.Collection;
import tools.MyTool;

/**
 *
 * @author thien
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public Menu(String[] items) {
        super();
        for (String item : items) {
            this.add(item);
        }
    }

    public int getChoice(String title) {// phải sửa
        String s="0";
        do {
            if(MyTool.isInteger(s)==false){
                System.out.println("");
                System.out.println("------Please, ENTER only numuber------");
                System.out.println("");
            }
            int sizeArr = this.size();
            System.out.println(title);;
            for (int i = 0; i < sizeArr; i++) {
                System.out.println((i + 1) + "-" + this.get(i));
            }
            System.out.println("Other for quit");
            System.out.print("Choose[1.." + sizeArr + "]: ");
            s = MyTool.SC.nextLine();
        } while (MyTool.isInteger(s) == false);
        return Integer.parseInt(s);
    }
}
