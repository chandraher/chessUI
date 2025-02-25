package com.nostratech.piece;

import com.nostratech.PieceColor;

public class Knight extends Piece{
    public Knight(int col, int row, PieceColor color) {
        super(col, row, color);
        if(color == PieceColor.BLACK){
            image = getImage("/b_Knight.png");
        }else if(color == PieceColor.WHITE){
            image = getImage("/w_Knight.png");
        }
    }
}
