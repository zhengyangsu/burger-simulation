package button;

import util.ImageLoader;

public class BtnPatty extends Button {
	enum PattyState {
		RAW, COOKED
	}

	PattyState state;

	public BtnPatty(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		state = PattyState.RAW;
		img = ImageLoader.loadImage("src/assets/pattyRaw.png");
	}

	public void changeState() {
		if (state == PattyState.RAW) {
			state = PattyState.COOKED;
			img = ImageLoader.loadImage("src/assets/pattyCooked.png");
		}
	}

}
