package button;

import java.awt.Graphics2D;

public class BtnBunTop extends IngredientDecorator {

	public BtnBunTop(float x, float y, double s) {
		super(x, y, s);
		movable = true;
		loadImage("src/assets/bunTop.png");
		description = "Drag Bun Top to the burger stack.";
	}

	public BtnBunTop(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		loadImage("src/assets/bunTop.png");
	}

	@Override
	public void decorate(Graphics2D g2) {
		super.decorate(g2);
		drawButton(g2);
	}

}
