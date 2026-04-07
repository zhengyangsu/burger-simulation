package button;

import java.awt.Graphics2D;

import fx.Fire;
import main.BurgerPanel;

public class Stove extends Button {

	boolean on;
	Fire fire;

	// constructor
	public Stove(float x, float y, double s) {
		super(x, y, s);
		loadImage("src/assets/stove.png");
		on = false;
		fire = new Fire(300, 365);
		description = "Click to turn on and off fire";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

	@Override
	public void drawButton(Graphics2D g2) {
		super.drawButton(g2);
		if (on) {
			fire.drawFire(g2, 120, 10);
		}

	}

	public void toggle() {
		on = !on;
	}

	public boolean isOn() {
		return on;
	}

}
