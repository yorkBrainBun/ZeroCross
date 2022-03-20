package com.example.myapplication.game;

public class CheckWin {
    public static boolean checkWin(Board board){
        switch (board.lastX){
            case 0:
                switch (board.lastY){
                    case 0:
                        if(checkTopRow(board)||checkLeftColumn(board)||checkDownDiagonal(board)){return true;}
                        break;
                    case 1:
                        if(checkTopRow(board)||checkMiddleColumn(board)){return true;}
                        break;
                    case 2:
                        if(checkTopRow(board)||checkRightColumn(board)||checkRiseDiagonal(board)){return true;}
                        break;
                }
                break;
            case 1:
                switch (board.lastY){
                    case 0:
                        if(checkMiddleRow(board)||checkLeftColumn(board)){return true;}
                        break;
                    case 1:
                        if(checkMiddleRow(board)||checkMiddleColumn(board)||checkDownDiagonal(board)||checkRiseDiagonal(board)){return true;}
                        break;
                    case 2:
                        if(checkTopRow(board)||checkRightColumn(board)||checkRiseDiagonal(board)){return true;}
                        break;
                }
                break;
            case 2:
                switch (board.lastY){
                    case 0:
                        if(checkBottomRow(board)||checkLeftColumn(board)||checkRiseDiagonal(board)){return true;}
                        break;
                    case 1:
                        if(checkBottomRow(board)||checkMiddleColumn(board)){return true;}
                        break;
                    case 2:
                        if(checkBottomRow(board)||checkRightColumn(board)||checkDownDiagonal(board)){return true;}
                        break;
                }
                break;
        }
        return false;
    }

    public static boolean checkTopRow(Board board){
        return board.getPiece(0, 0) == board.getPiece(1, 0) ||
                board.getPiece(1, 0) == board.getPiece(2, 0);
    }

    private static boolean checkBottomRow(Board board){
        return board.getPiece(0, 2) == board.getPiece(1, 2) ||
                board.getPiece(1, 2) == board.getPiece(2, 2);
    }

    private static boolean checkMiddleRow(Board board){
        return board.getPiece(0, 1) == board.getPiece(1, 1) ||
                board.getPiece(1, 1) == board.getPiece(2, 1);
    }

    private static boolean checkLeftColumn(Board board){
        return board.getPiece(0, 0) == board.getPiece(0, 1) ||
                board.getPiece(0, 1) == board.getPiece(0, 2);
    }

    private static boolean checkMiddleColumn(Board board){
        return board.getPiece(1, 0) == board.getPiece(1, 1) ||
                board.getPiece(1, 1) == board.getPiece(1, 2);
    }

    private static boolean checkRightColumn(Board board){
        return board.getPiece(2, 0) == board.getPiece(2, 1) ||
                board.getPiece(2, 1) == board.getPiece(2, 2);
    }

    private static boolean checkDownDiagonal(Board board){
        return board.getPiece(0, 0) == board.getPiece(1, 1) ||
                board.getPiece(1, 1) == board.getPiece(2, 2);
    }

    private static boolean checkRiseDiagonal(Board board){
        return board.getPiece(0, 2) == board.getPiece(1, 1) ||
                board.getPiece(1, 1) == board.getPiece(2, 0);
    }
}
