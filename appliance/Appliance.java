package appliance;

import java.io.Serializable;
import static color.Color.colorize;

public class Appliance implements Serializable {
    private String name;
    private String mark;
    private String model;
    private double wattHour;
    private boolean status;
    private double workingHours;
    private String powerConsumptionClass;
    private double lastTimeTurnedOn;

    public Appliance() {
        status = false;
        workingHours = 0;
        lastTimeTurnedOn = 0;
        wattHour = 0;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMark() { return mark; }
    public void setMark(String mark) { this.mark = mark; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getWattHour() { return wattHour; }
    public void setWattHour(double wattHour) { this.wattHour = wattHour; }

    public boolean getStatus() { return status; }
    public void setStatus(boolean status) {
       if(status)
           setLastTimeTurnedOn(System.currentTimeMillis()); // save time when appliance was turned on
       else
           setWorkingHours(getWorkingHours() + (System.currentTimeMillis() - getLastTimeTurnedOn()) / 3600000.0); // add time when appliance was turned on to working hours

        this.status = status;
    }

    public double getWorkingHours() {
        if (getStatus()) // if appliance is turned on then add time from last time turned on to now
            return workingHours + (System.currentTimeMillis() - getLastTimeTurnedOn()) / 3600000.0;

        return workingHours;
    }

    public void setWorkingHours(double workingHours) { this.workingHours = workingHours; }
    public String getPowerConsumptionClass() { return powerConsumptionClass; }
    public void setPowerConsumptionClass(String powerConsumptionClass) { this.powerConsumptionClass = powerConsumptionClass; }
    public double getConsumedEnergy() { return wattHour * getWorkingHours(); }
    private void setLastTimeTurnedOn(double lastTimeTurnedOn) { this.lastTimeTurnedOn = lastTimeTurnedOn; }
    private double getLastTimeTurnedOn() { return lastTimeTurnedOn; }


    @Override
    public String toString() { return name + " " + mark + model + " " + wattHour + " "
            + colorize(status ? "On" : "Off",status ? "GREEN" : "RED")  + " " +
            workingHours + " " + powerConsumptionClass + " " + getConsumedEnergy();
    }
}
