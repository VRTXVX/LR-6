package command.appliancecommand.displaycommand;

import command.Command;
import static smarthome.functions.SortApplianceByParameter.sortApplianceByParameter;

public class SortApplianceByParameter implements Command {
    @Override
    public void execute() {
        sortApplianceByParameter();
    }

    @Override
    public String toString(){
        return "Sort list";
    }

}
