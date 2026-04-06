package button;

import java.awt.Graphics2D;

import util.ImageLoader;

//burger decorator base
public class BtnBunBottom extends IngredientDecorator {

	public BtnBunBottom(float x, float y, double s) {
		super(x, y, s);
		try {
			img = ImageLoader.loadImage("src/assets/bunBottom.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Bun, the foundation of any good burger!";
	}

	// Override
	public BtnBunBottom(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		try {
			img = ImageLoader.loadImage("src/assets/bunBottom.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

	}

	@Override
	public void decorate(Graphics2D g2) {
		drawButton(g2);
	}

}
