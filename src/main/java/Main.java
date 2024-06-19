import window.MyFrame;
import java.awt.*;

public class Main
{
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            location.ISSlocation.ISSLocation();
            data.PeopleInSpace.HowManyPeopleAreInSpace();
            new MyFrame();
        });
    }
}
