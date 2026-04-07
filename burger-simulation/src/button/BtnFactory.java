/*
 * code factory for creating buttons and burger ingredients
 */

package button;

public class BtnFactory {

	public static Button createBtn(String type) {
		switch (type) {
		case "BtnBun":
			return new BtnBun(150, 115, 1.15);
		case "BtnPatty":
			return new BtnPatty(310, 120, 1.15);
		case "BtnCheese":
			return new BtnCheese(470, 125, 1.15);

		default:
			throw new IllegalArgumentException("Unknown button type: " + type);
		}
	}

	public static Ingredient createBurger(String type, IngredientDecorator base) {
		switch (type) {

		case "IngrBunTop":
			return new BtnBunTop(base, 845, 355, 1.15);
		case "IngrBunBottom":
			return new BtnBunBottom(base, 845, 425, 1.15);
		case "IngrPatty":
			return new BtnPatty(base, 845, 395, 1.15);
		case "IngrCheese":
			return new BtnCheese(base, 845, 380, 1.15);

		default:
			throw new IllegalArgumentException("Unknown button type: " + type);
		}
	}
}
