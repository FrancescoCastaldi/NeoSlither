package com.NeoSlither.Core.UI;
import com.NeoSlither.Utilities.GameSettings;
import com.NeoSlither.Utilities.Tetri.Block;
import com.NeoSlither.Utilities.Tetri.L1;
import com.NeoSlither.Utilities.Tetri.Tetris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Panel extends JPanel {
    private final GameSettings settings =new GameSettings();

    public static int left_x;
    public static int right_x;

    public static int top_y;
    public static int bottom_y;
    public static int w = 360;
    public static int h = 600;

    Tetris currentTetris;
    final int TETRIS_START_X;
    final int TETRIS_START_Y;
    public Panel(){

        left_x= (settings.screenWidth/2)- (w/2);
        right_x=left_x + w;
        top_y=50;
        bottom_y=top_y+w;
        this.setBackground(Color.black);
        TETRIS_START_X = left_x + w/2 - Block.size; // start x will be center of play area
        TETRIS_START_Y = top_y +Block.size;
        currentTetris = new L1();
        currentTetris.setXY(TETRIS_START_X, TETRIS_START_Y);

    }
    public void update() {
        currentTetris.update();
    }
   public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //draw area game
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x-4, top_y-4, w+8, h+8);
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x,y,200,200);

        g2.setFont(new Font("Perpetua", Font.BOLD, 30));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("NEXT", x+60, y+60);


        //draw L1
        if(currentTetris != null){
            currentTetris.draw(g2);
        }

        g2.dispose(); //free resources
   }


}
