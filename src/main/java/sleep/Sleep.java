package sleep;

import java.util.Calendar;

public class Sleep
{
    public static void sleep(long sleep_duration)
    {
        long time_now = Calendar.getInstance().getTime().getTime() + sleep_duration;
        while(Calendar.getInstance().getTime().getTime() < time_now){}
    }
}
