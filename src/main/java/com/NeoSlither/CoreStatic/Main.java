package com.NeoSlither.CoreStatic;


import javax.swing.JFrame;

public class Main  {
    public static void main(String[] args) {

        JFrame window = new JFrame("NeoSlither");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);



        Game gp = new Game();
        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();

    }
}