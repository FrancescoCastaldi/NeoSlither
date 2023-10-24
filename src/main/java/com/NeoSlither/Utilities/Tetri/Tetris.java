package com.NeoSlither.Utilities.Tetri;
import java.awt.Color;
import java.awt.*;
import static com.NeoSlither.Core.UI.Panel.dropInterval;

public class Tetris {
    public Block b[]=new Block[4];
    public Block tempB[]=new Block[4];
    int autoDropcounter=0;
    public void create(Color c){
        b[0]=new Block(c);
        b[1]=new Block(c);
        b[2]=new Block(c);
        b[3]=new Block(c);
        tempB[0]=new Block(c);
        tempB[1]=new Block(c);
        tempB[2]=new Block(c);
        tempB[3]=new Block(c);
    }

    public void setXY(int x,int y){

    }
    public void updateXY(int direction){

    }
    public void update(){
        autoDropcounter++;
        if(autoDropcounter==dropInterval){
            b[0].y+= Block.size;
            b[1].y+= Block.size;
            b[2].y+= Block.size;
            b[3].y+= Block.size;
            autoDropcounter=0;

        }
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
