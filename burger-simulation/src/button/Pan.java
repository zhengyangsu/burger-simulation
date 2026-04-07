package button;

import java.awt.Graphics2D;

import fx.Sizzle;
import main.BurgerPanel;
import processing.core.PVector;

public class Pan extends Button {
	Sizzle sizzle;
	BtnPatty patty;
	boolean onFire, pattyReady;
	int sizzleTimer;

	// constructor
	public Pan(float x, float y, double s) {
		super(x, y, s);
		loadImage("src/assets/pan.png");
		sizzle = new Sizzle(new PVector(x, y - 50));// pan not centered due to handle
		sizzleTimer = 0;
		onFire = false;
		pattyReady = false;
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

		if (patty != null) {
			patty.setPos(pos.x, pos.y - 50);
			patty.drawButton(g2);
			sizzleTimer++;
			if (sizzleTimer > 60) { // after 1 second, patty is ready
				pattyReady = true;
				patty.changeState();
			}
		}

	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

	public boolean pattyReady() {
		return pattyReady;
	}

	public void removePatty() {
		patty = null;
		pattyReady = false;
		sizzleTimer = 0;
	}

	public void flyPatty() {
		patty = new BtnPatty(pos.x, pos.y - 50, 1.15);

	}

	public void onFire(Stove s) {
		onFire = (getBounds().intersects(s.getBounds()) && s.isOn());

	}

}
