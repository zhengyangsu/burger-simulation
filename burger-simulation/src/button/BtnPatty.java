package button;

import java.awt.Graphics2D;

import util.ImageLoader;

public class BtnPatty extends Button implements Ingrident {
	enum PattyState {
		RAW, COOKED
	}

	PattyState state;

	public BtnPatty(float x, float y, double s) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		movable = true;
		state = PattyState.RAW;
		img = ImageLoader.loadImage("src/assets/pattyRaw.png");
	}

	@Override
	public void assemble(Button b, Graphics2D g2) {
		b.drawButton(g2);
		drawButton(g2);
	}

	public void changeState() {
		if (state == PattyState.RAW) {
			state = PattyState.COOKED;
			img = ImageLoader.loadImage("src/assets/pattyCooked.png");
		}
	}
	
	public boolean isCooked() {
		return state == PattyState.COOKED;	
	}

}
