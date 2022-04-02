package com.example.myapplication.game;

public class UltimateBoard extends Board{
    Board[][] boards;

    public UltimateBoard(){
        boards = new Board[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boards[i][j] = new Board();
            }
        }
    }

    public Board getBoard(int x, int y){
        return boards[x][y];
    }

    public boolean isAllFull(){
        return boards[0][0].isFull() && boards[0][1].isFull() && boards[0][2].isFull() &&
                boards[1][0].isFull() && boards[1][1].isFull() && boards[1][2].isFull() &&
                boards[2][0].isFull() && boards[2][1].isFull() && boards[2][2].isFull();
    }

    public void print(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.println(i + " " + j);
                for (int k = 0; k < 3; k++){
                    for (int l = 0; l <3; l++){
                        System.out.print(boards[i][j].getPiece(k,l)+" ");
                    }
                    System.out.println();
                }

            }
        }
    }
}
