package service;

import smarthome.SmartHome;

import static color.Color.colorize;
import java.util.Scanner;

public class Service {
    private static SmartHome curSmartHome;

    public final static Scanner sc = new Scanner(System.in);

    public static int getIntChoice(int maxValue, String message) {
        int choice;
        do {
            try {
                System.out.print(message);

                choice = sc.nextInt();

                if (choice < 0 || choice > maxValue) {
                    System.out.println("Value out of range");
                    continue;
                }

                return choice;

            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println(colorize("\n[ERROR] ", "RED") + "Invalid input");
            }
        } while (true);
    }

    public static int getIntChoice(String message) {
        return getIntChoice(Integer.MAX_VALUE, message);
    }


    public static double getDoubleValue(String message) {
        double choice;
        do {
            try {
                System.out.print(message);

                choice = sc.nextDouble();

                if(choice <= 0) {
                    System.out.println("Value out of range");
                    continue;
                }

                return choice;

            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println(colorize("\n[ERROR] ", "RED") + "Invalid input");
            }
        } while (true);
    }

    public static String getLine(String message) {
        String line;
        do {
            try {
                System.out.print(message);
                line = sc.next();

                if (line.equals("")) {
                    System.out.println(colorize("\n[ERROR] ", "RED") + "String is empty");
                    continue;
                }

                return line;

            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println(colorize("\n[ERROR] ", "RED") + "Invalid input");
            }
        } while (true);
    }


    public static SmartHome getCurSmartHome() { return curSmartHome; }
    public static void setCurSmartHome (SmartHome curSmartHome) { Service.curSmartHome = curSmartHome; }


}
