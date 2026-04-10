/*
 * This interface is used to represent the ingredients that can be added to the burger.
 *  It has a method called decorate that takes a Graphics2D object as a parameter 
 *  and is used to draw the ingredient on the screen.	
 */

package button;

import java.awt.Graphics2D;

public interface Ingredient {

	public abstract void decorate(Graphics2D g2);
}
