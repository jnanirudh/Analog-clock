package anirudhj.analogclock;
import java.util.Calendar;

import javax.swing.*;

public class AnalogClockLauncher {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
//        hour = calendar.get(Calendar.HOUR_OF_DAY);
//        min = calendar.get(Calendar.MINUTE);
//        sec = calendar.get(Calendar.SECOND);

        System.out.println("My Analog clock starting...");

        JFrame frame = new JFrame("clock hand line");
        AnalogClock ac1 = new anirudhj.analogclock.AnalogClock(
                                    calendar.get(Calendar.HOUR_OF_DAY),
                                    calendar.get(Calendar.MINUTE),
                                    calendar.get(Calendar.SECOND));

        //AnalogClock ac1 = new anirudhj.analogclock.AnalogClock(3, 10, 50);

        frame.add(ac1);

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}