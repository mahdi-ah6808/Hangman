package com.example.hangman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hangman.classes.HotValues;

public class Start_Game extends AppCompatActivity {

    Button btn_start_Game,btn_list_word;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_game);
        HotValues.storeSrv = getSharedPreferences("sample",0);

        btn_start_Game = findViewById(R.id.btn_start_Game);
        btn_list_word = findViewById(R.id.btn_list_word);

        btn_start_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btn_list_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),List_words.class);
                startActivity(intent);
            }
        });

    }
}