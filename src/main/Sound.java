package main;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//////////////////////////////////////////////////////
// Plays only a small Midi File over and over again //
//////////////////////////////////////////////////////

class Sound {
    public Sound() throws MidiUnavailableException {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(new File("sound.mid")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        
        try {
			sequencer.setSequence(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        sequencer.setLoopStartPoint(0);
        //sequencer.setLoopEndPoint(sequencer.getMicrosecondLength());
        sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
        sequencer.setTempoInBPM(100);
        sequencer.start();
    }
}