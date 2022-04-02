package com.example.myapplication.game;

public class Board {
    int[][] tictactoeBoard;
    int lastX;
    int lastY;
    boolean isWon = false;

    Board(){
        tictactoeBoard = new int[][]{{0,0,0}, {0,0,0}, {0,0,0}};
    }

    //0 = O, 1 = X, -1 = empty

    public void setPiece(int positionX, int positionY, int piece){
        lastX = positionX;
        lastY = positionY;

        tictactoeBoard[positionX][positionY] = piece;
    }

    public int getPiece(int positionX, int positionY){
        return tictactoeBoard[positionX][positionY];
    }

    public void setWon(){
        isWon = true;
    }

    public boolean isWon() {
        return isWon;
    }

    public boolean isFull(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(tictactoeBoard[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
