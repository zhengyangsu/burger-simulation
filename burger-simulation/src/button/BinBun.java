package button;

import main.BurgerPanel;

public class BinBun extends Button {

	// constructor
	public BinBun(float x, float y, double s) {
		super(x, y, s);
		loadImage("src/assets/binBun.png");
		description = "Click and drag bun to wooden board";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
