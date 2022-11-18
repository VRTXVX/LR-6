package service;

import smarthome.SmartHome;

import static color.Color.colorize;
import java.util.Scanner;

public class Service {
    private static SmartHome curSmartHome;
    public final static Scanner sc = new Scanner(System.in);

    public static int getIntValue( int maxValue, String message) {
        int choice;

        do {
            try {
                System.out.print(message + " >>> ");

                choice = sc.nextInt();

                if(choice >= 0 && choice <= maxValue) return choice;

                System.out.println("Value out of range");
                
            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println(colorize("\n[ERROR] ", "RED") + "Invalid input");
            }
        } while (true);
    }

    public static double getDoubleValue(double maxValue,String message) {
        double choice;
        do {
            try {
                System.out.print(message + " >>> ");

                choice = sc.nextDouble();

                if(choice >= 0 && choice <= maxValue) return choice;

                System.out.println("Value out of range");

            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println(colorize("\n[ERROR] ", "RED") + "Invalid input");
            }
        } while (true);
    }

    public static double getDoubleValue(String message){
        return getDoubleValue(Double.MAX_VALUE,message);
    }

    public static String getLine(String message) {
        String line;
        do {
            try {
                System.out.print(message + " >>> ");

                line = sc.next();

                if (line.length() > 0) return line;

                System.out.println(colorize("\n[ERROR] ", "RED") + "String is empty");

            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println(colorize("\n[ERROR] ", "RED") + "Invalid input");
            }
        } while (true);
    }
    
    public static SmartHome getCurSmartHome() { return curSmartHome; }
    public static void setCurSmartHome (SmartHome curSmartHome) { Service.curSmartHome = curSmartHome; }
    
}
