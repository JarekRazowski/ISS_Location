package data;

public class SplittingRP {
    public static int splittinResultsPeople(String result)
    {
        String[] parts = result.split("\"number\": ");
        String[] parts2;
        parts2 = parts[1].split(", \"message\":");
        return Integer.parseInt(parts2[0]);
    }
}
