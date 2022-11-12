package command.appliancecommand.displaycommand;

import command.Command;
import static service.Service.getCurSmartHome;
import static smarthome.functions.FindAppliance.findAppliance;

public class FindApplianceByParameterCommand implements Command {
    @Override
    public void execute() {
        findAppliance(getCurSmartHome().getAppliances());
    }

    @Override
    public String toString(){
        return "Find appliance";
    }
}
