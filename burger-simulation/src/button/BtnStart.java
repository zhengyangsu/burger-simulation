package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BtnStart extends Button {

	// constructor
	public BtnStart(float x, float y, double s) {
		super(x, y, s);

		try {
			img = ImageLoader.loadImage("src/assets/BtnStart.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Click to start game";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.INTRO;
	}

}
