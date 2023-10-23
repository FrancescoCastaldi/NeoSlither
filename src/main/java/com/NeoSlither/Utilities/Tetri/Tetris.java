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

    }
}
