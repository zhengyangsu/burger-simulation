package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BinPatty extends Button {

	// constructor
	public BinPatty(float x, float y, double s) {
		super(x, y, s);

		try {
			img = ImageLoader.loadImage("src/assets/binPatty.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Click and drag patty to flying pan";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}