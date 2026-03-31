package button;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import main.BurgerPanel;
import processing.core.PVector;

public abstract class Button {
	protected PVector pos;
	protected double scale;
	protected BufferedImage img;
	protected boolean hovered, movable;
	protected String description;

	// constructor
	public Button(float x, float y, double s) {
		pos = new PVector(x, y);
		scale = s;
		movable = false;
		description = "";
	}

	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
		g2.setTransform(transform);
	};

	public String descriptionInfo() {
		return description;
	}

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

	public boolean isMovable() {
		return movable;
	}

	public boolean isVisible(BurgerPanel.State state) {
		return true; // default: visible everywhere
	}
}
