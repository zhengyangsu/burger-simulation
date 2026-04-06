package button;

import java.awt.Graphics2D;

import util.ImageLoader;

public class BtnPatty extends IngredientDecorator {
	enum PattyState {
		RAW, COOKED
	}

	PattyState state;

	public BtnPatty(float x, float y, double s) {
		super(x, y, s);
		movable = true;
		state = PattyState.RAW;

		try {
			img = ImageLoader.loadImage("src/assets/pattyRaw.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

	}

	// Override
	public BtnPatty(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		state = PattyState.COOKED;

		try {
			img = ImageLoader.loadImage("src/assets/pattyCooked.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

	}

	public void changeState() {
		if (state == PattyState.RAW) {
			state = PattyState.COOKED;

			try {
				if (img == null)
					throw new Exception("Image not loaded: " + getName());
				img = ImageLoader.loadImage("src/assets/pattyCooked.png");
			} catch (Exception e) {
				System.out.println("Error loading image: " + e.getMessage());
			}

		}
	}

	public boolean isCooked() {
		return state == PattyState.COOKED;
	}

	@Override
	public void decorate(Graphics2D g2) {
		super.decorate(g2);
		drawButton(g2);
	}

}
