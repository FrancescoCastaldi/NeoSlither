package com.NeoSlither.Core.UI;
import com.NeoSlither.Utilities.GameSettings;

import javax.swing.*;

public class Window extends JFrame {
    private final GameSettings settings = new GameSettings();

    public Window(Panel gamePanel) {
        this.setTitle(settings.gameTitle);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.add(gamePanel);
        this.pack();
        this.setSize(settings.screenWidth, settings.screenHeight);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        gamePanel.start();

    }
}
