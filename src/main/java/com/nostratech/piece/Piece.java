package com.nostratech.piece;

import com.nostratech.Board;
import com.nostratech.PieceColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {
    BufferedImage image;
    public int xPixel;
    public int yPixel;
    public int col;
    public int row;
    public PieceColor color;

    public Piece (int col, int row, PieceColor color) {
        this.col=col;
        this.row=row;
        this.color=color;
        yPixel = getYPixel(color);
        xPixel = getXPixel(color);
    }

    public int getXPixel(PieceColor color){
        return col * Board.SQUARE_SIZE;
    }

    public int getYPixel(PieceColor color){
        return row * Board.SQUARE_SIZE;
    }

    public BufferedImage getImage(String imagePath)  {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image,xPixel,yPixel,Board.SQUARE_SIZE,Board.SQUARE_SIZE,null);
    }

    public void add(Pawn pawn) {
    }
}
