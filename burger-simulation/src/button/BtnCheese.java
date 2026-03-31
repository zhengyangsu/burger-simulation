package button;

import util.ImageLoader;

public class BtnCheese extends Button{

	public BtnCheese(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		img = ImageLoader.loadImage("src/assets/cheese.png");
		description = "Click and drag cheese to bun";
	}


}
