package button;

import util.ImageLoader;

//burger decorator base
public class BtnBunBottom extends Button {

	public BtnBunBottom(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		movable = true;
		img = ImageLoader.loadImage("src/assets/bunBottom.png");
		description = "Bun Bottom, the foundation of any good burger!";
	}

}
