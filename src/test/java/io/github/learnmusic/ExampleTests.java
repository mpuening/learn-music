package io.github.learnmusic;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.ChordProgression;
import org.junit.jupiter.api.Test;

/**
 * Instrument List: https://soundprogramming.net/file-formats/general-midi-instrument-list/
 * 
 * MidiDictionary.class contains the instruments, tempos and controller names
 */
public class ExampleTests {

	@Test
	public void playScales() {
		Player player = new Player();
		player.play("C3 D3 E3 F3 G3 A3 B3 C4 D4 E4 F4 G4 A4 B4 C D E F G A B C6 D6 E6 F6 G6 A6 B6");
	}

	@Test
	public void playMultipleVoicesAndInstruments() {
		Player player = new Player();
		player.play("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq   V1 I[Flute] Rw | Rw | GmajQQQ CmajQ");
	}

	@Test
	public void playPatterns() {
		Pattern p1 = new Pattern("Eq Ch. | Eq Ch. | Dq Eq Dq Cq").setVoice(0).setInstrument("Piano");
		Pattern p2 = new Pattern("Rw     | Rw     | GmajQQQ  CmajQ").setVoice(1).setInstrument("Flute");
		Player player = new Player();
		player.play(p1, p2);
	}

	@Test
	public void playTheBlues() {
		Pattern pattern = new ChordProgression("I IV V").distribute("7%6")
				.allChordsAs("$0 $0 $0 $0 $1 $1 $0 $0 $2 $1 $0 $0")
				.eachChordAs("$0ia100 $1ia80 $2ia80 $3ia80 $4ia100 $3ia80 $2ia80 $1ia80")
				.getPattern()
				.setInstrument("Acoustic_Bass")
				.setTempo(100);
		new Player().play(pattern);
	}

	@Test
	public void playRhythms() {
		Rhythm rhythm = new Rhythm().addLayer("O..oO...O..oOO..")
				.addLayer("..S...S...S...S.")
				.addLayer("````````````````")
				.addLayer("...............+");
		new Player().play(rhythm.getPattern().repeat(2));
	}

	@Test
	public void playSmokeOnTheWater() {
        Player player = new Player();
        player.play("V0 I[Distortion_Guitar] D4q F4q G4q. | D4i Ri F4i Ri Ab4i G4h | D4q F4q G4q. | F4i D4qh.");
	}
	
	@Test
	public void playEspnDaDaDaDaDaDa() {
		int tempo = 300;
		// Treble
		Pattern p1 = new Pattern("r | A6 G6 A6 r | A6 G6 A6 r | r").setVoice(0).setInstrument("Electric_Piano").setTempo(tempo);
		Pattern p2 = new Pattern("r | G5 F5 G5 r | G5 F5 G5 r | r").setVoice(1).setInstrument("Electric_Piano_2").setTempo(tempo);
		// Bass
		Pattern p3 = new Pattern("r | D3 C3 D3 r | D3 C3 D3 r | r").setVoice(2).setInstrument("Synth_Bass_1").setTempo(tempo);
		Player player = new Player();
		player.play(p1, p2, p3);
	}
}
