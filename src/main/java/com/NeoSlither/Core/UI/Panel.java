package com.NeoSlither.Core.UI;
import com.NeoSlither.CoreStatic.Game;
import com.NeoSlither.Utilities.Tetri.Block;
import com.NeoSlither.Utilities.Tetri.L1;
import com.NeoSlither.Utilities.Tetri.Tetris;

import javax.swing.text.html.BlockView;
import java.awt.Graphics2D;

import java.awt.*;
import java.awt.Graphics2D;
public class Panel {

    public static int left_x;
    public static int right_x;

    public static int top_y;
    public static int bottom_y;
    public static int w = 360;
    public static int h = 600;

    Tetris currentTetris;
    final int TETRIS_START_X;
    final int TETRIS_START_Y;
    public static int dropInterval=60; // 60 fps
    public Panel(){

        left_x= (Game.width/2)- (w/2);
        right_x=left_x + w;
        top_y=50;
        bottom_y=top_y+h;

        TETRIS_START_X=left_x+(w/2)- Block.size;
        TETRIS_START_Y=top_y+Block.size;


        currentTetris=new L1();
        currentTetris.setXY(TETRIS_START_X,TETRIS_START_Y);


    }
    public void update(){
        currentTetris.update();

    }
    public void draw(Graphics2D g2){

        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x-4,top_y-4,w+8,h+8);

        int x = right_x+100;
        int y=bottom_y-200;
        g2.drawRect(x,y,200,200);
        g2.setFont(new Font("Arial",Font.BOLD,20));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("NEXT", x+60,y+60);

        if(currentTetris!=null){
            currentTetris.draw(g2);
        }

    }



}
