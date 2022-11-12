package command.appliancecommand.editlistcommand;

import command.Command;
import static smarthome.functions.EditAppliance.editAppliance;
public class EditApplianceCommand implements Command {
    @Override
    public void execute() {
        editAppliance();
    }

    @Override
    public String toString(){
        return "Edit appliance";
    }
}
