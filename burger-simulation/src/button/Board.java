package button;

import main.BurgerPanel;
import util.ImageLoader;

public class Board extends Button {

	// constructor
	public Board(float x, float y, double s) {
		super(x, y, s);

		try {
			img = ImageLoader.loadImage("src/assets/board.png");
		} catch (Exception e) {
			System.out.println("Error loading image: " + e.getMessage());
		}

		description = "Assemble your burger";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
