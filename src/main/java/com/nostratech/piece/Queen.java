package com.nostratech.piece;

import com.nostratech.PieceColor;

public class Queen extends Piece{
    public Queen(int col, int row, PieceColor color) {
        super(col, row, color);
        if(color == PieceColor.BLACK){
            image = getImage("/b_Queen.png");
        }else if(color == PieceColor.WHITE){
            image = getImage("/w_Queen.png");
        }
    }
}
