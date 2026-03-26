package fx;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Random;

public class AnimatedNoisyCircle extends JPanel {

    Random rand = new Random();
    double baseRotation = 0; // global animation rotation

    public AnimatedNoisyCircle() {
        Timer timer = new Timer(30, e -> {
            baseRotation += 0.05; // slowly rotate over time
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // smoother rendering
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        drawRecursive(g2, 150, 150, 100, baseRotation);
    }

    private void drawRecursive(Graphics2D g2, int cx, int cy, int radius, double rotation) {
        if (radius < 5) return;

        // save transform
        AffineTransform old = g2.getTransform();

        // rotate around center
        g2.rotate(rotation, cx, cy);

        GeneralPath path = new GeneralPath();

        for (int i = 0; i <= 360; i += 16) {
            double angle = Math.toRadians(i);

            int variation = rand.nextInt(radius / 5 + 1) - radius / 10;
            int r = radius + variation;

            double x = cx + r * Math.cos(angle);
            double y = cy + r * Math.sin(angle);

            if (i == 0)
                path.moveTo(x, y);
            else
                path.lineTo(x, y);
        }

        path.closePath();

        //color gradient (red → yellow)
        float t = radius / 100.0f;
        t = Math.max(0, Math.min(1, t));

        int red = 255;
        int green = (int)(255 * (1 - t));

        g2.setColor(new Color(red, green, 0, 120));
        g2.fill(path);

        // restore transform
        g2.setTransform(old);

        // 🎲 random rotation offset per layer
        double nextRotation = rotation + (rand.nextDouble() - 0.5) * 0.5;

        // recursive shrink
        drawRecursive(g2, cx, cy, (int)(radius * 0.8), nextRotation);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fire Blob 🔥");
        frame.add(new AnimatedNoisyCircle());
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
