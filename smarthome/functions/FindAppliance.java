package smarthome.functions;

import appliance.Appliance;
import static color.Color.colorize;
import static service.Service.getIntChoice;
import static service.Service.getLine;

public class FindAppliance {
    public static void findAppliance(Appliance[] appliances) {

        int choice;

        String message = """
                [1] - Find by name
                [2] - Find by mark
                [3] - Find by model
                [4] - Find by diapason of watt hour
                [5] - Find by diapason of consumed energy
                [6] - Find by diapason of power consumption class
                [0] - Cancel
                Choose the option you want to choose >>>\040""";

        do{
            choice = getIntChoice(6,message);

            switch (choice) {
                case 1 -> findByName(appliances);
                case 2 -> findByMark(appliances);
                case 3 -> findByModel(appliances);
                case 4 -> findByWattHour(appliances);
                case 5 -> findByConsumedEnergy(appliances);
                case 6 -> findByPowerConsumptionClass(appliances);
                case 0 -> {
                    System.out.println(colorize("\nOperation canceled", "YELLOW"));
                    return;
                }
            }

        }while (true);

    }

    private static void findByName(Appliance[] appliances){
        String name = getLine("Enter name >>> ");

        boolean found = false;

        for (int i = 0,j = 1; i < appliances.length; i++) {
            if (appliances[i].getName().equals(name)) {
                System.out.println("[" + j + "] - " + appliances[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
        }
    }

    private static void findByMark(Appliance[] appliances){
        String mark = getLine("Enter mark >>> ");

        boolean found = false;

        for (int i = 0,j = 1; i < appliances.length; i++) {
            if (appliances[i].getMark().equals(mark)) {
                System.out.println("[" + j + "] - " + appliances[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
        }
    }

    private static void findByModel(Appliance[] appliances){
        String model = getLine("Enter model >>> ");

        boolean found = false;

        for (int i = 0,j = 1; i < appliances.length; i++) {
            if (appliances[i].getModel().equals(model)) {
                System.out.println("[" + j + "] - " + appliances[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
        }
    }

    private static void findByWattHour(Appliance[] appliances){
        int min = getIntChoice("Enter min watt hour >>> ");
        int max = getIntChoice("Enter max watt hour >>> ");

        boolean found = false;

        for (int i = 0,j = 1; i < appliances.length; i++) {
            if (appliances[i].getWattHour() >= min && appliances[i].getWattHour() <= max) {
                System.out.println("[" + j + "] - " + appliances[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
        }
    }

    private static void findByConsumedEnergy(Appliance[] appliances){
        int min = getIntChoice("Enter min consumed energy >>> ");
        int max = getIntChoice("Enter max consumed energy >>> ");

        boolean found = false;

        for (int i = 0,j = 1; i < appliances.length; i++) {
            if (appliances[i].getConsumedEnergy() >= min && appliances[i].getConsumedEnergy() <= max) {
                System.out.println("[" + j + "] - " + appliances[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
        }
    }

    private static void findByPowerConsumptionClass(Appliance[] appliances){
        String consumptionClass = getLine("Enter power consumption class >>> ");

        boolean found = false;

        for (int i = 0,j = 1; i < appliances.length; i++) {
            if (appliances[i].getPowerConsumptionClass().equals(consumptionClass)) {
                System.out.println("[" + j + "] - " + appliances[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
        }
    }
}
