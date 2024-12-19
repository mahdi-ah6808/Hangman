package com.example.hangman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hangman.classes.HotValues;

import java.util.ArrayList;

public class Add_Words extends AppCompatActivity {


    EditText Edt_Txt;
    Button Btn_Add_Word;
    Button backspace;

    ArrayList<String> wordsList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_words);

        Edt_Txt = findViewById(R.id.Edt_Txt);
        Btn_Add_Word = findViewById(R.id.Btn_Add_Word);
        backspace = findViewById(R.id.backspace);

        Btn_Add_Word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newWord = Edt_Txt.getText().toString().trim();

                if (!newWord.isEmpty()) {

                    HotValues.storeSrv.edit().putString("wordsList",newWord).apply();

                    Intent intent = new Intent(Add_Words.this, List_words.class);
                    intent.putStringArrayListExtra("wordsList", wordsList);
                    startActivity(intent);

                    backspace.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });

                }
            }
        });
    }
}