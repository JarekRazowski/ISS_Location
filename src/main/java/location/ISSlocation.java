package location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class ISSlocation
{
    public static double ISSVelocity = 0;
    public static void ISSLocation()
    {
        String file_input_1 = null;
        String file_input_2 = null;
        try {
            String url_adress = "http://api.open-notify.org/iss-now.json?callback=CALLBACK";
            URL url = new URL(url_adress);
            URLConnection conn = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputline;
            while ((inputline = br.readLine()) != null) {
                file_input_1 = inputline;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sleep.Sleep.sleep(5000);
        try {
            String url_adress = "http://api.open-notify.org/iss-now.json?callback=CALLBACK";
            URL url = new URL(url_adress);
            URLConnection conn = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputline;
            while ((inputline = br.readLine()) != null) {
                file_input_2 = inputline;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double lat1 = SplittingRL.splittinResultsLatitude(file_input_1);
        double lon1 = SplittingRL.splittinResultsLongitude(file_input_1);

        double lat2 = SplittingRL.splittinResultsLatitude(file_input_2);
        double lon2 = SplittingRL.splittinResultsLongitude(file_input_2);

        ISSVelocity = Distance.getDistance(lat1,lon1, lat2, lon2)/((double) 5 /3600);
    }
}
