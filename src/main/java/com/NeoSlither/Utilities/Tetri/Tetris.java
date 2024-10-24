package com.NeoSlither.Utilities.Tetri;

import com.NeoSlither.CoreStatic.InputHandler;

import java.awt.Color;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.NeoSlither.Core.UI.Panel.dropInterval;
import  com.NeoSlither.Core.UI.Panel;

import javax.imageio.ImageIO;


public class Tetris {
    public Block b[]=new Block[4];
    public Block tempB[]=new Block[4];
    public Image image;
    int autoDropCounter =0;
    public int direction=1; //4 directions
    boolean sxCollision;
    boolean dxCollision;
    boolean bottomCollision;
    public boolean active=true;
    public boolean off;
    int offCnt=0;



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
        checkMovementRotationCollision();

        if(sxCollision == false && dxCollision == false && bottomCollision == false) {


            this.direction = direction;
            //tempB useful for handle collision (restore collision)
            b[0].x = tempB[0].x;
            b[0].y = tempB[0].y;
            b[1].x = tempB[1].x;
            b[1].y = tempB[1].y;
            b[2].x = tempB[2].x;
            b[2].y = tempB[2].y;
            b[3].x = tempB[3].x;
            b[3].y = tempB[3].y;
        }


    }
    public void getDirection1(){

    }
    public void getDirection2(){

    }
    public void getDirection3(){

    }
    public void getDirection4(){

    }
    public void checkMovementCollision() {
        sxCollision = false;
        dxCollision = false;
        bottomCollision = false;
        checkStaticBlockCollision();
        //left wall
        for (int iterator = 0;iterator < b.length; iterator++){
            if (b[iterator].x == Panel.left_x) {
                sxCollision = true;
            }
        }
        //right wall
        for (int iterator = 0;iterator < b.length; iterator++){
            if (b[iterator].x+Block.size == Panel.right_x) {
                dxCollision = true;
            }
        }
        //bottom wall
        for(int iterator = 0;iterator < b.length; iterator++){
            if (b[iterator].y+Block.size == Panel.bottom_y) {
                bottomCollision = true;
            }
        }
    }
    public void checkMovementRotationCollision(){
        sxCollision = false;
        dxCollision = false;
        bottomCollision = false;
        checkStaticBlockCollision();
        //left wall
        for (int iterator = 0;iterator < b.length; iterator++){
            if (tempB[iterator].x < Panel.left_x) {
                sxCollision = true;
            }
        }
        //right wall
        for (int iterator = 0;iterator < b.length; iterator++){
            if (tempB[iterator].x+Block.size > Panel.right_x) {
                dxCollision = true;
            }
        }
        //bottom wall
        for(int iterator = 0;iterator < b.length; iterator++){
            if (tempB[iterator].y+Block.size > Panel.bottom_y) {
                bottomCollision = true;
            }
        }




    }
    private void checkStaticBlockCollision(){
        for(int cnt=0;cnt <Panel.staticBlocks.size();cnt++){
            int tX=Panel.staticBlocks.get(cnt).x;
            int tY=Panel.staticBlocks.get(cnt).y;
            //check down
            for(int i=0;i<b.length;i++){
                if(b[i].x==tX && b[i].y+Block.size==tY){

                    bottomCollision=true;
                }
            }
            //check left
            for(int i=0;i<b.length;i++){
                if(b[i].x+Block.size==tX && b[i].y==tY){
                    sxCollision=true;
                }
            }
            //check right
            for(int i=0;i<b.length;i++){
                if(b[i].x+Block.size==tX && b[i].y==tY){
                    dxCollision=true;
                }
            }

        }
    }
    public void update(){
        if(off){
            off();
        }
       if (InputHandler.upPressed){
           switch (direction){
               case 1: getDirection2();break;
               case 2: getDirection3();break;
               case 3: getDirection4();break;
               case 4: getDirection1();break;
           }
           InputHandler.upPressed=false;

       }
       //check if tetris collision wall
       checkMovementCollision();
       if(InputHandler.downPressed) {
           if(bottomCollision==false){
               b[0].y += Block.size;
               b[1].y += Block.size;
               b[2].y += Block.size;
               b[3].y += Block.size;
               autoDropCounter =0;
           }

           InputHandler.downPressed=false;
       }
       if (InputHandler.leftPressed) {
           if(sxCollision==false){
               b[0].x -= Block.size;
               b[1].x -= Block.size;
               b[2].x -= Block.size;
               b[3].x -= Block.size;

           }

           InputHandler.leftPressed=false;
       }
       if (InputHandler.rightPressed) {
           if(dxCollision==false){
               b[0].x += Block.size;
               b[1].x += Block.size;
               b[2].x += Block.size;
               b[3].x += Block.size;

           }

           InputHandler.rightPressed=false;
       }
       if(bottomCollision){
           off=true;
       }else {
           autoDropCounter++;
           if (autoDropCounter == dropInterval) {
               b[0].y += Block.size;
               b[1].y += Block.size;
               b[2].y += Block.size;
               b[3].y += Block.size;
               autoDropCounter = 0;

           }
       }
    }

    private void off() {
        offCnt++;
        //wait 45 frames until off
        if(offCnt==45){
            offCnt=0;
            checkMovementCollision(); //then check if bottom still hitting
        }
        if(bottomCollision){ //if still hitting, so turn off tetris
            active=false;
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
