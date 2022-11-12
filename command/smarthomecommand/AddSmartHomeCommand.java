package command.smarthomecommand;

import command.Command;
import static smarthome.SmartHomeUtils.addSmartHome;

public class AddSmartHomeCommand implements Command {
    @Override
    public void execute() {
        addSmartHome();
    }

    @Override
    public String toString(){
        return "Add smart home";
    }
}