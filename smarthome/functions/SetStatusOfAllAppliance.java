package smarthome.functions;

import appliance.Appliance;
import static service.Service.getCurSmartHome;
import static service.Service.getIntChoice;
import static color.Color.colorize;

public class SetStatusOfAllAppliance {
    public static void setStatusOfAllAppliance() {
        if(getCurSmartHome().isAppliancesEmpty()) return;

        boolean status;

        Appliance[] appliances = getCurSmartHome().getAppliances();

        int choice = getIntChoice(2,"Enter status: \n[1] - on\n[2] - off\n[0] - Cancel\n >>> ");

        if(choice == 0) return;

        status = choice == 1;

        for(Appliance appliance : appliances) {
            appliance.setStatus(status);
        }

        System.out.println(colorize("[INFO]","CYAN") + " All appliances are "+ (status ? "on" : "off"));
    }
}
