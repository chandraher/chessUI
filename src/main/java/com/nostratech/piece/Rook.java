package com.nostratech.piece;

import com.nostratech.PieceColor;

public class Rook extends Piece{
    public Rook(int col, int row, PieceColor color) {
        super(col, row, color);
        if(color == PieceColor.BLACK){
            image = getImage("/b_Rook.png");
        }else if(color == PieceColor.WHITE){
            image = getImage("/w_Rook.png");
        }
    }
}
