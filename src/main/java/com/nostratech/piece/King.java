package com.nostratech.piece;

import com.nostratech.PieceColor;

public class King extends Piece{
    public King(int col, int row, PieceColor color) {
        super(col, row, color);
        if(color == PieceColor.BLACK){
            image = getImage("/b_King.png");
        }else if(color == PieceColor.WHITE){
            image = getImage("/w_King.png");
        }
    }
}
