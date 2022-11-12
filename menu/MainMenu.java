package menu;

import command.smarthomecommand.*;
import command.Command;
import smarthome.SmartHome;
import saving.Saving;

public class MainMenu extends MenuService {

    public MainMenu(){
        this.menuLoop();
    }

    protected Command[] createCommands() {
        SmartHome[] smartHouses = Saving.loadSaving();

        if (smartHouses == null)
            return new Command[]{ new AddSmartHomeCommand() };

        return new Command[]{ new ChooseSmartHomeCommand(), new AddSmartHomeCommand(), new DeleteSmartHomeCommand(), };

    }
    protected boolean isExit() { return true; }
    protected String getMenuName(){ return "Main menu"; }
}
