package com.NeoSlither.Utilities.Tetri;

import java.awt.*;

public class Bar extends Tetris{
    public Bar(){
        create(Color.blue);

    }
    public void setXY(int x, int y) {
        //
        //    0 0 0 0
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x-Block.size;
        b[1].y = b[0].y;
        b[2].x = b[0].x+Block.size;
        b[2].y = b[0].y;
        b[3].x = b[0].x+Block.size*2;
        b[3].y = b[0].y;
    }
    public void getDirection1(){
        //
        //    0 0 0 0
        tempB[0].x=b[0].x;
        tempB[0].y=b[0].y;
        tempB[1].x=b[0].x-Block.size;
        tempB[1].y=b[0].y;
        tempB[2].x=b[0].x+Block.size;
        tempB[2].y=b[0].y;
        tempB[3].x=b[0].x+Block.size*2;
        tempB[3].y=b[0].y;
        updateXY(1);

    }

    @Override
    public void getDirection2() {
        //       0
        //       0
        //       0
        //       0
        tempB[0].x=b[0].x;
        tempB[0].y=b[0].y;
        tempB[1].x=b[0].x;
        tempB[1].y=b[0].y-Block.size;
        tempB[2].x=b[0].x;
        tempB[2].y=b[0].y+Block.size;
        tempB[3].x=b[0].x;
        tempB[3].y=b[0].y+Block.size*2;
        updateXY(2);
    }
    public void getDirection3(){
        getDirection1();

    }
    public void getDirection4(){
        getDirection2();
    }

}
