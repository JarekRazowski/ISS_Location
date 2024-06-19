package data;

public class CrewInSpace
{
    public static String crewInSpace(String result)
    {
        String[] names = result.split("\"people\": ");
        String[] names2 = names[1].split(", \"number\":");
        String[] names3 = new String[]{names2[0].replace("\"", "")};
        String[] names4 = new String[]{names3[0].replace("{", "")};
        String[] names5 = new String[]{names4[0].replace("}", "")};
        String[] names6 = new String[]{names5[0].replace("[", "")};
        String[] names7 = new String[]{names6[0].replace("]", "")};
        String[] names8 = new String[]{names7[0].replace("ISS,", "ISS,\n")};
        String[] names9 = new String[]{names8[0].replace("Tiangong,", "Tiangong,\n")};
        return names9[0];
    }
}
