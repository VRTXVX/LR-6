package command.appliancecommand.displaycommand;

import appliance.Appliance;
import command.Command;
import static service.Service.getCurSmartHome;
import static smarthome.functions.PrintAppliance.printAppliance;

public class PrintApplianceCommand implements Command {
    @Override
    public void execute() {
        if (getCurSmartHome().isAppliancesEmpty()) return;

        Appliance[] appliances = getCurSmartHome().getAppliances();

        printAppliance(appliances);
    }

    @Override
    public String toString(){
        return "Print appliance";
    }
}

