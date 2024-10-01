package anirudhj.analogclock;
import java.util.Calendar;

import javax.swing.*;

public class AnalogClockLauncher {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("My Analog clock starting...");

        JFrame frame = new JFrame("clock hand line");
        AnalogClock ac1 = new anirudhj.analogclock.AnalogClock(hour, minute, second);

        frame.add(ac1);

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}