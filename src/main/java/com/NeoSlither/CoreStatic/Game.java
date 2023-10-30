package com.NeoSlither.CoreStatic;
import com.NeoSlither.Utilities.LoopingAudio;
import com.NeoSlither.Utilities.GameSettings;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import com.NeoSlither.Core.UI.Panel;
import com.NeoSlither.Utilities.LoopingAudio;

import javax.swing.*;

import java.awt.*;


public class Game extends JPanel implements Runnable {
    public static final int width = 1280;
    public static final int height = 720;

    public static LoopingAudio audio = new LoopingAudio();

    Thread gameThread;
    Panel gamePanel;





    public  Game(){
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.addKeyListener(new InputHandler());
        this.setFocusable(true);
        gamePanel = new Panel();

    }
    public void launchGame(){

        gameThread = new Thread(this);
        gameThread.start();

        audio.playAudio();


    }


    public void run() {
        long lastTime = System.nanoTime();
        double drawInterval = (double) 1000000000 / 60;
        double delta = 0;
        long currentTime;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }

    }
    private void update(){
        if(InputHandler.pausePressed==false && Panel.gameOver==false) {
            gamePanel.update();
        }






    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        gamePanel.draw(g2);
    }
}

