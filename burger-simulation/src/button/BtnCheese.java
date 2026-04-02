package button;

import java.awt.Graphics2D;

import util.ImageLoader;

public class BtnCheese extends IngredientDecorator {

	public BtnCheese(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		img = ImageLoader.loadImage("src/assets/cheese.png");
	}

	// Override
	public BtnCheese(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		img = ImageLoader.loadImage("src/assets/cheese.png");
	}

	@Override
	public void decorate(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.decorate(g2);
		drawButton(g2);
	}

}
