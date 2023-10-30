package com.NeoSlither.Utilities;

import javax.sound.sampled.*;
import java.net.URL;

public class Effects {
    Clip musicClip;
    URL url[]=new URL[1];
    public Effects(){
        url[0]=getClass().getResource("Ambient-chill-Calm-Relax-background-music-for-videos-royalty-free-Audio-No-Copyrights-Music.wav");

    }
    public void play(int i,boolean loop){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(url[i]);
            Clip clip = AudioSystem.getClip();
            if(loop){
                musicClip=clip;
            }
            clip.open(ais);
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent lineEvent) {
                    if(lineEvent.getType()== LineEvent.Type.STOP){
                        clip.close();
                    }
                }
            });
            ais.close();
            clip.start();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void loop(){
        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        musicClip.stop();
        musicClip.close();
    }
}
