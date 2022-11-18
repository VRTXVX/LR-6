package saving;

import smarthome.SmartHome;
import java.io.*;
import java.nio.file.Path;
import static color.Color.colorize;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Saving {

    final static Path pathToSavingFolder = Path.of(System.getenv("LOCALAPPDATA")).resolve("SmartHomeSaving");
    public static SmartHome[] loadSaving() {

        if (!pathToSavingFolder.toFile().exists())  return null; // check if directory not exist return null

        File[] files = pathToSavingFolder.toFile().listFiles(); // get all files in directory

        if(files == null) return null; // check if directory is empty then return null

        int numberOfFiles = 0;

        for (File file : files) { // count number of files with extension .bin in directory
            if (file.getName().endsWith(".bin")) {
                numberOfFiles++;
            }
        }
        
        if(numberOfFiles == 0) return null; // check if directory is empty then return null
            
        SmartHome[] smartHouses = new SmartHome[numberOfFiles]; // create array of SmartHome with size of number of files .bin

        FileInputStream fileIn;

        int index = 0;

        for(File file : files){
            if(!file.getName().endsWith(".bin")) {// check if file is not .bin then skip it
                continue;
            }

            try {
                fileIn = new FileInputStream(file);
                smartHouses[index] = (SmartHome) new ObjectInputStream(fileIn).readObject();// read object from file and add it to array
                fileIn.close();
                index++;
            } catch (Exception e) {
                System.out.println(colorize("[ERROR]","RED") + "Can't load file " + file.getName());
            }
        }

        return smartHouses;
    }

    public static void saveSmartHome(SmartHome smartHome) {
        String nameSmartHome = smartHome.getName();

        if (nameSmartHome.equals("")) { // check name smart home
            System.out.println("Name of smart home is empty, please enter name of smart home");
            return;
        }

        if (!pathToSavingFolder.toFile().exists()) { // check if directory not exist then create it
            pathToSavingFolder.toFile().mkdir();
        }

        Path pathToNewFile = pathToSavingFolder.resolve(nameSmartHome + ".bin"); // create path to new file

        try {
            File file = new File(pathToNewFile.toString());

            if(!pathToNewFile.toFile().exists()) { // check if file not exist then create it
                file.createNewFile();
            }

            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(smartHome); // write object to file
            objectOut.flush();
            objectOut.close();
        }
        catch (Exception e) {
            System.out.println(colorize("[ERROR]","RED") + "Failed to save smart home");
        }
    }

    public static void deleteSaving(String nameSmartHome) {
        if (nameSmartHome == null || nameSmartHome.equals("")) { // check name smart home
            System.out.println("Name of smart home is empty, please enter name of smart home");
            return;
        }

        File[] files = pathToSavingFolder.toFile().listFiles(); // get all files in directory

        // check if directory is empty then return
        if(files == null) return;  
        else if(files.length == 0) return;

        try {
            for(File file : files){
                if(file.getName().equals(nameSmartHome + ".bin")) {// check if file is .bin and name is equal to nameSmartHome then delete it
                    file.delete();
                    System.out.println(colorize("[INFO]","CYAN") + " Smart home \"" + colorize(nameSmartHome,"CYAN") + "\" deleted successfully!");
                    return;
                }
            }
        }catch (Exception e) {
            System.out.println(colorize("[ERROR]","RED") + "Failed to delete smart home");
        }
    }


}
