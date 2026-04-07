package sound;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import util.MinimHelper;

public class Player {
	private Minim minim;
	private AudioPlayer bkmusic, click, drag, sizzle, fire;
	private StringBuilder collectedInfo;

	public Player() {
		minim = new Minim(new MinimHelper());
		bkmusic = minim.loadFile("Mister_X.wav");
		click = minim.loadFile("click.wav");
		drag = minim.loadFile("grab.wav");
		sizzle = minim.loadFile("sizzle.wav");
		fire = minim.loadFile("stove.wav");

		// bkmusic.loop();
		// bkmusic.close();
	}
}
