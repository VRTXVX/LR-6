package command.appliancecommand;

import command.Command;
import menu.DisplayListMenu;
import static service.Service.getCurSmartHome;

public class DisplayListCommand implements Command {
    @Override
    public void execute() {
        if (getCurSmartHome().isAppliancesEmpty()) return;

        new DisplayListMenu();
    }

    @Override
    public String toString(){
        return "Display list";
    }
}
