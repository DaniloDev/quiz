package com.arhte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewt , textVieww , textViewc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewt = findViewById(R.id.textViewtq);

        textVieww = findViewById(R.id.textViewwa);

        textViewc = findViewById(R.id.textViewca);

        Intent i = getIntent();

        String question = i.getStringExtra("total");

        String correct = i.getStringExtra("correct");

        String wrong = i.getStringExtra("wrong");

        textViewt.setText(question);

        textViewc.setText(correct);

        textVieww.setText(wrong);

    }
}