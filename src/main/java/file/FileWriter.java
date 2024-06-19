package file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    public static void WriteFile() throws FileNotFoundException {
        PrintWriter save = new PrintWriter("D:/SDA/Projects/ISSProject/src/main/resources/results.txt");
        save.println("Velocity of ISS is: " + location.ISSlocation.ISSVelocity + " km/h" + "\nThe curvature of the planet was omitted in the calculations due to lack of data.\nThe correct speed is about 28,000 km/h.\n");
        save.println("Number of people on board: " + data.PeopleInSpace.numofpeople + "\n\nCrew: \n" + data.PeopleInSpace.wholeCrew);
        save.close();
    }
}
