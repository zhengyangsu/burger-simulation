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
import javax.swing.Timer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PVector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.MinimHelper;

@SuppressWarnings("serial")
public class BurgerPanel extends JPanel implements ActionListener {
	public static int W_WIDTH = 1264;
	public static int W_HEIGHT = 843;

	// variables for holding mouse position
	private PVector mousePos;

	// Fields for state and transitions
	private enum State {
		INTRO,
		PLAY,
		END
	};
	private Table table;
	private Button patty;
	private Button bun;
	private boolean pattyDragged;
	
	private Timer timer;
	
	private Minim minim;
	private AudioPlayer bkmusic, click, open, close, drag;

	BurgerPanel(JFrame frame) {
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));

		mousePos = new PVector();
		table = new Table("src/assets/table.png");
		patty = new Patty(W_WIDTH/2, W_HEIGHT/2, 0.25);
		bun = new Bun(W_WIDTH/2, W_HEIGHT/2, 0.25);
		minim = new Minim(new MinimHelper());
		
		loadMusic();
		
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
		patty.drawButton(g2);
		bun.drawButton(g2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
	}

	private void loadMusic() {
		bkmusic = minim.loadFile("Mister_X.mp3");
		bkmusic.loop();
	}
	
	
	
	
	public class MyMouseListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			mousePos.x = e.getX();
			mousePos.y = e.getY();
		}
		
		public void mousePressed(MouseEvent e) {
			mousePos.x = e.getX();
			mousePos.y = e.getY();
			
			if (patty.clicked(mousePos.x, mousePos.y)) pattyDragged = true;
		}
		
		public void mouseDragged(MouseEvent e) {
			mousePos.x = e.getX();
			mousePos.y = e.getY();
			
			if(pattyDragged) {
				patty.setPos(mousePos.x, mousePos.y);
			}
			
		}
		
		public void mouseReleased(MouseEvent e) {
		    pattyDragged = false;

		}
	}

	
	
	
}
