package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BtnExit extends Button {

	// constructor
	public BtnExit(float x, float y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/BtnExit.png");
		description = "Click to end game";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
