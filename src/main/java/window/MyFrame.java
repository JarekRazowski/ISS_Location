package window;

import data.PeopleInSpace;
import file.FileWriter;
import location.ISSlocation;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class MyFrame extends JFrame
{
    private static final int x = window.ScreenResolution.getScreenWidthResolution()/2;
    private static final int y = window.ScreenResolution.getScreenHeightResolution()/2;
    public MyFrame()
    {
        setTitle("Current ISS Location");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 540);
        setLocation(x-x/2,y-y/2);
        this.getContentPane().setBackground(new Color(129,172,255));

        final JTextArea text_1 = new JTextArea();
        text_1.setBounds(20,70, 905, 270);
        text_1.setBorder(BorderFactory.createLineBorder(Color.black));
        text_1.setBackground(new Color(181,206,255));
        text_1.setEditable(false);
        add(text_1);

        JScrollPane scroll = new JScrollPane(text_1);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20,70, 905, 270);
        add(scroll);

        final JTextArea text_2 = new JTextArea();
        text_2.setBounds(20,20, 905, 40);
        text_2.setBorder(BorderFactory.createLineBorder(Color.black));
        text_2.setBackground(new Color(181,206,255));
        text_2.setEditable(false);
        text_2.setFont(text_2.getFont().deriveFont(20f));
        add(text_2);

        Button a = new Button("ISS movement");
        a.setBounds(20,360,306,50);
        a.addActionListener(e -> text_1.setText("Velocity of ISS is: " + ISSlocation.ISSVelocity + " km/h" + "\nThe curvature of the planet was omitted in the calculations due to lack of data.\nThe correct speed is about 28,000 km/h."));
        a.addActionListener(e -> text_2.setText("                                                                  Velocity of ISS"));
        a.setBackground(new Color(181,206,255));

        Button b = new Button("List of people on board");
        b.setBounds(632,360,295,50);
        b.addActionListener(e -> text_1.setText("Number of people on board: " + PeopleInSpace.numofpeople + "\n\nCrew: \n" + PeopleInSpace.wholeCrew));
        b.addActionListener(e -> text_2.setText("                                                                  People on ISS"));
        b.setBackground(new Color(181,206,255));

        Button c = new Button("See ISS live");
        c.setBounds(326, 360, 306, 50);
        c.setBackground(new Color(181,206,255));
        c.addActionListener(e -> {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        URI uri = new URI("D:/SDA/Projects/ISSProject/src/main/resources/map.html");
                        desktop.browse(uri.resolve(uri));
                    } catch (IOException | URISyntaxException excp) {
                        excp.printStackTrace();
                    }
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        });

        Button d = new Button("Open saved file");
        d.setBounds(326,410,306,50);
        d.setBackground(new Color(181,206,255));
        d.addActionListener(e -> {
            try {
                Desktop.getDesktop().open(new File("D:/SDA/Projects/ISSProject/src/main/resources/results.txt"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button e = new Button("Save to file");
        e.setBounds(20,410,306,50);
        e.setBackground(new Color(181,206,255));
        e.addActionListener(e1 -> {
            try {
                FileWriter.WriteFile();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button f = new Button("ISS pass times");
        f.setBounds(632,410,295,50);
        f.addActionListener(e1 -> text_1.setText("Due to the lack of data, this information cannot be shown."));
        f.addActionListener(e1 -> text_2.setText("                                                                  ISS pass times"));
        f.setBackground(new Color(181,206,255));

        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);

        ImageIcon img = new ImageIcon("D:/SDA/Projects/ISSProject/src/main/resources/picture_of_application.png");
        setIconImage(img.getImage());
        setResizable(false);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("'Current ISS Location' is closing.");
            }
        });
    }
}
