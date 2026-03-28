package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.io.File;
import processing.core.PVector;

public class InfoLabel {
	private String text;
	private PVector pos;
	private Font font;

	public InfoLabel(int x, int y) {
		pos = new PVector(x, y);

		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/assets/PixelifySans-VariableFont_wght.ttf"));
			font = font.deriveFont(Font.BOLD, 24);

			// optional: register globally
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);

		} catch (Exception e) {
			e.printStackTrace();
			font = new Font("Arial", Font.BOLD, 16); // fallback
		}
	}

	public void setText(String text) {
		this.text = text;
	}

	public void draw(Graphics2D g) {
		if (text == null)
			return;

		AffineTransform at = g.getTransform();

		g.translate(pos.x, pos.y);
		g.setFont(font);
		g.setColor(new Color(0x21170E));
		g.drawString(text.toUpperCase(java.util.Locale.ROOT), 0, 0);

		g.setTransform(at);
	}
}
