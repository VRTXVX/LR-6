package command.smarthomecommand;

import command.Command;
import smarthome.SmartHome;
import static smarthome.SmartHomeUtils.chooseSmartHome;
import static service.Service.setCurSmartHome;
import menu.ApplianceMenu;

public class ChooseSmartHomeCommand implements Command {


    @Override
    public void execute() {
        SmartHome curSmartHome = chooseSmartHome();
        if (curSmartHome == null) {
            return;
        }
        setCurSmartHome(curSmartHome);
        new ApplianceMenu();
    }

    @Override
    public String toString(){
        return "Choose smart home";
    }


}
