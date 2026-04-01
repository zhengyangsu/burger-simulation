package button;

import java.awt.Graphics2D;

import util.ImageLoader;

public class BtnBunTop extends Button implements Ingrident {

	public BtnBunTop(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		movable = true;
		img = ImageLoader.loadImage("src/assets/bunTop.png");
		description = "Drag Bun Top to the burger stack.";
	}

	@Override
	public void assemble(Button b, Graphics2D g2) {
		 b.drawButton(g2);
		 drawButton(g2);
	}

}
