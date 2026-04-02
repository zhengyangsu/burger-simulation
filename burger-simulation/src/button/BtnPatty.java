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
		// TODO Auto-generated constructor stub
		movable = true;
		state = PattyState.RAW;
		img = ImageLoader.loadImage("src/assets/pattyRaw.png");
	}

	// Override
	public BtnPatty(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		// TODO Auto-generated constructor stub
		state = PattyState.COOKED;
		img = ImageLoader.loadImage("src/assets/pattyCooked.png");
	}

	public void changeState() {
		if (state == PattyState.RAW) {
			state = PattyState.COOKED;
			img = ImageLoader.loadImage("src/assets/pattyCooked.png");
		}
	}

	public boolean isCooked() {
		return state == PattyState.COOKED;
	}

	@Override
	public void decorate(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.decorate(g2);
		drawButton(g2);
	}

}
