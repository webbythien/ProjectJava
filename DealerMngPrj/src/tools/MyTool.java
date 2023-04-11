/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import data.Dealer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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

    public static boolean validPassword(String str, int minLen) {

        if (str.length() < minLen) {
            return false;
        }
        return str.matches(".*[a-zA-Z]+.*")
                && str.matches(".*[\\d]+.*")
                && str.matches(".*[\\W]+.*");
    }

    public static Date parseDate(String dateStr, String dateFormat) {
        SimpleDateFormat dF = (SimpleDateFormat) SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        try {
            long t = dF.parse(dateStr).getTime();//
            return new Date(t);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return null;
    }

    public static String dataToStr(Date date, String dateFormat) {
        SimpleDateFormat dF = (SimpleDateFormat) SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        String Str = dF.format(date);
        return Str;
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

    public static List<String> readLinesFromFile(String filename) {
        ArrayList<String> list = new ArrayList<>();
        String thisLine;
        try {
            BufferedReader myInput = null;
            File f = new File(filename);
            String fullPath = f.getAbsolutePath();
            FileInputStream file = new FileInputStream(fullPath);
            myInput = new BufferedReader(new InputStreamReader(file));
            while ((thisLine = myInput.readLine()) != null) {
                thisLine.trim();
                if (!thisLine.isEmpty()) {
                    list.add(thisLine);
                }
            }
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public static void writeFile(String filename, List list) {
        try {
            FileWriter writer = new FileWriter(filename);
             for (Object tmp : list) {
                writer.write(tmp.toString());
            }
            writer.close();
            System.out.println("Successfully wrote to the file ");
        } catch (IOException e) {
            System.out.println("Error.");
        }

    }
public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
}
    public static void main(String[] args) {
        System.out.println("Test with phone number:");
        System.out.println(validStr("012345678", "\\d{9}|\\d{11}"));
        System.out.println(validStr("01234567891", "\\d{9}|\\d{11}"));
        System.out.println(validStr("12345678", "\\d{9}|\\d{11}"));
        System.out.println("------");
        //test password
        System.out.println(validPassword("qbc@123456", 8));
        System.out.println(validPassword("qwertyABC", 8));
        //ID format D000 -> ok
        System.out.println("------");
        System.out.println("Test with IDs:");
        System.out.println(validStr("A0001", "D\\d{3}"));
        System.out.println(validStr("D101", "D\\d{3}"));

        //Test date format -> OK 
        System.out.println("------");
        Date d = parseDate("2022:12:07", "yyyy:MM:dd");
        System.out.println(d);
        System.out.println(dataToStr(d, "dd/MM/yyyy"));

        // test input data-> ok
        String input;
//        input = readNonBlank("Input a non-blank string");
//        System.out.println(input);
//        input = readPattern("Phone 9/11 digits", "\\d{9}|\\d{11}");
//        System.out.println(input);
        input = readPattern("ID Format x00000", "X\\d{5}");
        System.out.println(input);
        boolean b = readBool("Input boolean");
        System.out.println(b);
    }
}
