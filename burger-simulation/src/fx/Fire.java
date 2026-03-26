package fx;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Fire {

	
	public void drawFire(Graphics2D g2, float x, float y, float d) {
	    AffineTransform at = g2.getTransform();
	    
	    // Introduce small random offsets for position
	    float offsetX = (float) (Math.random() * 10 - 5); // random between -5 and +5
	    float offsetY = (float) (Math.random() * 10 - 5); // random between -5 and +5
	    
	    // Introduce random size variation
	    float scaleVariation = 0.85f + (float)(Math.random() * 0.3f); // 0.85 to 1.15
	    float newD = d * scaleVariation;
	    
	    g2.translate(x + offsetX, y + offsetY);
	    g2.draw(new Ellipse2D.Float(-newD/2, -newD/2, newD, newD));
	    g2.setTransform(at);
	    
	    // Recursive shrink with random factor
	    if (newD > 2) {
	        float nextD = newD * 0.75f * (0.8f + (float)Math.random() * 0.4f); // slightly random shrink
	        drawFire(g2, x, y, nextD);
	    }
	}
	
}
