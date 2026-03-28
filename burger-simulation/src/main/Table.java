package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import util.ImageLoader;

public class Table {
	private BufferedImage img;

	public Table(String file) {
		img = ImageLoader.loadImage(file);
	}

	public void drawKitchen(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.drawImage(img, 0, 0, BurgerPanel.W_WIDTH, BurgerPanel.W_HEIGHT, null);
		g2.setTransform(at);
	}

	public void setState(main.BurgerPanel.State s) {
		// TODO Auto-generated method stub

		// currentState = s;
		String intro = "src/assets/Intro.png";
		String play = "src/assets/table.png";
		String end = "src/assets/Outro.png";

		switch (s) {
		case INTRO:
			img = ImageLoader.loadImage(intro);
			break;
		case PLAY:
			img = ImageLoader.loadImage(play);
			break;
		case END:
			img = ImageLoader.loadImage(end);
			break;
		}
	}

}
