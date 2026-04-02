package button;

import util.ImageLoader;

public class BtnBun extends Button {

	public BtnBun(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		movable = true;
		img = ImageLoader.loadImage("src/assets/buns.png");
		description = "Click and drag cheese to bun";
	}

}
