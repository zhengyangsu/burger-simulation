package button;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.BurgerPanel;
import processing.core.PVector;

public abstract class Button {
	protected PVector pos;
	protected double scale;
	protected BufferedImage img;
	protected boolean hovered;

	// constructor
	public Button(float x, float y, double s) {
		pos = new PVector(x, y);
		scale = s;
	}

	public abstract void drawButton(Graphics2D g2);

	public abstract String descriptionInfo();

	public String getName() {
		return getClass().getSimpleName();
	};

	public Rectangle2D getBounds() {
		double width = img.getWidth() * scale;
		double height = img.getHeight() * scale;

		return new Rectangle2D.Double(pos.x - width / 2, pos.y - height / 2, width, height);
	}

	public boolean contains(double x, double y) {
		return getBounds().contains(x, y);
	}

	public void setPos(float x, float y) {
		pos.x = x;
		pos.y = y;
	}

	public void setHovered(boolean h) {
		hovered = h;
	}

	public boolean isHovered() {
		return hovered;
	}

	public boolean isVisible(BurgerPanel.State state) {
		return true; //default: visible everywhere
	}
}
