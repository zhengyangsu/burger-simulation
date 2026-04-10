/*
 * Music and sound effects player for the game.
 */

package sound;

import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
import util.MinimHelper;

public class Player {

	private Minim minim;

	// music
	private AudioPlayer bkmusic, sizzle, fire;

	// fx sounds
	private AudioSample click, released, drag, pan;

	public Player() {
		minim = new Minim(new MinimHelper());

		// music
		bkmusic = minim.loadFile("Mister_X.wav");
		sizzle = minim.loadFile("sizzle.wav");
		fire = minim.loadFile("stove.wav");

		// samples
		click = minim.loadSample("click.wav");
		released = minim.loadSample("released.wav");
		drag = minim.loadSample("grab.wav");
		pan = minim.loadSample("pan.wav");
	}

	public void play(String s) {
		switch (s) {
		case "click":
			click.trigger();
			break;

		case "released":
			released.trigger();
			break;

		case "drag":
			drag.trigger();
			break;

		case "pan":
			pan.trigger();
			break;
		}
	}

	public void loop(String s) {
		switch (s) {
		case "bkmusic":
			if (!bkmusic.isPlaying())
				bkmusic.loop();
			break;

		case "sizzle":
			if (!sizzle.isPlaying())
				sizzle.loop();
			break;

		case "fire":
			if (!fire.isPlaying())
				fire.loop();
			break;
		}
	}

	public void pause(String s) {
		switch (s) {
		case "bkmusic":
			bkmusic.pause();
			break;

		case "sizzle":
			sizzle.pause();
			break;

		case "fire":
			fire.pause();
			break;
		}

	}

	public void rewind(String s) {
		switch (s) {
		case "bkmusic":
			bkmusic.rewind();
			break;

		case "sizzle":
			sizzle.rewind();
			break;

		case "fire":
			fire.rewind();
			break;
		}

	}

	public void stop() {
		minim.stop();
	}
}