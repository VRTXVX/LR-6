package smarthome;

import static service.Service.getIntValue;
import static color.Color.colorize;
import static saving.Saving.*;// load smart houses and save
import static service.Service.getLine;

public class SmartHomeUtils {
    public static void addSmartHome() {
        SmartHome newSmartHome = new SmartHome();
        SmartHome[] smartHouses = loadSaving();
        String name;

        name = getLine("Enter the name of the SmartHome(0 - Cancel)");

        if (name.equals("0")) return;

        if (smartHouses != null) {  // if there are already saved SmartHouses
            for (SmartHome smartHome : smartHouses) { // check if the name is already taken
                if (smartHome.getName().equals(name)) {
                    System.out.println(colorize("[INFO]", "YELLOW") + " SmartHome with this name already exists!");
                    return;
                }
            }
        }

        newSmartHome.setName(name);
        saveSmartHome(newSmartHome);  // save new SmartHome
        System.out.println(colorize("[INFO]", "CYAN") + " SmartHome added successfully!");
    }

    public static SmartHome chooseSmartHome() {
        SmartHome[] smartHouses = loadSaving(); // load all saved SmartHouses
        if (smartHouses == null) { // if there are no saved SmartHouses then return null
            System.out.println(colorize("[INFO]","YELLOW") + " There are no SmartHouses yet!");
            return null;
        }
        System.out.print("\n");
        for (int i = 0; i < smartHouses.length; i++) { // print all saved SmartHouses
            System.out.println("[" + (i + 1) + "] - " + colorize(smartHouses[i].getName(),"CYAN"));
        }
        System.out.println("[0] - Back");

        int choice = getIntValue(smartHouses.length, "Enter the number of the SmartHome");
        if (choice == 0) return null;

        return smartHouses[choice - 1]; // return chosen SmartHome
    }

    public static void deleteSmartHome(){
        do{
            SmartHome curSmartHome = chooseSmartHome(); // print and choose SmartHome
            
            if(curSmartHome == null) return;

            deleteSaving(curSmartHome.getName()); // delete chosen SmartHome if choice != 0
        } while(true);
    
    }
}
