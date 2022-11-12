package smarthome.functions;

import appliance.Appliance;
import smarthome.SmartHome;

import static color.Color.colorize;
import static saving.Saving.saveSmartHome;
import static smarthome.functions.ChooseAppliance.chooseAppliance;
import static service.Service.getCurSmartHome;

public class DeleteAppliance {
    public static void deleteAppliance() {
        SmartHome curSmartHome = getCurSmartHome();

        do{
            if (curSmartHome.getAppliances().length == 0) return;

            Appliance[] newAppliances = new Appliance[curSmartHome.getAppliances().length - 1];
            Appliance applianceToRemove = chooseAppliance(curSmartHome.getAppliances());

            if(applianceToRemove == null) return;

            for (int i = 0, j = 0; i < curSmartHome.getAppliances().length; i++) {// copy old array to new array without the appliance to remove
                if (curSmartHome.getAppliances()[i] != applianceToRemove) {
                    newAppliances[j++] = curSmartHome.getAppliances()[i];
                }
            }

            System.out.println(colorize("[INFO]", "CYAN") + "Appliance deleted successfully");
            curSmartHome.setAppliances(newAppliances); // set new array to appliances
            saveSmartHome(curSmartHome); // save smart home to file
        }while(true);
    }
}
