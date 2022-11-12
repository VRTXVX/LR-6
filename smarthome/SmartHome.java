package smarthome;

import java.io.Serializable;
import appliance.*;

import static color.Color.colorize;

public class SmartHome implements Serializable {
    private Appliance[] appliances;
    private String name;

    public SmartHome() {
        appliances = new Appliance[0];
    }


    public boolean isAppliancesEmpty() {
        if(getAppliances().length == 0) {
            System.out.println(colorize("[INFO]", "YELLOW") + " Appliances list is empty");
            return true;
        }
        return false;

    }

    public double getTotalConsumedEnergy() {
        double totalConsumedEnergy = 0;


        for (Appliance appliance : getAppliances()) {
            totalConsumedEnergy += appliance.getConsumedEnergy();
        }
        return totalConsumedEnergy;
    }

    public Appliance[] getAppliances() { return appliances; }

    public void setAppliances(Appliance[] appliances) { this.appliances = appliances; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
