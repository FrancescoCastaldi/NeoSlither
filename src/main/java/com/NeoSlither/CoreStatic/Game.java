package com.NeoSlither.CoreStatic;

import com.NeoSlither.Utilities.GameSettings;
import com.NeoSlither.Core.UI.Panel;
import com.NeoSlither.Core.UI.Window;

public class Game {
    private GameSettings settings =new GameSettings();
    private  Panel panel;
    private  Window window;
    public Game() {
        panel = new Panel();
        Window window = new Window(panel);

    }

    public void run(){
      panel.run();
    }
}

