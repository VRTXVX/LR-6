package command.appliancecommand.editlistcommand;

import command.Command;
import static smarthome.functions.SetStatusOfAllAppliance.setStatusOfAllAppliance;

public class SetStatusOfAllAppliancesCommand implements Command {

    @Override
    public void execute() {
        setStatusOfAllAppliance();
    }
    @Override
    public String toString() {
        return "Turn on/off all appliances";
    }
}
