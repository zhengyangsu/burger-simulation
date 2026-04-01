package button;

import java.awt.Graphics2D;

import util.ImageLoader;

public class BtnBun extends Button implements Ingrident {

	public BtnBun(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		movable = true;
		img = ImageLoader.loadImage("src/assets/buns.png");
		description = "Click and drag cheese to bun";
	}

	@Override
	public void assemble(Button b, Graphics2D g2) {
		 b.drawButton(g2);
		 drawButton(g2);
	}



}
