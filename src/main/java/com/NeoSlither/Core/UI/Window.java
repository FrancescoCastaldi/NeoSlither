package com.NeoSlither.Core.UI;
import com.NeoSlither.Utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();

    public Window(Panel gamePanel) {
        this.setTitle(settings.gameTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamePanel);
        this.pack(); //the size of game becomes the size of the window
        this.setSize(settings.screenWidth, settings.screenHeight);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
