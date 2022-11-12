package menu;

import command.Command;
import smarthome.SmartHome;
import command.appliancecommand.*;
import static saving.Saving.loadSaving;

public class ApplianceMenu extends MenuUtils {
    public ApplianceMenu(){
        menuLoop();
    }

    protected Command[] createCommands() {
        SmartHome[] smartHouses = loadSaving();

        if (smartHouses == null)
            return new Command[]{ new EditListCommand() };

        return new Command[]{ new DisplayListCommand(),new TotalConsumedEnergyCommand(),new EditListCommand()};

    }

    protected String getMenuName(){ return "Appliance menu"; }

}

