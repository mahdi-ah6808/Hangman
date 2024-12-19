package com.example.hangman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hangman.classes.HotValues;

import java.util.ArrayList;

public class
MainActivity extends AppCompatActivity {


    String World;
    String worldDashed = "" ;
    TextView txt_View;
    ImageView img_hang;
    ArrayList<String> wordsList;
    int fillcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn_a = findViewById(R.id.btn_a);
        Button btn_b = findViewById(R.id.btn_b);
        Button btn_c = findViewById(R.id.btn_c);
        Button btn_d = findViewById(R.id.btn_d);
        Button btn_e = findViewById(R.id.btn_e);
        Button btn_f = findViewById(R.id.btn_f);
        Button btn_j = findViewById(R.id.btn_j);
        Button btn_h = findViewById(R.id.btn_h);
        Button btn_i = findViewById(R.id.btn_i);
        Button btn_g = findViewById(R.id.btn_g);
        Button btn_k = findViewById(R.id.btn_k);
        Button btn_l = findViewById(R.id.btn_l);
        Button btn_m = findViewById(R.id.btn_m);
        Button btn_n = findViewById(R.id.btn_n);
        Button btn_o = findViewById(R.id.btn_o);
        Button btn_p = findViewById(R.id.btn_p);
        Button btn_q = findViewById(R.id.btn_q);
        Button btn_r = findViewById(R.id.btn_r);
        Button btn_s = findViewById(R.id.btn_s);
        Button btn_t = findViewById(R.id.btn_t);
        Button btn_u = findViewById(R.id.btn_u);
        Button btn_v = findViewById(R.id.btn_v);
        Button btn_w = findViewById(R.id.btn_w);
        Button btn_x = findViewById(R.id.btn_x);
        Button btn_y = findViewById(R.id.btn_y);
        Button btn_z = findViewById(R.id.btn_z);
        txt_View = findViewById(R.id.txt_View);
        World = selectWord();
        img_hang = findViewById(R.id.img_hang);


        for (int i = 0; i < World.length(); i++) {
            if (World.charAt(i) == ' ') {
                worldDashed = worldDashed + " ";
            }else {
            worldDashed = worldDashed + "-";
            }
        }
        txt_View.setText(worldDashed);




         View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setletter(v);
            }
         };


        btn_a.setOnClickListener(listener);
        btn_b.setOnClickListener(listener);
        btn_c.setOnClickListener(listener);
        btn_d.setOnClickListener(listener);
        btn_e.setOnClickListener(listener);
        btn_f.setOnClickListener(listener);
        btn_j.setOnClickListener(listener);
        btn_h.setOnClickListener(listener);
        btn_i.setOnClickListener(listener);
        btn_g.setOnClickListener(listener);
        btn_k.setOnClickListener(listener);
        btn_l.setOnClickListener(listener);
        btn_m.setOnClickListener(listener);
        btn_n.setOnClickListener(listener);
        btn_o.setOnClickListener(listener);
        btn_p.setOnClickListener(listener);
        btn_q.setOnClickListener(listener);
        btn_r.setOnClickListener(listener);
        btn_s.setOnClickListener(listener);
        btn_t.setOnClickListener(listener);
        btn_u.setOnClickListener(listener);
        btn_v.setOnClickListener(listener);
        btn_w.setOnClickListener(listener);
        btn_x.setOnClickListener(listener);
        btn_y.setOnClickListener(listener);
        btn_z.setOnClickListener(listener);


    }
    @SuppressLint("ResourceType")
    private void setletter(View view) {
        Button button = (Button) view;

            String letter = button.getText().toString().toLowerCase();
                String worldLowerCase = World.toLowerCase();
                char letterchar = letter.charAt(0);

        if (worldLowerCase.contains(letter)) {
            for (int i=0; i < worldLowerCase.length(); i++){
                if (worldLowerCase.charAt(i) == letterchar){

                    char[] worldDashedCharArray = worldDashed.toCharArray();
                    worldDashedCharArray[i] = World.charAt(i);
                    worldDashed = new String(worldDashedCharArray);

                    txt_View.setText(worldDashed);

                    if (!worldDashed.contains("-")){

                        Intent listWordsIntent = new Intent(MainActivity.this, List_words.class);
                        listWordsIntent.putExtra("wordsArray", World);
                        startActivity(listWordsIntent);

                        Intent intent = new Intent(MainActivity.this , ResultActivity.class);
                        intent.putExtra("Result" , "You Win");
                        intent.putExtra("words", World);
                        startActivities(new Intent[]{intent});
                        finish();
                        return;

                    }
                }
            }
        }else {
            fillcount++;
            if (fillcount >= 7){
                img_hang.setImageResource(R.drawable.hangman_7);
                button.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(MainActivity.this , ResultActivity.class);
                intent.putExtra("Result" , "You Lose");
                intent.putExtra("words", World);
                    startActivities(new Intent[]{intent});
                    finish();
                return;
            }
                switch (fillcount) {
                    case 1:
                        img_hang.setImageResource(R.drawable.hangman_1);
                    break;
                    case 2:
                        img_hang.setImageResource(R.drawable.hangman_2);
                        break;
                    case 3:
                        img_hang.setImageResource(R.drawable.hangman_3);
                        break;
                    case 4:
                        img_hang.setImageResource(R.drawable.hangman_4);
                        break;
                    case 5:
                        img_hang.setImageResource(R.drawable.hangman_5);
                        break;
                    case 6:
                        img_hang.setImageResource(R.drawable.hangman_6);
                        break;
                }
        }

        button.setVisibility(View.INVISIBLE);
    }

    Intent listWordsIntent = new Intent(MainActivity.this, List_words.class);
    private String selectWord()
    {
        String[] words = {
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

        listWordsIntent.putExtra("wordsArray", words);
        startActivity(listWordsIntent);

        int index = (int) (Math.random() * words.length);

        return words[index];
    }
}