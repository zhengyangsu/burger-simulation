package button;

public class BtnBun extends Button {

	public BtnBun(float x, float y, double s) {
		super(x, y, s);
		movable = true;
		loadImage("src/assets/buns.png");
		description = "Click and drag cheese to bun";
	}

}
