package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PlayerOneLogin extends AppCompatActivity {

    private static final String FILE_NAME= "leaderboard.txt";

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
            playerTwoLogin(view);
        });

        guest = findViewById(R.id.guest);
        guest.setOnClickListener(view -> guestLogin());


        goBack =findViewById(R.id.back);
        goBack.setOnClickListener(view -> goMainActivity());
    }

    public void save(View v){
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            mEditText.getText().clear();
            Toast.makeText(this, "Saved to" +getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
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

    public void playerTwoLogin(View view){
        if(!mEditText.getText().toString().equals("")){
            Intent intent = new Intent(this, PlayerTwoLogin.class);
            intent.putExtra("One", mEditText.getText().toString());
            save(view);
            startActivity(intent);
        }
    }
}