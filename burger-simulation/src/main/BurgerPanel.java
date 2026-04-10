/* burgerPanel.java
 * hosting all the components, including buttons, fire fx, and burger ingredients generation
 * handles all the interactions and state transitions of the game
 * 
 * ECOs
 * complex shape with recursion for fire fx
 * decorator pattern for burger ingredients
 * FSM for game states
 * factory pattern for buttons
 */

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import button.BinBun;
import button.BinCheese;
import button.BinPatty;
import button.Board;
import button.BtnExit;
import button.BtnFactory;
import button.BtnPatty;
import button.BtnRestart;
import button.BtnStart;
import button.Button;
import button.Ingredient;
import button.IngredientDecorator;
import button.Pan;
import button.Stove;
import processing.core.PVector;
import sound.Player;

@SuppressWarnings("serial")
public class BurgerPanel extends JPanel implements ActionListener {

	// region
	public static int W_WIDTH = 1280;
	public static int W_HEIGHT = 720;

	// variables for holding mouse position
	private PVector mPos;

	// Fields for state and transitions
	public enum State {
		INTRO, PLAY, END
	};

	private State currentState;

	private Table table;
	private HashMap<String, Button> staticBtn;
	private Button btnDragged;
	private Ingredient burger;
	private Player player;
	private int counter;
	private boolean completed;
	private JFrame frame;
	private Timer timer;
	private StringBuilder collectedInfo;

	// endregion

	public BurgerPanel(JFrame frame) {

		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
		this.frame = frame;

		currentState = State.INTRO;
		collectedInfo = new StringBuilder();
		mPos = new PVector();
		table = new Table("src/assets/intro.png");
		staticBtn = new HashMap<>();
		player = new Player();
		counter = 0;
		completed = false;
		timer = new Timer(30, this);
		MyMouseListener ml = new MyMouseListener();

		btnPopulate();

		addMouseListener(ml);
		addMouseMotionListener(ml);

		timer.start();
		player.loop("bkmusic");

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// collectedInfo.setLength(0); // Clear collected info
		table.drawKitchen(g2);

		switch (currentState) {

		case INTRO:
			displayInfo(g2, 920, 175, table.getInfo());
			drawBtn(g2);
			break;

		case PLAY:
			drawBtn(g2); // Draw all buttons except Pan (includes stove area)
			drawPanOnTop(g2); // Draw Pan on top of fire

			if (btnDragged != null) {
				btnDragged.drawButton(g2);
			}

			if (burger != null) {
				burger.decorate(g2);
			}

			if (completed) {
				counter++;
				if (counter > 60) { // after 1 second, move to end screen
					currentState = State.END;
					counter = 0;
				}
			}
			break;

		case END:
			displayInfo(g2, 120, 175, table.getInfo());
			drawBtn(g2);
			break;
		}
		displayInfo(g2, 100, 675, collectedInfo.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		table.setState(currentState);
		switch (currentState) {
		case INTRO:
			break;

		case PLAY:
			((Pan) staticBtn.get("Pan")).onFire((Stove) staticBtn.get("Stove"));// Elevate fire
			break;

		case END:
			break;
		}

		repaint();
	}

	private void btnPopulate() {

		staticBtn.put("BinBun", new BinBun(150, 115, 1));
		staticBtn.put("BinPatty", new BinPatty(310, 120, 1));
		staticBtn.put("BinCheese", new BinCheese(470, 125, 1));
		staticBtn.put("Board", new Board(900, 410, 1));
		staticBtn.put("Stove", new Stove(340, 400, 1));
		staticBtn.put("Pan", new Pan(710, 420, 1));
		staticBtn.put("BtnStart", new BtnStart(1100, 675, 1));
		staticBtn.put("BtnExit", new BtnExit(1100, 675, 1));
		staticBtn.put("BtnRestart", new BtnRestart(1100, 675, 1));

	}

	private void drawBtn(Graphics2D g2) {

		for (Button b : staticBtn.values()) {

			if (b.isVisible(currentState) && !(b instanceof Pan)) {
				b.drawButton(g2);
			}
		}

	}

	private void drawPanOnTop(Graphics2D g2) {
		Button panBtn = staticBtn.get("Pan");
		if (panBtn != null && panBtn.isVisible(currentState)) {
			panBtn.drawButton(g2);
		}
	}

	private void collectInfo(String s) {
		collectedInfo.append(s).append(System.lineSeparator());
	}

	private void displayInfo(Graphics2D g, int x, int y, String s) {
		InfoLabel info = new InfoLabel(x, y);
		info.setText(s);
		info.draw(g);
	}

	public class MyMouseListener extends MouseAdapter {

		public void mouseMoved(MouseEvent e) {

			mPos.x = e.getX();
			mPos.y = e.getY();

			collectedInfo.setLength(0);
			Button hoveredBtn = null;

			// Check Pan first (drawn last, so it's on top)
			Button panBtn = staticBtn.get("Pan");
			if (panBtn != null && panBtn.isVisible(currentState) && panBtn.contains(mPos.x, mPos.y)) {
				hoveredBtn = panBtn;
			}
			// If not hovering Pan, check other buttons
			else {
				for (Button b : staticBtn.values()) {
					if (!(b instanceof Pan) && b.isVisible(currentState) && b.contains(mPos.x, mPos.y)) {
						hoveredBtn = b;
						break; // Found the topmost button, stop searching
					}
				}
			}

			// Update hover state for all buttons
			for (Button b : staticBtn.values()) {
				b.setHovered(b == hoveredBtn);
				if (b.isHovered()) {
					collectInfo(b.descriptionInfo());
				}
			}

		}

		public void mouseClicked(MouseEvent e) {
			mPos.x = e.getX();
			mPos.y = e.getY();

			player.play("click");

			switch (currentState) {

			case INTRO:
				if (staticBtn.get("BtnStart").contains(mPos.x, mPos.y)) {
					currentState = State.PLAY;
				}
				break;

			case PLAY:
				if (staticBtn.get("BtnExit").contains(mPos.x, mPos.y)) {
					currentState = State.END;
				}

				else if (staticBtn.get("Stove").contains(mPos.x, mPos.y)) {
					((Stove) staticBtn.get("Stove")).toggle();

					if (((Stove) staticBtn.get("Stove")).isOn())
						player.loop("fire");

					else {
						player.pause("fire");
						player.rewind("fire");
					}

				}
				break;

			case END:
				if (staticBtn.get("BtnRestart").contains(mPos.x, mPos.y)) {
					frame.dispose();
					player.stop();
					new BurgerApp("BurgerApp");
				}
				break;
			}

		}

		public void mousePressed(MouseEvent e) {
			mPos.x = e.getX();
			mPos.y = e.getY();
			player.play("drag");

			for (Button b : staticBtn.values()) {
				if (b.contains(mPos.x, mPos.y)) {

					switch (b.getName()) {
					case "BinPatty":
						btnDragged = BtnFactory.createBtn("BtnPatty");
						break;
					case "BinBun":
						btnDragged = BtnFactory.createBtn("BtnBun");
						break;
					case "BinCheese":
						btnDragged = BtnFactory.createBtn("BtnCheese");
						break;
					case "Pan":
						if (((Pan) b).pattyReady()) {
							((Pan) b).removePatty();
							btnDragged = BtnFactory.createBtn("BtnPatty");
							((BtnPatty) btnDragged).changeState();
						}
						break;
					}
				}
			}

		}

		public void mouseDragged(MouseEvent e) {
			mPos.x = e.getX();
			mPos.y = e.getY();

			if (btnDragged != null) {
				btnDragged.setPos(mPos.x, mPos.y);
			}

			else
				for (Button b : staticBtn.values()) {
					if (b.contains(mPos.x, mPos.y) && b.isMovable())
						b.setPos(mPos.x, mPos.y);
				}

		}

		public void mouseReleased(MouseEvent e) {

			mPos.x = e.getX();
			mPos.y = e.getY();

			player.play("released");

			if (btnDragged != null) {

				if (staticBtn.get("Pan").contains(mPos.x, mPos.y) && btnDragged.getName().equals("BtnPatty")) {

					((Pan) staticBtn.get("Pan")).flyPatty();
					player.play("pan");
				}

				else if (staticBtn.get("Board").contains(mPos.x, mPos.y)) {

					switch (btnDragged.getName()) {

					case "BtnBun":
						if (burger == null)
							burger = BtnFactory.createBurger("IngrBunBottom", null);
						else {
							burger = BtnFactory.createBurger("IngrBunTop", (IngredientDecorator) burger);
							completed = true;
						}

						break;
					case "BtnPatty":
						if (((BtnPatty) btnDragged).isCooked()) {
							burger = BtnFactory.createBurger("IngrPatty", (IngredientDecorator) burger);
						}

						break;
					case "BtnCheese":
						burger = BtnFactory.createBurger("IngrCheese", (IngredientDecorator) burger);
						break;
					}

				}

			}

			btnDragged = null; // release
		}

	}

}
