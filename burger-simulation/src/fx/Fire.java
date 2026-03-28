package fx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Fire {

	private Random rand = new Random();
	private int cx, cy;
	private Area fA;

	
	public Fire(int x, int y) {
		cx = x;
		cy = y;
		fA = new Area();

	}
	

	public void drawFire(Graphics2D g2, int r, double rot) {
		
		int radius = r;
		if (radius < 5)
			return;

		AffineTransform old = g2.getTransform();

		//rotate around center
		g2.rotate(rot, cx, cy);

		GeneralPath path = new GeneralPath();

		for (int i = 0; i <= 360; i += 16) {
			double angle = Math.toRadians(i);

			int variation = rand.nextInt(radius/2 + 1) - radius/10;//jagged edge
			int rVar = radius + variation;

			double x = cx + rVar * Math.cos(angle);
			double y = cy + rVar * Math.sin(angle);

			if (i == 0)
				path.moveTo(x, y);
			else
				path.lineTo(x, y);
		}

		path.closePath();

		//color gradient
		float t = radius / 100.0f;
		t = Math.max(0, Math.min(1, t)); //clamp between 0 to 1
		t = (float)Math.pow(t,3);
		int red = 255;
		int green = (int) (255 * (1 - t));

		g2.setColor(new Color(red, green, 0, 120));
		g2.fill(path);
		
		if (fA.isEmpty()) fA.add(new Area(path));
		
		g2.setTransform(old);

		double nextRot = rot + (rand.nextDouble() - 0.5) * 0.5;

		//recursion with shrink
		drawFire(g2, (int) (radius * 0.8), nextRot);
	}

	public Rectangle2D getBounds() {
		return fA.getBounds2D();
	}
	
}
