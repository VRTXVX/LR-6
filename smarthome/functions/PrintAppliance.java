package smarthome.functions;

import appliance.Appliance;
import static color.Color.colorize;

public class PrintAppliance {
    public static void printAppliance(Appliance[] appliances) {

        if (appliances.length == 0) {
            System.out.println(colorize("[INFO]","YELLOW") + " There are no appliances in this smart home");
            return;
        }

        System.out.print(getTopTable());

        for(int i = 0; i < appliances.length; i++) {
            System.out.print(getRowTable(i + 1, appliances[i]));
        }

        System.out.println(getBottomTable());
    }

    @SuppressWarnings("SameReturnValue")
    private static String getTopTable(){
        return String.format("""
                                                              %s
                ╔═════╦══════════════╦══════════════╦════════════╦══════════╦═════════════════╦═════════════╦═════════════╗
                ║  #  ║     Name     ║     Mark     ║   Model    ║  Status  ║ Consumed energy ║  Watt-hour  ║  En. class  ║
                ╠═════╬══════════════╬══════════════╬════════════╬══════════╬═════════════════╬═════════════╬═════════════╣
                """,colorize("Appliances","CYAN"));
    }


    @SuppressWarnings("SameReturnValue")
    private static String getBottomTable(){
        return "╚═════╩══════════════╩══════════════╩════════════╩══════════╩═════════════════╩═════════════╩═════════════╝";
    }
    private static String getRowTable(int number, Appliance appliance){
        return String.format("""
                ║ %3d ║%13s ║%13s ║%11s ║    %s   ║ %15s ║ %11s ║ %11s ║
                """, number, appliance.getName(), appliance.getMark(), appliance.getModel(),
                appliance.getStatus() ? colorize("On ","GREEN"): colorize("Off","RED"),
                appliance.getConsumedEnergy(), appliance.getWattHour(), appliance.getPowerConsumptionClass());
    }
}
