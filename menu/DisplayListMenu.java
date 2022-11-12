package menu;

import command.Command;
import command.appliancecommand.displaycommand.*;
import static service.Service.getCurSmartHome;

public class DisplayListMenu extends MenuService {
    public DisplayListMenu(){
        menuLoop();
    }

    protected Command[] createCommands() {
        if (getCurSmartHome().isAppliancesEmpty()) return null;

        return new Command[]{new PrintApplianceCommand(), new SortApplianceByParameter(), new FindApplianceByParameterCommand()};
    }

    protected boolean isExit() { return false; }
    protected String getMenuName(){ return "Display list menu"; }
}
