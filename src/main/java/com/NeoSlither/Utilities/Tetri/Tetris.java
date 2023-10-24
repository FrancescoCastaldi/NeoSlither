package com.NeoSlither.Utilities.Tetri;

import java.awt.Color;

import java.awt.*;

public class Tetris {
    public Block b[]=new Block[4];
    public Block tempB[]=new Block[4];
    public void Creation(Color c){
        for(int i=0;i<4;i++){
            b[i]=new Block(c);
        }
        for (int i=0;i<4;i++){
            tempB[i]=new Block(c);
        }
    }

    public void setXY(int x,int y){

    }
    public void updateXY(int direction){

    }
    public void update(){

    }
    public void draw(Graphics2D g2){
        int m=2;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x+m,b[0].y+m,Block.size-m*2,Block.size-m*2);
        g2.fillRect(b[1].x+m,b[1].y+m,Block.size-m*2,Block.size-m*2);
        g2.fillRect(b[2].x+m,b[2].y+m,Block.size-m*2,Block.size-m*2);
        g2.fillRect(b[3].x+m,b[3].y+m,Block.size-m*2,Block.size-m*2);
    }
}
