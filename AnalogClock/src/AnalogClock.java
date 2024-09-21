package anirudhj.analogclock;
import javax.swing.*;
import java.awt.*;

public class AnalogClock extends JPanel {
    private Point panelCenter = new Point();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension mySize = this.getSize();
        panelCenter = new Point(mySize.width / 2, mySize.height / 2);

        int radius = Math.min(mySize.width, mySize.height) / 2;
        g.setColor(Color.BLACK);
        g.drawOval(panelCenter.x - radius, panelCenter.y - radius, 2 * radius, 2 * radius);

        // Draw lines from the center to the edge of the circle
        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6); // 6 degrees for each minute mark
            int xEnd = (int) (panelCenter.x + radius * Math.cos(angle));
            int yEnd = (int) (panelCenter.y + radius * Math.sin(angle));
            g.setColor(Color.BLACK);
            g.drawLine(panelCenter.x, panelCenter.y, xEnd, yEnd);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Erase the previous line by drawing it in the background color
            g.setColor(getBackground());
            g.drawLine(panelCenter.x, panelCenter.y, xEnd, yEnd);
        }
    }
}
