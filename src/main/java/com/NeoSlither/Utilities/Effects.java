package com.NeoSlither.Utilities;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.Clip;
import java.net.MalformedURLException;
import java.net.URL;

public class Effects {
    Clip musicClip;
    URL url[] = new URL[1];

    public Effects()  {


        if (url[0] != null) {
            try {
                File audioFile = new File("/Ambient-chill-Calm-Relax-background-music-for-videos-royalty-free-Audio-No-Copyrights-Music.wav");
                url[0] = audioFile.toURI().toURL();

                AudioInputStream ais = AudioSystem.getAudioInputStream(url[0]);
                musicClip = AudioSystem.getClip();
                musicClip.open(ais);
                ais.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Audio file not found: " + url[0]);
        }
    }

    public void play(int i, boolean test) {
        if (musicClip != null) {
            if (test) {
                musicClip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            musicClip.close();
                        }
                    }
                });
            }
            musicClip.start();
        }
    }

    public void loop() {
        if (musicClip != null) {
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (musicClip != null) {
            musicClip.stop();
            musicClip.close();
        }
    }
}
