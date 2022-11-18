package command.appliancecommand.displaycommand;

import command.Command;
import static service.Service.getCurSmartHome;
import static smarthome.functions.FindAppliance.choiceFinding;

public class FindApplianceByParameterCommand implements Command {
    @Override
    public void execute() {
        choiceFinding(getCurSmartHome().getAppliances());
    }

    @Override
    public String toString(){
        return "Find appliance";
    }
}
