package button;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import fx.Fire;
import fx.Sizzle;
import main.BurgerPanel;
import processing.core.PVector;
import util.ImageLoader;


public class Pan extends Button{
	Sizzle sizzle;
	boolean onFire;
	
	// constructor
	public Pan(float x, float y,  double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/pan.png");
		sizzle = new Sizzle(new PVector(x, y-50));//pan not centered due to handle
		onFire = false;
	}
 
	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setTransform(transform);
		if (onFire) {
			sizzle.setPos(pos);
			sizzle.drawSizzle(g2);
		}
		
	}

	@Override
	public String descriptionInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
        return state == BurgerPanel.State.PLAY;
    }
	
	public void onFire(Fire f) {
		onFire = getBounds().intersects(f.getBounds());
		System.out.println(onFire);
	}
	
}
