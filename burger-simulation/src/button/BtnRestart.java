package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BtnRestart extends Button {

	// constructor
	public BtnRestart(float x, float y, double s) {
		super(x, y, s);

		try {
			img = ImageLoader.loadImage("src/assets/BtnRestart.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Click to restart game";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.END;
	}

}
