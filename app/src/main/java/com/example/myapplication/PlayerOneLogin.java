package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlayerOneLogin extends AppCompatActivity {

    private static final String FILE_NAME= "leaderboard.txt";
    private static final String SCORE_FILE = "score.txt";

    EditText mEditText;
    private Button goBack;
    private Button login;
    private Button guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEditText = findViewById(R.id.edit_text);
        login = findViewById(R.id.login);
        login.setOnClickListener(view -> {
            try {
                playerTwoLogin(view);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        guest = findViewById(R.id.guest);
        guest.setOnClickListener(view -> guestLogin());


        goBack =findViewById(R.id.back);
        goBack.setOnClickListener(view -> goMainActivity());
    }

    public void save(View v){
        boolean duplicate = false;
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;
        FileInputStream fis = null;
        FileOutputStream fos1 = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null){
                if(temp.equals(text)){
                    System.out.println("User Already Exists");
                    duplicate = true;
                }
            }
            if(!duplicate){
                fos1 = openFileOutput(SCORE_FILE, MODE_APPEND);
                fos = openFileOutput(FILE_NAME, MODE_APPEND);

                PrintWriter pw1 = new PrintWriter(fos1, true);
                pw1.println(0);
                pw1.close();

                PrintWriter pw = new PrintWriter(fos, true);
                pw.println(text);
                pw.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void guestLogin(){
        Intent intent = new Intent(this, PlayerTwoLogin.class);
        intent.putExtra("One", (String) null);
        startActivity(intent);
    }

    public void goMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void playerTwoLogin(View view) throws FileNotFoundException {
        if(!mEditText.getText().toString().equals("")){
            Intent intent = new Intent(this, PlayerTwoLogin.class);
            intent.putExtra("One", mEditText.getText().toString());
            save(view);
            startActivity(intent);
        }
    }
}