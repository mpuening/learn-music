package io.github.learnmusic;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.junit.jupiter.api.Test;

/**
 * I was hoping for something like the Hershey Kisses (no bass)
 */
public class WeWishYouAMerryChristmasTest {

	@Test
	public void playWeWishYouAMerryChristmas() {
		// 3/4 time means 3 beats (i.e. 3 quarter notes) per measure (a waltz)

		// i == eighth note (spans one slot)

		// q == quarter note (spans two slots)
		
		String treble = ""

				+ "C5q    " // intro
				+ "F5q     F5i G5i F5i E5i " // 1
				+ "D5q     D5q     D5q     " // 2
				+ "G5q     G5i A5i G5i F5i " // 3
				+ "E5q     E5q     E5q     " // 4
				+ "A5q     A5i B5i A5i G5i " // 5
				+ "F5q     D5q     C5i C5i " // 6
				+ "D5q     G5q     E5q     " // 7
				+ "F5h             C5q     " // 8
				+ "F5q     F5q     F5q     " // 9
				+ "E5h             E5q     " // 10
				+ "F5q     E5q     D5q     " // 11
				+ "C5h             G5q     " // 12
				+ "A5q     G5i G5i F5i F5i " // 13
				+ "C6q     C5q     C5i C5i " // 14
				+ "D5q     G5q     E5q     " // 15
				+ "F5w                     "; // 16


		String instrument = "STEEL_DRUMS";
		int tempo = 140;
		Pattern p1 = new Pattern(treble).setVoice(0).setInstrument(instrument).setTempo(tempo);
		Player player = new Player();
		player.play(p1);
	}
}
