package com.nostratech;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    public int x,y;
    public boolean pressed;
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed:");
        x = e.getX();
        y = e.getY();
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released:");
      pressed = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse draggeed:");
        x = e.getX();
        y = e.getY();
    }

//    @Override
//    public void mouseMoved(MouseEvent e) {
//        pressed = true;
//    }
}
