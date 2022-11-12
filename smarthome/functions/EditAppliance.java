package smarthome.functions;

import appliance.Appliance;
import smarthome.SmartHome;
import static color.Color.colorize;
import static service.Service.*;
import static saving.Saving.saveSmartHome;
import static smarthome.functions.ChooseAppliance.chooseAppliance;


public class EditAppliance {
    public static void editAppliance() {
        SmartHome curSmartHome = getCurSmartHome();
        if (curSmartHome.isAppliancesEmpty()) return;

        Appliance curAppliance;
        String message;
        do {
            curAppliance = chooseAppliance(curSmartHome.getAppliances());

            if (curAppliance == null) return;

            message = String.format("""
                        Edit appliance
                    [1] - Edit name
                    [2] - Edit mark
                    [3] - Edit model
                    [4] - Edit watt hour
                    [5] - Turn %s
                    [6] - Edit power consumption class
                    [0] - Cancel
                                    
                    Enter the number of the option you want to choose >>>\040""",
                    curAppliance.getStatus() ? "off [" + colorize(" ■", "GREEN")
                            + "]" : "on [" + colorize("■ ", "RED") + "]");

            switch (getIntChoice(6, message)) {
                case 0 -> {
                    System.out.println(colorize("\nOperation canceled", "YELLOW"));
                    return;
                }
                case 1 -> curAppliance.setName(getLine("Enter new name >>> "));
                case 2 -> curAppliance.setMark(getLine("Enter new mark >>> "));
                case 3 -> curAppliance.setModel(getLine("Enter new model >>> "));
                case 4 -> curAppliance.setWattHour(getDoubleValue("Enter new watt hour >>> "));
                case 5 -> curAppliance.setStatus(!curAppliance.getStatus());
                case 6 -> curAppliance.setPowerConsumptionClass(getLine("Enter new power consumption class >>> "));
            }
            saveSmartHome(curSmartHome);
            System.out.println(colorize("[INFO]", "CYAN") + " Appliance edited successfully");

        } while (true);
    }
}
