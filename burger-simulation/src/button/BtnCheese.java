package button;

import java.awt.Graphics2D;

public class BtnCheese extends IngredientDecorator {

	public BtnCheese(float x, float y, double s) {
		super(x, y, s);
		loadImage("src/assets/cheese.png");
	}

	public BtnCheese(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		loadImage("src/assets/cheese.png");
	}

	@Override
	public void decorate(Graphics2D g2) {
		super.decorate(g2);
		drawButton(g2);
	}

}
