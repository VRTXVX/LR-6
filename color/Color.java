package color;

public class Color {
    private final static String BLACK = "\u001B[30m";
    private final static String RED = "\u001B[31m";
    private final static String GREEN = "\u001B[32m";
    private final static String YELLOW = "\u001B[33m";
    private final static String BLUE = "\u001B[34m";
    private final static String PURPLE = "\u001B[35m";
    private final static String CYAN = "\u001B[36m";
    private final static String RESET_COLOR = "\u001B[0m";

    public static String colorize(String string, String color) {
        String[] colorsName = {"BLACK", "RED", "GREEN", "YELLOW", "BLUE", "PURPLE", "CYAN"};
        String[] colorsCode = {BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN};

        for (int i = 0; i < colorsName.length; i++) {
            if (colorsName[i].equals(color)) {
                return colorsCode[i] + string + RESET_COLOR;
            }
        }

        return "Color not found";
    }
}
