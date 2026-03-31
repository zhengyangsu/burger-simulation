package button;

public class BtnFactory {
	
	public static Button createBtn(String type, float x, float y, double s) {
		switch (type) {
			case "BtnBun":
				return new BtnBunTop(x, y, s);
			case "BtnPatty":
				return new BtnPatty(x, y, s);
			case "BtnCheese":
				return new BtnCheese(x, y, s);
			
			default:
				throw new IllegalArgumentException("Unknown button type: " + type);
		}
	}
}
