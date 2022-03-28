package com.example.myapplication.game;

public class UltimateBoard extends Board{
    Board[][] board;

    public UltimateBoard(){
        board = new Board[3][3];
    }

    public Board getBoard(int x, int y){
        return board[x][y];
    }
}
