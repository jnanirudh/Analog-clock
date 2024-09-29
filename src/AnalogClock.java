package anirudhj.analogclock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnalogClock extends JPanel {
    private Timer clockTimer;

    private double secondHandAngle = 0;
    private double miniutHandAngle = 0;
    private double hourHandAngle = 0;

    private int i = 45;
    private int startingHour, startingMin, startingSec;
    private Point panelCenter;
    private int radius;

    public AnalogClock (int startingHour, int startingMin, int startingSec) {
        this.startingHour = startingHour;
        this.startingMin = startingMin;
        this.startingSec = startingSec;

        // This starts our clock timer
        clockTimer = new Timer(1000, onClockTick);
        clockTimer.start();

        // Dimension mySize = this.getSize();
        panelCenter = new Point(this.getSize().width / 2, this.getSize().height / 2);
        int radius = Math.min(this.getSize().width, this.getSize().height) / 2;
    }

    private ActionListener onClockTick = e -> {
        System.out.println("Inside onClickTick() at " + new Date());

        double normal = (double) 30 / 3600;
        secondHandAngle = Math.toRadians(i * 6); // 6 degrees for each minute mark
        miniutHandAngle = Math.toRadians((i+2646) * 0.1);
        hourHandAngle = Math.toRadians((i+(270/normal)) * normal);
        i++;

        this.repaint();
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Dimension mySize = this.getSize();
        panelCenter = new Point(this.getSize().width / 2, this.getSize().height / 2);
        int radius = Math.min(this.getSize().width, this.getSize().height) / 2;


        this.drawClockFrame(g2);

        //Seconds Hand
        int xEnd_sec = (int) (panelCenter.x + (radius * 0.9) * Math.cos(secondHandAngle));
        int yEnd_sec = (int) (panelCenter.y + (radius * 0.9) * Math.sin(secondHandAngle));
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(panelCenter.x, panelCenter.y, xEnd_sec, yEnd_sec);

        //Minute Hand
        int xEnd_min = (int) (panelCenter.x + (radius * 0.75) * Math.cos(miniutHandAngle));
        int yEnd_min = (int) (panelCenter.y + (radius * 0.75) * Math.sin(miniutHandAngle));
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(panelCenter.x, panelCenter.y, xEnd_min, yEnd_min);

        //Hour Hand
        int xEnd_hour = (int) (panelCenter.x + (radius * 0.5) * Math.cos(hourHandAngle));
        int yEnd_hour = (int) (panelCenter.y + (radius * 0.5) * Math.sin(hourHandAngle));
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(panelCenter.x, panelCenter.y, xEnd_hour, yEnd_hour);

        for (int hour = 0; hour < 12; hour++) {
            double angle = Math.toRadians((hour * 30) - 90); // 30 degrees for each hour (-90 because it starts form 3)
            int x = (int) (panelCenter.x + (radius * 0.95) * Math.cos(angle));
            int y = (int) (panelCenter.y + (radius * 0.95) * Math.sin(angle));
            g2.fillOval(x - 3, y - 3, 10, 10);
        }
    }

    private void drawClockFrame(Graphics2D g2) {
        // Circle

        g2.setColor(Color.BLACK);
        g2.drawOval(panelCenter.x - radius, panelCenter.y - radius, 2 * radius, 2 * radius);

        // Points
        g2.setColor(Color.BLACK);
        g2.fillOval(panelCenter.x - 5, panelCenter.y - 5, 10, 10);
    }
}
