package com.NeoSlither.CoreStatic;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public static boolean leftPressed;
    public static boolean rightPressed;
    public static boolean upPressed;
    public static boolean downPressed;
    public static boolean pausePressed;
    public static boolean spacePressed;

    public boolean anyKeyPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S){
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        // A key is being pressed.
        if (code != KeyEvent.VK_UNDEFINED){
            anyKeyPressed = true;
        }
        if (code == KeyEvent.VK_SPACE) {
            pausePressed = !pausePressed;
            spacePressed = true;
        }


    }

    @Override public void keyReleased (KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        // A key is being pressed.
        if (!upPressed && !downPressed && !leftPressed && !rightPressed){
            anyKeyPressed = false;
        }
    }


}

