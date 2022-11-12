package smarthome.functions;

import appliance.Appliance;
import static color.Color.colorize;
import static service.Service.getIntChoice;
import static smarthome.functions.PrintAppliance.printAppliance;

public class ChooseAppliance {
    public static Appliance chooseAppliance(Appliance[] appliances) {
        String message = "Choose appliance(0 - Cancel) >>> ";

        printAppliance(appliances);

        int choice = getIntChoice(appliances.length, message);

        if(choice == 0){
            System.out.println(colorize("\nOperation canceled", "YELLOW"));
            return null;
        }

        return appliances[choice - 1];
    }
}

