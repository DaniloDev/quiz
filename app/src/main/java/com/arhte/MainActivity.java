package com.arhte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.arhte.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    Button b1,b2,b3,b4;
    TextView t1_question, timerTxt;
    int total = 1;
    int correct = 0;
    FirebaseDatabase  database = FirebaseDatabase.getInstance();
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        t1_question = (TextView) findViewById(R.id.questionsTxt);
        timerTxt = (TextView) findViewById(R.id.timerTxt);

        updateQuestions();
    }

    private void updateQuestions(){
        total++;
        if(total > 4){
          //Abrir o resultado


        }else{

            DatabaseReference reference = database.getReference()
                    .child("Questions")
                    .child(String.valueOf(total));

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Question question = dataSnapshot.getValue(Question.class);
                    t1_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    b1.setOnClickListener(view -> {
                        if(b1.getText().toString().equals(question.getAnswer())){
                            b1.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        }else{
                            //Resposta Errada
                            wrong++;
                            b1.setBackgroundColor(Color.RED);;

                            if(b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(Color.GREEN);
                            }
                            else
                                if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                            else
                                if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                            Handler handler = new Handler();
                            handler.postDelayed( () -> {

                            b1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            b2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            b3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            b4.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            updateQuestions();
                            }, 1500);
                        }
                    });

                    b2.setOnClickListener(view -> {
                        if (b2.getText().toString().equals(question.getAnswer())) {
                            b2.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        } else {
                            //Resposta Errada
                            wrong++;
                            b2.setBackgroundColor(Color.RED);
                            ;

                            if (b1.getText().toString().equals(question.getAnswer())) {
                                b1.setBackgroundColor(Color.GREEN);
                            } else if (b3.getText().toString().equals(question.getAnswer())) {
                                b3.setBackgroundColor(Color.GREEN);
                            } else if (b4.getText().toString().equals(question.getAnswer())) {
                                b4.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed(() -> {

                                b1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b4.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        }
                    });

                    b3.setOnClickListener(view -> {
                        if(b3.getText().toString().equals(question.getAnswer())){
                            b3.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        }else{
                            //Resposta Errada
                            wrong++;
                            b3.setBackgroundColor(Color.RED);;

                            if(b1.getText().toString().equals(question.getAnswer())){
                                b1.setBackgroundColor(Color.GREEN);
                            }
                            else
                            if(b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(Color.GREEN);
                            }
                            else
                            if(b4.getText().toString().equals(question.getAnswer())){
                                b4.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed( () -> {

                                b1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b4.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        }
                    });

                    b4.setOnClickListener(view -> {
                        if(b4.getText().toString().equals(question.getAnswer())){
                            b4.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b4.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        }else{
                            //Resposta Errada
                            wrong++;
                            b4.setBackgroundColor(Color.RED);;

                            if(b1.getText().toString().equals(question.getAnswer())){
                                b1.setBackgroundColor(Color.GREEN);
                            }
                            else
                            if(b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(Color.GREEN);
                            }
                            else
                            if(b3.getText().toString().equals(question.getAnswer())){
                                b3.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed( () -> {

                                b1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                b4.setBackgroundColor(Color.parseColor("#FFFC2C"));
                                updateQuestions();
                            }, 1500);
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
}
