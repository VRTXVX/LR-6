package command.appliancecommand.editlistcommand;

import command.Command;
import static smarthome.functions.DeleteAppliance.deleteAppliance;

public class DeleteApplianceCommand implements Command {
    @Override
    public void execute() {
        deleteAppliance();
    }

    @Override
    public String toString(){
        return "Delete appliance";
    }

}