package com.NeoSlither.Core.UI;
import com.NeoSlither.CoreStatic.Game;
import com.NeoSlither.CoreStatic.InputHandler;
import com.NeoSlither.Utilities.Tetri.*;

import javax.swing.*;
import javax.swing.text.html.BlockView;
import java.awt.Graphics2D;

import java.awt.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.NeoSlither.CoreStatic.Game.audio;

public class Panel  {

    public static int left_x;
    public static int right_x;

    public static int top_y;
    public static int bottom_y;
    public static int w = 360;
    public static int h = 600;
    public static boolean gameOver;


    Tetris currentTetris;
    final int TETRIS_START_X;
    final int TETRIS_START_Y;
    Tetris nextTetris;
    final int NEXTETRIS_X;
    final int NEXTETRIS_Y;
    public static ArrayList<Block> staticBlocks=new ArrayList<>();
    public static int dropInterval=60; // 60 fps




    //scores results and level

    int level=1;
    int score;
    int line=0;




    public Panel(){

        left_x= (Game.width/2)- (w/2);
        right_x=left_x + w;
        top_y=50;
        bottom_y=top_y+h;

        TETRIS_START_X=left_x+(w/2)- Block.size;
        TETRIS_START_Y=top_y+Block.size;

        NEXTETRIS_X=right_x+175;
        NEXTETRIS_Y=top_y+500;


        currentTetris=randomTetris();
        currentTetris.setXY(TETRIS_START_X,TETRIS_START_Y);
        nextTetris=randomTetris();
        nextTetris.setXY(NEXTETRIS_X,NEXTETRIS_Y);

    }
    private Tetris randomTetris(){
        Tetris rTetris = null;
        int cnt=new Random().nextInt(7);
        switch (cnt){
            case 0:
                rTetris=new L1();
                break;
            case 1:
                rTetris=new L2();
                break;
            case 2:
                rTetris=new Square();
                break;
            case 3:
                rTetris=new Bar();
                break;
            case 4:
                rTetris=new T();
                break;
            case 5:
                rTetris=new Z1();
                break;
            case 6:
                rTetris=new Z2();
        }
        return rTetris;

    }
    public void update(){
      if(!currentTetris.active){
          staticBlocks.add(currentTetris.b[0]);
          staticBlocks.add(currentTetris.b[1]);
          staticBlocks.add(currentTetris.b[2]);
          staticBlocks.add(currentTetris.b[3]);

          //check gameover
          /*
           * Checks if the current tetris piece is at the starting position.
           * If it is, sets the game over flag to true.
           */
          if(currentTetris.b[0].x==TETRIS_START_X && currentTetris.b[0].y==TETRIS_START_Y){
              gameOver=true;
          }


          currentTetris.off=false;


          //replace currentTetris with nextTetris
          currentTetris = nextTetris;
          currentTetris.setXY(TETRIS_START_X,TETRIS_START_Y);
          nextTetris=randomTetris();
          nextTetris.setXY(NEXTETRIS_X,NEXTETRIS_Y);
          checkDelete();

      }else {
          currentTetris.update();
      }
    }

    private void checkDelete(){
            int x=left_x;
            int y=top_y;
            int blockcnt=0;
            int lcnt=0;
            while(x<right_x&& y < bottom_y){
                for(int i =0;i<staticBlocks.size();i++){
                    if(staticBlocks.get(i).x==x && staticBlocks.get(i).y==y){
                        blockcnt++;
                    }
                }
                x+=Block.size;
                if(x==right_x){
                    //if blockcnt is 12 then delete lines
                    if(blockcnt==12){
                        for(int i= staticBlocks.size()-1;i>-1;i--){
                            if(staticBlocks.get(i).y==y){
                                staticBlocks.remove(i);
                            }
                        }
                        lcnt++;

                        line++;

                        //when hit a certain score number, increase speed
                        if(line % 10 == 0 && dropInterval >1){
                            level++;
                            if(dropInterval>10){
                                dropInterval-=10;
                            }
                            else{
                                dropInterval--;
                            }
                        }

                        for(int i=0;i<staticBlocks.size();i++){
                            if(staticBlocks.get(i).y<y){
                                staticBlocks.get(i).y+=Block.size;
                            }
                        }

                    }

                    blockcnt=0;
                    y+=Block.size;
                    x=left_x;

                }

            }
            if(lcnt>0){
                int slscore=level*10;
                score+=slscore*lcnt;
            }
    }
    public void draw(Graphics2D g2) {

        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, w + 8, h + 8);

        int x = right_x + 100;
        int y = bottom_y - 300;
        g2.drawRect(x, y, 200, 300);
        g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y + 60);


        g2.drawRect(x,top_y+25,225,175);

        x+=40;
        y=top_y+90;
        g2.drawString("Level "+level, x , y ); y+=70;
        g2.drawString("Score "  + score, x , y );

        //draw tetris logo
        // code for drawing the tetris logo goes here
        // Example code for drawing a tetris logo:
        String imagePath = "assets/tetris-logo.png";
        ImageIcon icon = new ImageIcon(imagePath);
        Image image=icon.getImage();
        g2.drawImage(image,left_x-360,top_y+100,300,300,null);



        if (currentTetris != null) {
            currentTetris.draw(g2);
        }
        nextTetris.draw(g2);
        for(int i=0;i<staticBlocks.size();i++){
            staticBlocks.get(i).draw(g2);
        }

            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(150f));
            //autoexit game after 10000ms
            if(gameOver) {
                x=left_x ;
                y=top_y + 320;
                g2.drawString("Game Over", x, y);
                Timer timer=new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                            System.exit(0);

                    }
                },10000);

            }
            if(InputHandler.pausePressed) {

                x = left_x ;
                y = top_y + 320;
                g2.drawString("Paused", x, y);


            }



    }

}
