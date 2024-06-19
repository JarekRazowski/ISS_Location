package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PeopleInSpace
{
    public static int numofpeople;
    public static String wholeCrew;
    public static void HowManyPeopleAreInSpace()
    {
        String file_input = null;
        try {
            String url_adress = "http://api.open-notify.org/astros.json";
            URL url = new URL(url_adress);
            URLConnection conn = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputline;
            while ((inputline = br.readLine()) != null) {
                file_input = inputline;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        numofpeople = SplittingRP.splittinResultsPeople(file_input);
        wholeCrew = CrewInSpace.crewInSpace(file_input);
    }
}
