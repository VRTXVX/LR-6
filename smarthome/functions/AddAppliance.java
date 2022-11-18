package smarthome.functions;

import appliance.Appliance;
import static color.Color.colorize;
import static saving.Saving.saveSmartHome;
import static service.Service.getCurSmartHome;
import static service.Service.getLine;
import static service.Service.getDoubleValue;

public class AddAppliance {
    public static void addAppliance() {
        Appliance newAppliance = new Appliance();
        Appliance[] curAppliances = getCurSmartHome().getAppliances();

        System.out.println("\n\tEnter information about appliance:\n");

        newAppliance.setName(getLine("Name"));

        newAppliance.setMark(getLine("Mark"));

        newAppliance.setModel(getLine("Model"));

        newAppliance.setWattHour(getDoubleValue("Watt-hour"));

        newAppliance.setPowerConsumptionClass(getLine("Power consumption class"));

        Appliance[] newAppliances = new Appliance[curAppliances.length + 1]; // create new array with one more element

        System.arraycopy(curAppliances, 0, newAppliances, 0, curAppliances.length); // copy old array to new array
        newAppliances[curAppliances.length] = newAppliance; // add new appliance to new array

        getCurSmartHome().setAppliances(newAppliances); // set new array to appliances
        saveSmartHome(getCurSmartHome());// save smart home to file

        System.out.println(colorize("[INFO]","CYAN") + " Appliance successfully added");
    }
}
