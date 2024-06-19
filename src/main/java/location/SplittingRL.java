package location;

public class SplittingRL
{
    public static double splittinResultsLongitude(String result)
    {
        String[] parts = result.split("longitude\": \"");
        String[] parts2;
        parts2 = parts[1].split("\", \"latitude\":");

        return Double.parseDouble(parts2[0]);
    }
    public static double splittinResultsLatitude(String result)
    {
        String[] parts = result.split("\"latitude\": \"");
        String[] parts2;
        parts2 = parts[1].split("\"}, \"message\":");

        return Double.parseDouble(parts2[0]);
    }
}
