package button;

import main.BurgerPanel;
import util.ImageLoader;

public class BinBun extends Button {

	// constructor
	public BinBun(float x, float y, double s) {
		super(x, y, s);

		try {
			img = ImageLoader.loadImage("src/assets/binBun.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Click and drag bun to wooden board";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
