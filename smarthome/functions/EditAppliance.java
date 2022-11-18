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
                        %s
                    [1] - Name
                    [2] - Mark
                    [3] - Model
                    [4] - Watt-hour
                    [5] - Turn %s
                    [6] - Power consumption class
                    [0] - Cancel
                                    
                    Enter the number of the option you want to choose""",colorize("Edit","CYAN"),
                    curAppliance.getStatus() ? "off [" + colorize(" ■", "GREEN")
                            + "]" : "on [" + colorize("■ ", "RED") + "]");

            switch (getIntValue(6, message)) {
                case 1 -> curAppliance.setName(getLine("New name"));
                case 2 -> curAppliance.setMark(getLine("New mark"));
                case 3 -> curAppliance.setModel(getLine("New model"));
                case 4 -> curAppliance.setWattHour(getDoubleValue("New watt-hour"));
                case 5 -> curAppliance.setStatus(!curAppliance.getStatus());
                case 6 -> curAppliance.setPowerConsumptionClass(getLine("New power consumption class"));
                case 0 -> {
                    System.out.println(colorize("\nOperation canceled", "YELLOW"));
                    return;
                }
            }
            saveSmartHome(curSmartHome);
            System.out.println(colorize("[INFO]", "CYAN") + " Appliance edited successfully");

        } while (true);
    }
}
