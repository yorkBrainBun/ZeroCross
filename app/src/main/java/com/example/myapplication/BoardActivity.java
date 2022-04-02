package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.game.CheckWin;
import com.example.myapplication.game.UltimateBoard;

public class BoardActivity extends AppCompatActivity {
    private UltimateBoard board;
    Button [][][][] buttons = new Button[3][3][3][3];
    int lastX = -1;
    int lastY = -1;
    TextView turnBox;
    boolean placeAnywhere = true;
    int turn;

    //1 = O, -1 = X, 0 = empty

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        board = new UltimateBoard();
        turnBox = (TextView) findViewById(R.id.turnview);

        turn = 1;
        if(turn == -1){
            turnBox.setText("Turn X");
        } else{
            turnBox.setText("Turn O");
        }

        setUpButtons();
    }

    private void setUpButtons(){
        String temp;
        for(int x1 = 0; x1 < 3;x1++){
            for(int y1 = 0; y1 < 3; y1++){
                for(int x2 = 0; x2 < 3; x2++){
                    for(int y2 = 0; y2 < 3; y2++){
                        temp = "b" + x1 + y1 + x2 + y2;
                        buttons[y1][x1][y2][x2] = (Button) findViewById(getResources().getIdentifier(temp, "id", getPackageName()));
                        buttons[y1][x1][y2][x2].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String viewID = getResources().getResourceEntryName(view.getId());
                                Button button = view.findViewById(view.getId());
                                int y1 = Integer.parseInt(String.valueOf(viewID.charAt(1)));
                                int x1 = Integer.parseInt(String.valueOf(viewID.charAt(2)));
                                int y2 = Integer.parseInt(String.valueOf(viewID.charAt(3)));
                                int x2 = Integer.parseInt(String.valueOf(viewID.charAt(4)));

                                System.out.println(x1 +""+ y1 +x2 + y2);
                                if(placeAnywhere ||(x1 == lastX && y1 == lastY)&&board.getBoard(x1,y1).getPiece(x2,y2) == 0){
                                    board.getBoard(x1,y1).setPiece(x2,y2,turn);

                                    piecePlaced(button);
                                    if(!board.getBoard(x2,y2).isFull()){
                                        placeAnywhere = false;
                                        lastX = x2;
                                        lastY = y2;
                                        setAllBoardColour("#FFC1B4");
                                        setBoardColor(x2,y2,"#EEFFB4");
                                    }else{
                                        placeAnywhere =true;
                                        lastX = -1;
                                        lastY = -1;
                                        setAllBoardColour("#EEFFB4");
                                    }

                                    checkWin(x1,y1);
                                    turn *= -1;
                                }
                            }
                        });
                    }
                }
            }
        }
        setAllBoardColour("#EEFFB4");
    }

    private void checkWin(int x, int y) {
        if (CheckWin.checkWin(board.getBoard(x,y))){
            board.getBoard(x,y).setWon();
            board.setPiece(x,y,turn);
            for(int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    buttons[x][y][i][j].setTextColor(ColorStateList.valueOf(Color.parseColor("#2E6BB5")));
                }
            }
            if(CheckWin.checkWin(board)){
                turnBox.setText("Won");
            }
        }

        if(board.isAllFull()){
            turnBox.setText("Tied");
        }
    }

    public void setBoardColor(int x, int y, String colour){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[x][y][i][j].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colour)));
            }
        }
    }

    public void setAllBoardColour(String colour){
        for(int x1 = 0; x1 < 3;x1++){
            for(int y1 = 0; y1 < 3; y1++){
                for(int x2 = 0; x2 < 3; x2++){
                    for(int y2 = 0; y2 < 3; y2++){
                        buttons[x1][y1][x2][y2].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colour)));
                    }
                }
            }
        }
    }

    public void piecePlaced(Button button){
        if(turn == -1){
            turnBox.setText("Turn O");
            button.setText("X");
        } else{
            turnBox.setText("Turn X");
            button.setText("O");
        }

    }
}