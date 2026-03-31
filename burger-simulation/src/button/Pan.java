package button;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import fx.Fire;
import fx.Sizzle;
import main.BurgerPanel;
import processing.core.PVector;
import util.ImageLoader;

public class Pan extends Button {
	Sizzle sizzle;
	boolean onFire;

	// constructor
	public Pan(float x, float y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/pan.png");
		sizzle = new Sizzle(new PVector(x, y - 50));// pan not centered due to handle
		onFire = false;
		movable = true;
		description = "Place it on stove to fly patty";
	}

	@Override
	public void drawButton(Graphics2D g2) {
		super.drawButton(g2);
		if (onFire) {
			sizzle.setPos(pos);
			sizzle.drawSizzle(g2);
		}

	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

	public void onFire(Fire f) {
		onFire = getBounds().intersects(f.getBounds());
	}

}
