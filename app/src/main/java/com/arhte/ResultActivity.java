package com.arhte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewt , textVieww , textViewc ;
    Button playAgain;
    String question = "0";
    String correct = "0";
    String wrong = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewt = findViewById(R.id.textViewtq);

        textVieww = findViewById(R.id.textViewwa);

        textViewc = findViewById(R.id.textViewca);

        playAgain = findViewById(R.id.playAgain);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 question = "0";
                 correct = "0";
                 wrong = "0";
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent i = getIntent();

         question = "0";
         correct = "0";
         wrong = "0";

        question = i.getStringExtra("total");

        correct = i.getStringExtra("correct");

         wrong = i.getStringExtra("wrong");

        textViewt.setText(question);

        textViewc.setText(correct);

        textVieww.setText(wrong);

    }
}