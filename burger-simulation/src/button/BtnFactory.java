package button;

public class BtnFactory {

	public static Button createBtn(String type) {
		switch (type) {
		case "BtnBun":
			return new BtnBun(150, 115, 1);
		case "BtnPatty":
			return new BtnPatty(310, 120, 1);
		case "BtnCheese":
			return new BtnCheese(470, 125, 1);
		case "BtnBunTop":
			return new BtnBunTop(900, 125, 1);
		case "BtnBunBottom":
			return new BtnBunBottom(900, 125, 1);

		default:
			throw new IllegalArgumentException("Unknown button type: " + type);
		}
	}
}
