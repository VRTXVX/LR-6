package command.appliancecommand.editlistcommand;

import command.Command;
import static smarthome.functions.AddAppliance.addAppliance;

public class AddApplianceCommand implements Command {
   @Override
   public void execute() {
         addAppliance();
   }

   @Override
    public String toString(){
         return "Add appliance";
    }
}