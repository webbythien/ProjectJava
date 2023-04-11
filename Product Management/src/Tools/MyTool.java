/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import data.Product;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class MyTool {

    public static final Scanner SC = new Scanner(System.in);

    public static boolean validStr(String str, String regEX) {
        return str.matches(regEX);
    }

    public static boolean parseBool(String boolStr) {
        char c = boolStr.trim().toUpperCase().charAt(0);
        return (c == '1' || c == 'Y' || c == 'T');
    }

    public static String readNonBlank(String message) {
        String input = "";
        do {
            System.out.println(message + ":");
            input = SC.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    public static String readPattern(String message, String pattern) {
        String input = "";
        boolean valid;
        do {
            System.out.println(message + " : ");
            input = SC.nextLine().trim();
            valid = validStr(input, pattern);
        } while (!valid);
        return input;
    }
    
     public static String readPatternSpace(String message, String pattern) {
        String input = "";
        boolean valid;
        do {
            System.out.println(message + " : ");
            input = SC.nextLine().trim();
            valid = validStr(input, pattern);
        } while (!valid&&!input.isEmpty());
        return input;
    }

    public static boolean readBool(String message) {
        String input;
        System.out.println(message + "[1/0-Y/N-T/F]: ");
        input = SC.nextLine().trim();
        if (input.isEmpty()) {
            return false;
        }
        char c = Character.toUpperCase(input.charAt(0));
        return (c == '1' || c == 'Y' || c == 'T');
    }
    
    public static boolean readBoolStatus(String message) {
        String input;
        System.out.println(message + "[1/0-Y/N-T/F]: ");
        input = SC.nextLine().trim();
        if (input.isEmpty()) {
            return false;
        }
        char c = Character.toUpperCase(input.charAt(0));
        return (c == '1' || c == 'Y' || c == 'T'|| c == 'A');
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static void printAllProduct(ArrayList<Product> product1) {
        if (product1.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            System.out.println("+---------+---------------------+--------------------+---------------+--------------+");
            System.out.println("|   ID    |    Product name     |   Unit Price       |    Quantity   |  Status      |");
            System.out.println("+---------+---------------------+--------------------+---------------+--------------+");
            for (Product p : product1) {
                p.makeTable();
            }
            System.out.println("+---------+---------------------+--------------------+---------------+--------------+");
        }
    }
    
    public static void printObject(Product p1){
        if (p1==null) {
            System.out.println("Empty List!");
        } else {
            System.out.println("+---------+---------------------+--------------------+---------------+--------------+");
            System.out.println("|   ID    |    Product name     |   Unit Price       |    Quantity   |  Status      |");
            System.out.println("+---------+---------------------+--------------------+---------------+--------------+");
            p1.makeTable();
            System.out.println("+---------+---------------------+--------------------+---------------+--------------+");
        }
    }
}
