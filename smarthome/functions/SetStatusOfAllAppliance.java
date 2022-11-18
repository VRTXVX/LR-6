package smarthome.functions;

import appliance.Appliance;
import static service.Service.getCurSmartHome;
import static service.Service.getIntValue;
import static color.Color.colorize;
import static saving.Saving.saveSmartHome;

public class SetStatusOfAllAppliance {
    public static void setStatusOfAllAppliance() {
        if(getCurSmartHome().isAppliancesEmpty()) return;

        boolean status;

        Appliance[] appliances = getCurSmartHome().getAppliances();

        int choice = getIntValue(2,"Enter status: \n[1] - On\n[2] - Off\n[0] - Cancel");

        if(choice == 0) return;

        status = choice == 1;

        for(Appliance appliance : appliances) {
            if(appliance.getStatus() != status)
                appliance.setStatus(status);
        }

        System.out.println(colorize("[INFO]","CYAN") + " All appliances are "+
                (status ? colorize("on","GREEN") : colorize("off","RED")));
        saveSmartHome(getCurSmartHome());
    }
}
