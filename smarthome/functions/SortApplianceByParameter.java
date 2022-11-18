package smarthome.functions;

import appliance.Appliance;
import smarthome.SmartHome;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import static color.Color.colorize;
import static service.Service.getCurSmartHome;
import static service.Service.getIntValue;
import static smarthome.functions.PrintAppliance.printAppliance;

public class SortApplianceByParameter {
    public static void sortApplianceByParameter() {
        SmartHome curSmartHome = getCurSmartHome();

        if (curSmartHome.isAppliancesEmpty()) return;

        Appliance[] appliances = curSmartHome.getAppliances();
        int choice;
        boolean ascending;

        String message = String.format("""
                            %s
                        [1] - By name
                        [2] - By mark
                        [3] - By model
                        [4] - By watt-hour
                        [5] - By power consumption class
                        [6] - By consumed energy
                        [0] - Cancel
                        Choose the option you want to choose""",colorize("Sorting","CYAN"));


        choice = getIntValue(6, message);

        Comparator<Appliance> comparator = null;
        switch (choice) {
            case 1 -> comparator = Comparator.comparing(Appliance::getName);
            case 2 -> comparator = Comparator.comparing(Appliance::getMark);
            case 3 -> comparator = Comparator.comparing(Appliance::getModel);
            case 4 -> comparator = Comparator.comparing(Appliance::getWattHour);
            case 5 -> comparator = Comparator.comparing(Appliance::getPowerConsumptionClass);
            case 6 -> comparator = Comparator.comparing(Appliance::getConsumedEnergy);
            case 0 -> {
                System.out.println(colorize("[INFO]", "YELLOW") + " Operation canceled");
                return;
            }
        }

        ascending = getIntValue(2, "Sort in ascending order?\n[1] - Yes\n[2] - No\n") == 1;

        Arrays.sort(appliances, ascending ? comparator : Objects.requireNonNull(comparator).reversed());

        System.out.println(colorize("[INFO]", "CYAN") + " Appliances sorted");
        printAppliance(getCurSmartHome().getAppliances());
    }

}
