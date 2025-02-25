package com.nostratech.piece;

import com.nostratech.PieceColor;

public class Bishop extends Piece{
    public Bishop(int col, int row, PieceColor color) {
        super(col, row, color);
        if(color == PieceColor.BLACK){
            image = getImage("/b_Bishop.png");
        }else if(color == PieceColor.WHITE){
            image = getImage("/w_Bishop.png");
        }
    }
}
