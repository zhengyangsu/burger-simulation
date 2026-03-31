package button;

import main.BurgerPanel;
import util.ImageLoader;

public class Board extends Button {

	// constructor
	public Board(float x, float y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("src/assets/board.png");
		description = "Assemble your burger";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.PLAY;
	}

}
