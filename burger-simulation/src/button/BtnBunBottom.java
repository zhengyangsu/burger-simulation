package button;

import util.ImageLoader;

public class BtnBunBottom extends Button{

	public BtnBunBottom(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		img = ImageLoader.loadImage("src/assets/bunTop.png");
		description = "Bun Bottom, the foundation of any good burger!";
	}


}
