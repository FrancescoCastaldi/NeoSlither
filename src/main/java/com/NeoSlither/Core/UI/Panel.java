package com.NeoSlither.Core.UI;

import com.NeoSlither.Utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    private final GameSettings settings = new GameSettings();
    private Thread gameThread;

    public Panel() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }


    public void start(){
        gameThread = new Thread(this);
        gameThread.start(); // Calls "run" method, in a new thread.
    }



    @Override
    public void run() {
        try {
            Thread.sleep(1000/settings.fps);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();

    }
}
