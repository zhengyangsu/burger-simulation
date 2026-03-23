package main;


import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import processing.core.PVector;


public abstract class Button  {
	protected PVector pos;
	protected double scale;
	protected BufferedImage img;

	// constructor
	public Button(float x, float y,  double s) {
		pos = new PVector(x, y);
		scale = s;
	}
 
	public abstract void drawButton(Graphics2D g2);

	public Rectangle2D getBounds() {
	    double width = img.getWidth() * scale;
	    double height = img.getHeight() * scale;

	    return new Rectangle2D.Double(
	        pos.x - width / 2,
	        pos.y - height / 2,
	        width,
	        height
	    );
	}
	
	public boolean clicked(double x, double y) {
	    return getBounds().contains(x, y);
	}
	
	public void setPos(float x, float y) {
		pos.x = x;
		pos.y = y;
	}
}

