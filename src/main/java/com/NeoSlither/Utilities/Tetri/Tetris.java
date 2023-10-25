package com.NeoSlither.Utilities.Tetri;

import com.NeoSlither.CoreStatic.InputHandler;

import java.awt.Color;
import java.awt.*;
import static com.NeoSlither.Core.UI.Panel.dropInterval;

public class Tetris {
    public Block b[]=new Block[4];
    public Block tempB[]=new Block[4];
    int autoDropCounter =0;
    public int direction=1; //4 directions


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
       this.direction=direction;
       //tempB useful for handle collision (restore collision)
       b[0].x=tempB[0].x;
       b[0].y=tempB[0].y;
       b[1].x=tempB[1].x;
       b[1].y=tempB[1].y;
       b[2].x=tempB[2].x;
       b[2].y=tempB[2].y;
       b[3].x=tempB[3].x;
       b[3].y=tempB[3].y;


    }
    public void getDirection1(){

    }
    public void getDirection2(){

    }
    public void getDirection3(){

    }
    public void getDirection4(){

    }
    public void update(){
       if (InputHandler.upPressed){
           switch (direction){
               case 1: getDirection2();break;
               case 2: getDirection3();break;
               case 3: getDirection4();break;
               case 4: getDirection1();break;
           }
           InputHandler.upPressed=false;

       }
       if(InputHandler.downPressed) {
           b[0].y += Block.size;
           b[1].y += Block.size;
           b[2].y += Block.size;
           b[3].y += Block.size;
           autoDropCounter =0;
           InputHandler.downPressed=false;
       }
       if (InputHandler.leftPressed) {
           b[0].x -= Block.size;
           b[1].x -= Block.size;
           b[2].x -= Block.size;
           b[3].x -= Block.size;
           InputHandler.leftPressed=false;
       }
       if (InputHandler.rightPressed) {
           b[0].x += Block.size;
           b[1].x += Block.size;
           b[2].x += Block.size;
           b[3].x += Block.size;
           InputHandler.rightPressed=false;
       }
        autoDropCounter++;
        if(autoDropCounter ==dropInterval){
            b[0].y+= Block.size;
            b[1].y+= Block.size;
            b[2].y+= Block.size;
            b[3].y+= Block.size;
            autoDropCounter =0;

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
