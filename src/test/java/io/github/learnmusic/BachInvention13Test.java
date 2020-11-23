package io.github.learnmusic;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.junit.jupiter.api.Test;

/**
 * For the love of Commodore computers
 *
 * https://www.mutopiaproject.org/ftp/BachJS/BWV784/bach-invention-13/bach-invention-13-a4.pdf
 *
 * Note: I don't read sheet music very well.
 */
public class BachInvention13Test {

	@Test
	public void playBachInvention13() {
		// 4/4 time means 4 beats (i.e. 4 quarter notes) per measure

		// s == sixteenth note (spans one slot)

		// i == eighth note (spans two slots)

		// q == quarter note (spans four slots)

		// h == half note (spans eight slots)

		// w == whole note (spans sixteen slots)

		String treble = ""

				+ "Rs  E5s A5s C6s B5s E5s B5s D6s C6i     E6i     G5i     E6i     " // 1
				+ "A5s E5s A5s C6s B5s E5s B5s D6s C6i     A5i     Rq              " // 2
				+ "Rs  E6s C6s E6s A5s C6s E5s G5s F5i     A5i     D6i     F6i     " // 3
				+ "F6s D6s B5s D6s G5s B5s D5s F5s E5i     G5i     C6i     E6i     " // 4
				+ "E6s C6s A5s C6s F5i     D6i     D6s B5s G5s B5s E5i     C6i     " // 5
				+ "C6s A5s F5s A5s D6i     B5i     C6i     Ri      Rq              " // 6
				+ "Rs  G5s C6s E6s D6s G5s D6s F6s E6i     G6i     B5i     G6i     "; //7

		String bass = ""

				+ "A3i     A4q             G4i     A4s E4s A4s C5s B4s E4s B4s D5s " // 1
				+ "C5i     A4i     G4i     E4i     A4s E4s A4s C5s B4s E4s B4s D5s " // 2
				+ "C5i     A4i     C5i     A4i     D5s A4s F4s A4s D4s F4s A3s C4s " // 3
				+ "B3i     D4i     G4i     B4i     B4s G4s E4s G4s C4s E4s G3s B3s " // 4
				+ "A3i     C4i     D4s F4s B3s D4s G3i     B3i     C4s E4s A3s C4s " // 5
				+ "F3i     D3i     G3s G4s F4s G4s C4s G4s C5s E5s D5s G4s D5s F5s " // 6
				+ "E5i     C5i     B4i     G4i     C5s G4s C5s E5s D5s G4s D5s F5s "; //7

		String instrument = "Piano";
		int tempo = 76;
		Pattern p1 = new Pattern(treble).setVoice(0).setInstrument(instrument).setTempo(tempo);
		Pattern p2 = new Pattern(bass).setVoice(1).setInstrument(instrument).setTempo(tempo);
		Player player = new Player();
		player.play(p1, p2);
	}
}
