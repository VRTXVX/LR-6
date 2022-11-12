package command.smarthomecommand;

import command.Command;
import static smarthome.SmartHomeUtils.deleteSmartHome;

public class DeleteSmartHomeCommand implements Command {
    @Override
    public void execute() {
        deleteSmartHome();
    }

    @Override
    public String toString(){
        return "Delete smart home";
    }
}
