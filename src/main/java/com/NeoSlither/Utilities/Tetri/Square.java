package com.NeoSlither.Utilities.Tetri;

import java.awt.*;

public class Square extends Tetris {
    public Square() {
        create(Color.yellow);
    }
    public void setXY(int x,int y){
        // 0
        // 0
        // 0 0
        b[0].x=x;
        b[0].y=y;
        b[1].x=b[0].x;
        b[1].y=b[0].y+Block.size;
        b[2].x=b[0].x+Block.size;
        b[2].y=b[0].y;
        b[3].x=b[0].x+Block.size;
        b[3].y=b[0].y+Block.size;

    }
    public void getDirection1(){


    }
    public void getDirection2(){


    }
    public void getDirection3(){


    }
    public void getDirection4(){


    }
}
