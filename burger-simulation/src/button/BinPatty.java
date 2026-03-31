package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BinPatty extends Button {

	// constructor
	public BinPatty(float x, float y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/binPatty.png");
		description = "Click and drag patty to flying pan";
	}

@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}