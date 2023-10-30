package com.NeoSlither.Utilities;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class LoopingAudio {
    Clip clip;
    public LoopingAudio() {


    }
    public void playAudio() {


        try {
            // Carica il file audio
            File audioFile = new File("assets/Ambient-chill-Calm-Relax-background-music-for-videos-royalty-free-Audio-No-Copyrights-Music.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Crea una clip audio
            Clip clip = AudioSystem.getClip();

            // Apri il clip con il file audio
            clip.open(audioStream);

            // Imposta il loop infinito
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Riproduci il clip
            clip.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }


}
