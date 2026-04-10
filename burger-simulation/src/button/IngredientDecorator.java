/*
 * IngredientDecorator.java
 * 
 */

package button;

import java.awt.Graphics2D;

public abstract class IngredientDecorator extends Button implements Ingredient {
	protected Ingredient base;

	// constructor
	public IngredientDecorator(float x, float y, double s) {
		super(x, y, s);
	}

	// Override
	public IngredientDecorator(Ingredient _base, float x, float y, double s) {
		super(x, y, s);
		base = _base;

	}

	@Override
	public void decorate(Graphics2D g2) {
		if (base != null)
			base.decorate(g2);
	}

}
