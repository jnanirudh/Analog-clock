package anirudhj.analogclock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnalogClock extends JPanel {
    private Timer clockTimer;

    private double secondHandAngle = 0;
    private int i = 0;
    public AnalogClock () {
        // This starts our clock timer
        clockTimer = new Timer(1000, onClockTick);
        clockTimer.start();
    }

    private ActionListener onClockTick = e -> {
        System.out.println("Inside onClickTick() at " + new Date());

        secondHandAngle = Math.toRadians(i * 6); // 6 degrees for each minute mark

        i++;

        this.repaint();
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension mySize = this.getSize();
        Point panelCenter = new Point(mySize.width / 2, mySize.height / 2);

        int radius = Math.min(mySize.width, mySize.height) / 2;
        g.setColor(Color.BLACK);
        g.drawOval(panelCenter.x - radius, panelCenter.y - radius, 2 * radius, 2 * radius);

        int xEnd = (int) (panelCenter.x + radius * Math.cos(secondHandAngle));
        int yEnd = (int) (panelCenter.y + radius * Math.sin(secondHandAngle));
        g.setColor(Color.BLACK);
        g.drawLine(panelCenter.x, panelCenter.y, xEnd, yEnd);

//            g.setColor(getBackground());
//            g.drawLine(panelCenter.x, panelCenter.y, xEnd, yEnd);
    }
}
