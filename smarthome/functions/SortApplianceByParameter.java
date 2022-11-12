package smarthome.functions;

import appliance.Appliance;
import smarthome.SmartHome;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static color.Color.colorize;
import static service.Service.getIntChoice;
import static service.Service.getCurSmartHome;
import static smarthome.functions.PrintAppliance.printAppliance;

public  class SortApplianceByParameter {
    public static void sortApplianceByParameter() {
        SmartHome curSmartHome = getCurSmartHome();
        if (curSmartHome.isAppliancesEmpty()) return;

        Appliance[] appliances = curSmartHome.getAppliances();

        int choice;
        boolean ascending;

        String message = """
                            Sortings:
                        [1] - Sort by name
                        [2] - Sort by mark
                        [3] - Sort by model
                        [4] - Sort by watt hour
                        [5] - Sort by power consumption class
                        [6] - Sort by consumed energy
                        [0] - Cancel
                        Choose the option you want to choose >>>\040""";


        choice = getIntChoice(6, message);

        if(choice == 0) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Operation canceled");
            return;
        }

        ascending = getIntChoice(2, "Sort in ascending order?\n[1] - Yes\n[2] - No\n >>> ") == 1;

        Comparator<Appliance> comparator = null;

        switch (choice) {
            case 1 -> comparator = Comparator.comparing(Appliance::getName);
            case 2 -> comparator = Comparator.comparing(Appliance::getMark);
            case 3 -> comparator = Comparator.comparing(Appliance::getModel);
            case 4 -> comparator = Comparator.comparing(Appliance::getWattHour);
            case 5 -> comparator = Comparator.comparing(Appliance::getPowerConsumptionClass);
            case 6 -> comparator = Comparator.comparing(Appliance::getConsumedEnergy);
        }

        if (ascending) {
            Arrays.sort(appliances, comparator);
        } else {
            Arrays.sort(appliances, Objects.requireNonNull(comparator).reversed());
        }
        System.out.println(colorize("[INFO]", "CYAN") + " Appliances sorted");
        printAppliance(getCurSmartHome().getAppliances());
    }

}
