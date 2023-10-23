package com.NeoSlither.Utilities.Tetri;

import java.awt.*;

public class Block extends Rectangle {
    public int x, y;

    public static final int size = 30; //size of the block 30x30
    public Color c;

    public Block(Color c) {

        this.c = c;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(c);
        g2.fillRect(x, y, size, size);
    }



}
