package com.example.hangman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
TextView textView,txt_words;
Button btn_restart,btn_exit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textView);
        txt_words = findViewById(R.id.txt_words);

        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("Result");

        String show_words_inResult = bundle.getString("words");
        txt_words.setText(show_words_inResult);


        btn_restart = findViewById(R.id.btn_restart);
        btn_exit = findViewById(R.id.btn_exit);
        textView.setText(result);
        txt_words.setText(show_words_inResult);

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
btn_restart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ResultActivity.this , Start_Game.class);
        startActivities(new Intent[]{intent});
        finish();
    }
});

    }
}