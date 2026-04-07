package button;

import java.awt.Graphics2D;

//burger decorator base
public class BtnBunBottom extends IngredientDecorator {

	public BtnBunBottom(float x, float y, double s) {
		super(x, y, s);
		loadImage("src/assets/bunBottom.png");
		description = "Bun, the foundation of any good burger!";
	}

	public BtnBunBottom(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		loadImage("src/assets/bunBottom.png");
	}

	@Override
	public void decorate(Graphics2D g2) {
		drawButton(g2);
	}

}
