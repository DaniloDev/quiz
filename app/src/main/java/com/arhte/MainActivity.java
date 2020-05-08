package com.arhte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private TextView mScoreView;
    private TextView mQuestion;
    CountDownTimer  Timer;

    private Button mButtonChoice1, mButtonChoice2 , mButtonChoice3 , mButtonChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer;
    TextView textView_timer;

    private Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnswerRef;

    int correct = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mScoreView = (TextView) findViewById(R.id.score);
        mQuestion = (TextView) findViewById(R.id.questionsTxt);
        textView_timer = (TextView) findViewById(R.id.timerTxt);

        mButtonChoice1 = (Button) findViewById(R.id.button1);
        mButtonChoice2 = (Button) findViewById(R.id.button2);
        mButtonChoice3 = (Button) findViewById(R.id.button3);
        mButtonChoice4 = (Button) findViewById(R.id.button4);

        updateQuestion();
        reuqesttimer(60,textView_timer);

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText().equals(mAnswer)){
                    mButtonChoice1.setBackgroundColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mScore = mScore + 1;
                            updateScore(mScore);
                            correct++;
                            mButtonChoice1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            updateQuestion();

                            //updateQuestion();
                        }
                    }, 1000);

                }else{
                    wrong++;
                    mButtonChoice1.setBackgroundColor(Color.RED);

                    if (mButtonChoice2.getText().toString().equals(mAnswer)) {

                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice3.getText().toString().equals(mAnswer)) {

                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice4.getText().toString().equals(mAnswer)) {

                        mButtonChoice4.setBackgroundColor(Color.GREEN);
                    }


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            mButtonChoice1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#FFFC2C"));

                            updateQuestion();
                        }
                    }, 1000);


                }
                //mButtonChoice1.setBackgroundColor(Color.RED);
               // updateQuestion();
            }
        });


        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText().equals(mAnswer)){
                    mButtonChoice2.setBackgroundColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mScore = mScore + 1;
                            updateScore(mScore);
                            correct++;
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            updateQuestion();

                        }
                    }, 1000);

                   // updateQuestion();
                }else{
                    wrong++;
                    mButtonChoice2.setBackgroundColor(Color.RED);

                    if (mButtonChoice1.getText().toString().equals(mAnswer)) {

                        mButtonChoice1.setBackgroundColor(Color.GREEN);

                    } else if (
                            mButtonChoice3.getText().toString().equals(mAnswer)) {

                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice4.getText().toString().equals(mAnswer)) {

                        mButtonChoice4.setBackgroundColor(Color.GREEN);
                    }


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            mButtonChoice1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#FFFC2C"));

                            updateQuestion();
                        }
                    }, 1000);


                }
               // mButtonChoice1.setBackgroundColor(Color.RED);
                //updateQuestion();
            }
        });


        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice3.getText().equals(mAnswer)){
                    mButtonChoice3.setBackgroundColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mScore = mScore + 1;
                            updateScore(mScore);
                            correct++;
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            updateQuestion();
                        }
                    }, 1000);

                   // updateQuestion();
                }else{
                    wrong++;
                    mButtonChoice3.setBackgroundColor(Color.RED);

                    if (mButtonChoice1.getText().toString().equals(mAnswer)) {

                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice2.getText().toString().equals(mAnswer)) {

                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice4.getText().toString().equals(mAnswer)) {

                        mButtonChoice4.setBackgroundColor(Color.GREEN);
                    }


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            mButtonChoice1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#FFFC2C"));

                            updateQuestion();
                        }
                    }, 1000);


                }
                //mButtonChoice1.setBackgroundColor(Color.RED);
               // updateQuestion();
            }
        });


        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice4.getText().equals(mAnswer)){
                    mButtonChoice4.setBackgroundColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mScore = mScore + 1;
                            updateScore(mScore);
                            correct++;
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            updateQuestion();
                        }
                    }, 1000);

                  //  updateQuestion();
                }else{
                    wrong++;
                    mButtonChoice4.setBackgroundColor(Color.RED);

                    if (mButtonChoice1.getText().toString().equals(mAnswer)) {

                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice2.getText().toString().equals(mAnswer)) {

                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                    } else if (mButtonChoice3.getText().toString().equals(mAnswer)) {

                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                    }


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            mButtonChoice1.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#FFFC2C"));
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#FFFC2C"));

                            updateQuestion();
                        }
                    }, 1000);


                }
              //  mButtonChoice1.setBackgroundColor(Color.RED);
              //  updateQuestion();
            }
        });
    }

    private void updateScore(int score){
       // mScoreView.setText("" + mScore);
    }

    private void updateQuestion() {

        if (mQuestionNumber > 3) {


           // reuqesttimer(0,textView_timer);
            textView_timer.setText("Finalizado");
            if(Timer != null){
                Timer.cancel();
                Timer = null;
            }
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);
            intent.putExtra("total",String.valueOf(mQuestionNumber));
            intent.putExtra("correct",String.valueOf(correct));
            intent.putExtra("wrong",String.valueOf(wrong));
            startActivity(intent);
            finish();

        } else {
            mQuestionRef = new Firebase("https://quiz-ce549.firebaseio.com/" + mQuestionNumber + "/question");
            mQuestionRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String question = dataSnapshot.getValue(String.class);
                    mQuestion.setText(question);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice1Ref = new Firebase("https://quiz-ce549.firebaseio.com/" + mQuestionNumber + "/choice1");
            mChoice1Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    mButtonChoice1.setText(choice);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice2Ref = new Firebase("https://quiz-ce549.firebaseio.com/" + mQuestionNumber + "/choice2");
            mChoice2Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    mButtonChoice2.setText(choice);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice3Ref = new Firebase("https://quiz-ce549.firebaseio.com/" + mQuestionNumber + "/choice3");
            mChoice3Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    mButtonChoice3.setText(choice);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice4Ref = new Firebase("https://quiz-ce549.firebaseio.com/" + mQuestionNumber + "/choice4");
            mChoice4Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    mButtonChoice4.setText(choice);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mAnswerRef = new Firebase("https://quiz-ce549.firebaseio.com/" + mQuestionNumber + "/answer");
            mAnswerRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mAnswer = dataSnapshot.getValue(String.class);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mQuestionNumber++;

        }

    }

    public void reuqesttimer(final int seconds , final TextView txtVi){

       Timer = new CountDownTimer(seconds * 700 + 700, 800) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 700);
                int minutes = seconds /60;

                seconds = seconds %60;

                txtVi.setText(String.format("%02d",minutes) + ":" + String.format("%02d",seconds));

            }

            @Override
            public void onFinish() {
                    txtVi.setText("Tempo Esgotado");
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("total" , String.valueOf(mQuestionNumber + 1));
                    intent.putExtra("correct" , String.valueOf(correct));
                    intent.putExtra("wrong",String.valueOf(wrong));
                    startActivity(intent);
                    finish();
            }
        }.start();
    }
}
