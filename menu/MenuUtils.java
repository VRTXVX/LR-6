package menu;

import command.Command;
import static service.Service.getIntChoice;
import static color.Color.colorize;

public abstract class MenuUtils {

    protected void menuLoop() {
        int choice;
        Command[] curCommands;

        do {
            curCommands = createCommands();

            if (curCommands == null) return; // DisplayListMenu can return null

            showMenu(curCommands);

            choice = getIntChoice(curCommands.length,"Enter your choice >>> ");

            if(choice == 0) return;

            curCommands[choice - 1].execute(); // because we display a menu that starts numbering from 1

        }while (true);
    }

    private void showMenu(Command[] curCommands) {
        System.out.println("\n   >>> " + colorize(getMenuName(),"CYAN") + " <<<");

        for (int i = 0; i < curCommands.length; i++) {
            System.out.println("[" + (i + 1)+ "] - " + curCommands[i]); // i + 1 because we want to start from 1
        }

        if(getMenuName().equals("Main menu")){
            System.out.println("[0] - Quit");
        } else {
            System.out.println("[0] - Back");
        }
    }

    protected abstract String getMenuName();
    protected abstract Command[] createCommands();

}
