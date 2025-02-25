package com.nostratech.piece;

import com.nostratech.PieceColor;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(int col, int row, PieceColor color) {
        super(col, row, color);
        if(color == PieceColor.BLACK) {
            image = getImage("/b_Pawn.png");
        } else if(color == PieceColor.WHITE) {
            image = getImage("/w_Pawn.png");
        }
    }

    // Add the method to check the validity of the pawn move
    public boolean isValidMove(int newCol, int newRow, List<Piece> pieces,int oldx ,int oldy) {

        return true;
    }
}

