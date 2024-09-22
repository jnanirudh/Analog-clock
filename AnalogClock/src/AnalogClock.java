package anirudhj.analogclock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
public class AnalogClock extends JPanel {

    private Timer clockTimer;

    private int currentIdx = 0;

    public AnalogClock () {
        // This starts our clock timer
        clockTimer = new Timer(200, onClockTick);
        clockTimer.setInitialDelay(1000);
        clockTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension mySize = this.getSize();
        Point panelCenter = new Point(mySize.width / 2, mySize.height / 2);

        int radius = Math.min(mySize.width, mySize.height) / 2;
        g.setColor(Color.BLACK);
        g.drawOval(panelCenter.x - radius, panelCenter.y - radius, 2 * radius, 2 * radius);

        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6); // 6 degrees for each minute mark
            int xEnd = (int) (panelCenter.x + radius * Math.cos(angle));
            int yEnd = (int) (panelCenter.y + radius * Math.sin(angle));
            g.setColor(Color.BLACK);
            g.drawLine(panelCenter.x, panelCenter.y, xEnd, yEnd);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            g.setColor(getBackground());
            g.drawLine(panelCenter.x, panelCenter.y, xEnd, yEnd);
        }
    }

    private ActionListener onClockTick = e -> {
        currentIdx++;

        this.repaint();
    };
}
