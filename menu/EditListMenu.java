package menu;

import command.Command;
import command.appliancecommand.editlistcommand.*;
import static service.Service.getCurSmartHome;
public class EditListMenu extends MenuService {
    public EditListMenu(){
        menuLoop();
    }

    protected Command[] createCommands() {
        if(getCurSmartHome().isAppliancesEmpty())
            return new Command[]{ new AddApplianceCommand() };

        return new Command[]{ new AddApplianceCommand(), new EditApplianceCommand(),
                new SetStatusOfAllAppliancesCommand() ,new DeleteApplianceCommand() };
    }

    protected boolean isExit() { return false; }
    protected String getMenuName(){ return "Edit list menu"; }
}
