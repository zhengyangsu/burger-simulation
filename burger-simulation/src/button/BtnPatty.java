package button;

import java.awt.Graphics2D;

public class BtnPatty extends IngredientDecorator {
	enum PattyState {
		RAW, COOKED
	}

	PattyState state;

	public BtnPatty(float x, float y, double s) {
		super(x, y, s);
		movable = true;
		state = PattyState.RAW;
		loadImage("src/assets/pattyRaw.png");
	}

	public BtnPatty(IngredientDecorator base, float x, float y, double s) {
		super(base, x, y, s);
		state = PattyState.COOKED;
		loadImage("src/assets/pattyCooked.png");
	}

	public void changeState() {
		if (state == PattyState.RAW) {
			state = PattyState.COOKED;
			loadImage("src/assets/pattyCooked.png");
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
