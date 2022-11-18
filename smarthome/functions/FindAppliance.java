package smarthome.functions;

import appliance.Appliance;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static color.Color.colorize;
import static service.Service.*;

public class FindAppliance {
    public static void choiceFinding(Appliance[] appliances) {

        String message = String.format("""
                    %s
                [1] - By name
                [2] - By mark
                [3] - By model
                [4] - By diapason of watt-hour
                [5] - By diapason of consumed energy
                [6] - By power consumption class
                [0] - Cancel
                Choose the option you want to choose""",colorize("Finding","CYAN"));

        do {
            switch (getIntValue(6,message)) {
                case 1 -> {
                    String name = getLine("Name");
                    findAndPrint(appliances, x -> x.getName().equals(name));
                }
                case 2 -> {
                    String mark = getLine("Mark");
                    findAndPrint(appliances, x -> x.getMark().equals(mark));
                }
                case 3 -> {
                    String model = getLine("Model");
                    findAndPrint(appliances, x -> x.getModel().equals(model));
                }
                case 4 -> {
                    double min = getDoubleValue("Min watt-hour");
                    double max = getDoubleValue("Max watt-hour");
                    findAndPrint(appliances, x -> x.getWattHour() >= min && x.getWattHour() <= max);
                }
                case 5 -> {
                    double min = getDoubleValue("Min consumed energy");
                    double max = getDoubleValue("Max consumed energy");
                    findAndPrint(appliances, x -> x.getConsumedEnergy() >= min && x.getConsumedEnergy() <= max);
                }
                case 6 -> {
                    String powerConsumptionClass = getLine("Power consumption class");
                    findAndPrint(appliances, x -> x.getPowerConsumptionClass().equals(powerConsumptionClass));
                }
                case 0 -> {
                    System.out.println(colorize("\nOperation canceled", "YELLOW"));
                    return;
                }
            }
        } while (true);
    }

    private static void findAndPrint(Appliance[] appliances, Predicate<Appliance> predicate) {

        List<Appliance> applianceList = new ArrayList<>();
        boolean found = false;

        for (Appliance appliance : appliances) {
            if (predicate.test(appliance)) {
                applianceList.add(appliance);
                found = true;
            }
        }

        if (!found) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliance not found");
            return;
        }

        PrintAppliance.printAppliance(applianceList.toArray(new Appliance[0]));
    }
}