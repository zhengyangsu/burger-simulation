package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import javax.swing.Timer;
import button.BinBun;
import button.BinCheese;
import button.BinPatty;
import button.Board;
import button.BtnExit;
import button.BtnRestart;
import button.BtnStart;
import button.Button;
import button.Pan;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import fx.Fire;
import fx.Sizzle;
import processing.core.PVector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.MinimHelper;

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

	private Table table;
	private HashMap<String, Button> staticBtn;
	private boolean binPattyClk, binBunClk, binCheeseClk, panClk, boardClk, pattyDragged;
	private State currentState;
	private Fire fire;

	private JFrame frame;
	private Timer timer;
	private Minim minim;
	private AudioPlayer bkmusic, click, open, close, drag;

	// endregion

	public BurgerPanel(JFrame frame) {

		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
		this.frame = frame;

		currentState = State.INTRO;
		mPos = new PVector();
		table = new Table("src/assets/intro.png");
		staticBtn = new HashMap<>();
		fire = new Fire(300, 365);
		// InfoLabel info = new InfoLabel(0, 0);
		btnPopulate();

		minim = new Minim(new MinimHelper());
		// loadMusic();

		MyMouseListener ml = new MyMouseListener();
		addMouseListener(ml);
		addMouseMotionListener(ml);

		timer = new Timer(30, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		table.drawKitchen(g2);

		switch (currentState) {

		case INTRO:
			displayInfo(g2, 920, 175, table.getInfo());
			drawBtn(g2);
			break;

		case PLAY:
			fire.drawFire(g2, 120, 10);
			drawBtn(g2);
			break;

		case END:
			displayInfo(g2, 120, 175, table.getInfo());
			drawBtn(g2);
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		table.setState(currentState);
		switch (currentState) {
		case INTRO:
			break;

		case PLAY:
			((Pan) staticBtn.get("Pan")).onFire(fire);// Elevate fire
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
		// staticBtn.put("Pan", new Pan(310, 420, 1));
		staticBtn.put("Pan", new Pan(710, 420, 1));
		staticBtn.put("Board", new Board(900, 410, 1));
		staticBtn.put("BtnStart", new BtnStart(1100, 675, 1));
		staticBtn.put("BtnExit", new BtnExit(1100, 675, 1));
		staticBtn.put("BtnRestart", new BtnRestart(1100, 675, 1));

	}

	private void drawBtn(Graphics2D g2) {
		String hoverText = null;

		for (Button b : staticBtn.values()) {

			if (b.isVisible(currentState)) {
				b.drawButton(g2);
				if (b.isHovered()) {
					hoverText = b.descriptionInfo();
				}
			}

		}
		displayInfo(g2, 100, 675, hoverText);
	}

	private void displayInfo(Graphics2D g, int x, int y, String s) {
		InfoLabel info = new InfoLabel(x, y);
		info.setText(s);
		info.draw(g);
	}

	private void loadMusic() {
		bkmusic = minim.loadFile("Mister_X.mp3");
		bkmusic.loop();
	}

	public class MyMouseListener extends MouseAdapter {

		public void mouseMoved(MouseEvent e) {

			mPos.x = e.getX();
			mPos.y = e.getY();

			// chk mouse loc for btn description
			for (Button b : staticBtn.values()) {
				b.setHovered(b.contains(mPos.x, mPos.y));

			}

		}

		public void mouseClicked(MouseEvent e) {
			mPos.x = e.getX();
			mPos.y = e.getY();

			switch (currentState) {

			case INTRO:
				if (staticBtn.get("BtnStart").contains(mPos.x, mPos.y))
					currentState = State.PLAY;
				break;
			case PLAY:
				if (staticBtn.get("BtnExit").contains(mPos.x, mPos.y))
					currentState = State.END;
				break;
			case END:
				if (staticBtn.get("BtnRestart").contains(mPos.x, mPos.y)) {
					frame.dispose();
					new BurgerApp("BurgerApp");
				}

				break;
			}

		}

		public void mousePressed(MouseEvent e) {
			mPos.x = e.getX();
			mPos.y = e.getY();

		}

		public void mouseDragged(MouseEvent e) {
			mPos.x = e.getX();
			mPos.y = e.getY();

			for (Button b : staticBtn.values()) {
				if (b.contains(mPos.x, mPos.y) && b.isMovable())
					b.setPos(mPos.x, mPos.y);
			}

		}

		public void mouseReleased(MouseEvent e) {
			pattyDragged = false;

		}

	}

}
