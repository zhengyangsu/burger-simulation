package button;

import util.ImageLoader;

public class BtnBunTop extends Button{

	public BtnBunTop(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		img = ImageLoader.loadImage("src/assets/bunBottom.png");
		description = "Drag Bun Top to the burger stack.";
	}

}
