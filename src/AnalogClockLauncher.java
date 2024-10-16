package anirudhj.analogclock;
import java.util.Calendar;
import javax.swing.*;
import java.awt.GridLayout; //new addition to control the division of frame

public class AnalogClockLauncher {
    private int hour;
    private int minute;
    private int second;

    //Constructor
    public AnalogClockLauncher() {
        Calendar calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    public static void main(String[] args) {
        System.out.println("My Analog clock starting...");

        JFrame frame = new JFrame("clock hand line");
        frame.setLayout(new GridLayout(1, 2));

//        AnalogClockLauncher launcher = new AnalogClockLauncher();
//        AnalogClock ac1 = new anirudhj.analogclock.AnalogClock(launcher.hour, launcher.minute, launcher.second);

        AnalogClock ac1 = createClockForTimeZone(5, 30);
        AnalogClock ac2 = createClockForTimeZone(-10, 0);

        frame.add(ac1);
        frame.add(ac2);

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static AnalogClock createClockForTimeZone(int hourOffset, int minuteOffset) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hourOffset);
        calendar.add(Calendar.MINUTE, minuteOffset);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return new AnalogClock(hour, minute, second);
    }
}