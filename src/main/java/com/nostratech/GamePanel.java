package com.nostratech;

import com.nostratech.piece.*;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable{

    public static final int BOARD_WIDTH = 1100;
    public static final int BOARD_HEIGHT = 800;
    public static int FPS = 60;
    Thread gameThread;
    Board board;
    List<Piece> pieces = new ArrayList<>();
    MouseListener mouseListener;
    Piece activePiece;

    public GamePanel(){
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.WHITE);
        board = new Board();
        setPieces();
        mouseListener = new MouseListener();
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);

    }

    private void setPieces(){
        for(int i = 0 ; i <=7 ; i++){
            pieces.add(new Pawn(i,1,PieceColor.WHITE));
            pieces.add(new Pawn(i,6,PieceColor.BLACK));
        }
        pieces.add(new Bishop(2,0,PieceColor.WHITE));
        pieces.add(new Bishop(5,0,PieceColor.WHITE));
        pieces.add(new Bishop(2,7,PieceColor.BLACK));
        pieces.add(new Bishop(5,7,PieceColor.BLACK));

        pieces.add(new Knight(1,0,PieceColor.WHITE));
        pieces.add(new Knight(6,0,PieceColor.WHITE));
        pieces.add(new Knight(1,7,PieceColor.BLACK));
        pieces.add(new Knight(6,7,PieceColor.BLACK));

        pieces.add(new Rook(0,0,PieceColor.WHITE));
        pieces.add(new Rook(7,0,PieceColor.WHITE));
        pieces.add(new Rook(0,7,PieceColor.BLACK));
        pieces.add(new Rook(7,7,PieceColor.BLACK));

        pieces.add(new Queen(4,0,PieceColor.WHITE));
        pieces.add(new Queen(4,7,PieceColor.BLACK));

        pieces.add(new King(3,0,PieceColor.WHITE));
        pieces.add(new King(3,7,PieceColor.BLACK));


    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    //update informasi
    public void update(){
        if(mouseListener.pressed) {
            if (activePiece == null) {
                for (Piece piece : pieces) {
                    if ((piece.col == mouseListener.x  / Board.SQUARE_SIZE)
                            && (piece.row == mouseListener.y / Board.SQUARE_SIZE)) {
                        activePiece = piece;
                        break;
                    }
                }
            }
            else {

                activePiece.xPixel = mouseListener.x - Board.SQUARE_SIZE / 2 ;
                activePiece.yPixel = mouseListener.y - Board.SQUARE_SIZE / 2;

                int newCol = mouseListener.x / Board.SQUARE_SIZE;
                int newRow = mouseListener.y / Board.SQUARE_SIZE;


                if (activePiece instanceof Pawn) {
                    Pawn pawn = (Pawn) activePiece;
                    if (pawn.isValidMove(newCol, newRow, pieces,mouseListener.x,mouseListener.y)) {
                        activePiece.col = newCol;
                        activePiece.row = newRow;
                    }
                }
            }
        } else activePiece = null;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        board.draw((Graphics2D) g);
        for(Piece piece : pieces){
            piece.draw((Graphics2D) g);
        }

    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime(); //waktu terakhir saat loop terakhir dijalankan
        long currentTime;
        while (true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) /drawInterval;
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();


            }
        }
        //update info
        //draw
    }

}