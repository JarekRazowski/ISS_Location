package window;

import java.awt.*;

public class ScreenResolution {
    public static int getScreenWidthResolution()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int)screenSize.getWidth();
    }
    public static int getScreenHeightResolution()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int)screenSize.getHeight();
    }
    public static String getScreenRatio()
    {
        int a = getScreenWidthResolution()/gcd(getScreenWidthResolution(), getScreenHeightResolution());
        int b = getScreenHeightResolution()/gcd(getScreenWidthResolution(),getScreenHeightResolution());
        return a + ":" + b;
    }
    public static int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        else
        {
            return gcd(b, Math.abs(a-b));
        }
    }
}
