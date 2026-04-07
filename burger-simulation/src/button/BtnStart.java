package button;

import main.BurgerPanel;

public class BtnStart extends Button {

	// constructor
	public BtnStart(float x, float y, double s) {
		super(x, y, s);
		loadImage("src/assets/BtnStart.png");
		description = "Click to start game";
	}

	@Override
	public boolean isVisible(BurgerPanel.State state) {
		return state == BurgerPanel.State.INTRO;
	}

}
