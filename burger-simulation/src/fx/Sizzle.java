/*
 * Sizzle effect on flying pan when place on top of Stove
 * Implemented with Perlin noise
 * 
 * */

package fx;

import static util.Util.radians;
import static util.Util.random;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import processing.core.PApplet;
import processing.core.PVector;

public class Sizzle {
	private PVector pos;
	private float xSeed, ySeed;
	private PApplet pa;

	public Sizzle(PVector pos) {
		xSeed = random(10);
		xSeed = random(10);
		pa = new PApplet();
		this.pos = pos;
	}

	public void drawSizzle(Graphics2D g2) {

		int step = 5; // spacing between particles
		float radius = 100;

		for (float y = -radius; y <= radius; y += step) {
			for (float x = -radius; x <= radius; x += step) {

				xSeed += 0.55;
				ySeed += 0.55;
				float dist = (float) Math.sqrt(x * x + y * y);

				if (dist > radius)
					continue;// skip outside

				float noiseFactor = pa.noise(xSeed, ySeed);

				AffineTransform at = g2.getTransform();
				g2.translate(pos.x + x, pos.y + y);
				g2.rotate(noiseFactor * radians(360));

				// alpha based on distance from center
				float fade = 1.0f - (dist / radius);
				fade = Math.max(fade, 0); // clamp to 0

				float diameter = noiseFactor * 35;
				int alpha = (int) ((150 + noiseFactor * 105) * fade);
				alpha = Math.min(alpha, 255);

				g2.setColor(new Color(253, 222, 189, alpha));
				g2.fill(new Ellipse2D.Float(-diameter / 2, -diameter / 4, diameter, diameter / 2));// local size/coord
				g2.setTransform(at);
			}
		}
	}

	public void setPos(PVector pos) {
		this.pos.x = pos.x;
		this.pos.y = pos.y - 50;
	}
}
