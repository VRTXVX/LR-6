package command.appliancecommand;

import command.Command;
import menu.EditListMenu;

public class EditListCommand implements Command {
    @Override
    public void execute() {
        new EditListMenu();
    }

    @Override
        public String toString(){
            return "Edit list";
        }

}
