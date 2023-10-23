package com.NeoSlither.CoreStatic;

import com.NeoSlither.Utilities.GameSettings;
import com.NeoSlither.Core.UI.Panel;
import com.NeoSlither.Core.UI.Window;

import javax.swing.*;

public class Game extends JPanel implements Runnable {
    private final GameSettings settings = new GameSettings();
    double drawInterval = 1000000000.0 / settings.fps;
    public static final int width=1280;
    public static final int height=720;
    private final Panel panel;
    private final Window window;
    private Thread gameThread;
    private long currentTime;
    private double deltaTime;

    private long previous=System.nanoTime();

    public Game() {
        panel = new Panel();
        window = new Window(panel);


    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
    //basic game loop
        while (gameThread != null) {
            currentTime = System.nanoTime();
            deltaTime = (currentTime - previous) / drawInterval;
            previous = currentTime;
            if(deltaTime >= 1) {
                updateGame();
                repaint(); //repaint paints the panel
                deltaTime--;
            }
        }
    }

    private void updateGame() {
        panel.update();
    }

}

