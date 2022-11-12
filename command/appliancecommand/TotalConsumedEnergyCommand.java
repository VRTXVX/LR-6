package command.appliancecommand;

import command.Command;
import static service.Service.getCurSmartHome;

public class TotalConsumedEnergyCommand implements Command {
    @Override
    public void execute() {
        if(getCurSmartHome().isAppliancesEmpty()) return;

        double totalConsumedEnergy = getCurSmartHome().getTotalConsumedEnergy(); // total consumed energy in watts
        System.out.println("Total consumed energy: " + String.format("%.5f", totalConsumedEnergy / 1000) + " kWt or "
                + String.format("%.5f", totalConsumedEnergy) + " Wt");
    }

    @Override
    public String toString(){
        return "Total consumed energy";
    }
}
