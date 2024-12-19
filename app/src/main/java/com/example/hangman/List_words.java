package com.example.hangman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hangman.classes.WordsAdapter;
import com.example.hangman.classes.HotValues;

import java.util.ArrayList;
import java.util.Arrays;

// در List_words.java
public class List_words extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> wordsList;
    Button add_word;
    Button Back_Start;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words);

        recyclerView = findViewById(R.id.recyclerView);

        wordsList = getIntent().getStringArrayListExtra("wordsList");

        String[] wordList = {
                "Hello World",
                "Mobile",
                "Wifi",
                "Math",
                "Iran",
                "Hang Man",
                "Android Studio",
                "Java",
                HotValues.storeSrv.getString("wordsList","")
        };

        ArrayList<String> combinedList = new ArrayList<>(Arrays.asList(wordList));
        if (wordsList != null) {
            combinedList.addAll(wordsList);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        WordsAdapter adapter = new WordsAdapter(combinedList);
        recyclerView.setAdapter(adapter);

        add_word = findViewById(R.id.add_word);

        add_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Words.class);
                startActivity(intent);
            }
        });
        Back_Start =findViewById(R.id.Back_Start);

        Back_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),Start_Game.class);
                startActivity(intent);
            }
        });

    }
}
