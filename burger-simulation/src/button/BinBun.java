package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BinBun extends Button {

	// constructor
	public BinBun(float x, float y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/binBun.png");
		description = "Click and drag bun to wooden board";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
