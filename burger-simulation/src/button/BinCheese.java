package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BinCheese extends Button {

	// constructor
	public BinCheese(float x, float y, double s) {
		super(x, y, s);

		try {
			img = ImageLoader.loadImage("src/assets/binCheese.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Click and drag cheese to bun";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
