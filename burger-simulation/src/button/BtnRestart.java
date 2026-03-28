package button;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import main.BurgerPanel;
import util.ImageLoader;

public class BtnRestart extends Button {

	// constructor
	public BtnRestart(float x, float y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/BtnRestart.png");
	}

	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
		g2.setTransform(transform);
	}

	@Override
	public String descriptionInfo() {
		// TODO Auto-generated method stub
		return "Click to restart game";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.END;
	}

}
