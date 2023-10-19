package com.NeoSlither;

public class Game {
    private gamePanel panel;
    public Game() {
        panel = new gamePanel();
        panel.start();

    }

        public void start() {
            window.run();

        }
    }
}
