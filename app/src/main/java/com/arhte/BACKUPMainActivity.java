package com.arhte;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.arhte.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

public class BACKUPMainActivity extends AppCompatActivity {

    Button btn1, btn2 , btn3 ,btn4 ;
    TextView textView_question , textView_timer;
    String Aswer;

    //private Firebase;
    DatabaseReference databaseReference;

    int total = 0;
    int correct = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);


        textView_question = (TextView) findViewById(R.id.questionsTxt);
        textView_timer = (TextView)  findViewById(R.id.timerTxt);

        updatequestion();
        reuqesttimer(120,textView_timer);


    }

    private void updatequestion() {

        total ++;

        if(total >4)
        {
            total--;
            Intent intent = new Intent(BACKUPMainActivity.this,ResultActivity.class);

            intent.putExtra("total",String.valueOf(total));
            intent.putExtra("correct",String.valueOf(correct));
            intent.putExtra("wrong",String.valueOf(wrong));
            startActivity(intent);

        }else {

           // databaseReference = new Firebase("");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.i("FIREBASE", dataSnapshot.getValue().toString());

                    final Question question = dataSnapshot.getValue(Question.class);

                  // String options =  dataSnapshot.getValue().toString();

                    try {
                        JSONObject obj = new JSONObject(dataSnapshot.getValue().toString());


                        String ask = obj.getString("Question");
                        String op1 = obj.getString("Option1");
                        String op2 = obj.getString("Option2");
                        String op3 = obj.getString("Option3");
                        String op4 = obj.getString("Option4");
                        Aswer = obj.getString("answer");

                        Log.i("ASK", ask);

                        textView_question.setText(ask);
                        btn1.setText(op1);
                        btn2.setText(op2);
                        btn3.setText(op3);
                        btn4.setText(op4);
                        textView_timer.setText(ask);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    //   JsonReader reader = new JsonReader();

                    //final Question question = dataSnapshot.getValue(Question.class);
                   // for(int i = 0; i < options.length(); i++) {

                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (btn1.getText().toString().equals(Aswer)){

                                    btn1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            Toast.makeText(BACKUPMainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();


                                        }
                                    }, 1000);

                                } else {


                                    wrong++;
                                    btn1.setBackgroundColor(Color.RED);

                                    if (btn2.getText().toString().equals(Aswer)) {

                                        btn2.setBackgroundColor(Color.GREEN);
                                    } else if (btn3.getText().toString().equals(Aswer)) {

                                        btn3.setBackgroundColor(Color.GREEN);
                                    } else if (btn4.getText().toString().equals(Aswer)) {

                                        btn4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                            updatequestion();
                                        }
                                    }, 1000);


                                }
                            }
                        });


                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (btn2.getText().toString().equals(Aswer)) {

                                    btn2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            Toast.makeText(BACKUPMainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();

                                            btn2.setBackgroundColor(Color.parseColor("#03A9F4"));


                                        }
                                    }, 1000);

                                } else {


                                    wrong++;
                                    btn2.setBackgroundColor(Color.RED);

                                    if (btn1.getText().toString().equals(Aswer)) {

                                        btn1.setBackgroundColor(Color.GREEN);
                                    } else if (btn3.getText().toString().equals(Aswer)) {

                                        btn3.setBackgroundColor(Color.GREEN);
                                    } else if (btn4.getText().toString().equals(Aswer)) {

                                        btn4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                            updatequestion();
                                        }
                                    }, 1000);


                                }


                            }
                        });


                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (btn3.getText().toString().equals(Aswer)) {

                                    btn3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            Toast.makeText(BACKUPMainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();

                                            btn3.setBackgroundColor(Color.parseColor("#03A9F4"));


                                        }
                                    }, 1000);

                                } else {


                                    wrong++;
                                    btn3.setBackgroundColor(Color.RED);

                                    if (btn1.getText().toString().equals(Aswer)) {

                                        btn1.setBackgroundColor(Color.GREEN);
                                    } else if (btn2.getText().toString().equals(Aswer)) {

                                        btn2.setBackgroundColor(Color.GREEN);
                                    } else if (btn4.getText().toString().equals(Aswer)) {

                                        btn4.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                            updatequestion();
                                        }
                                    }, 1000);


                                }
//                            else


                            }
                        });


                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (btn4.getText().toString().equals(Aswer)) {

                                    btn4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            Toast.makeText(BACKUPMainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();

                                            btn4.setBackgroundColor(Color.parseColor("#03A9F4"));


                                        }
                                    }, 1000);

                                } else {


                                    wrong++;
                                    btn4.setBackgroundColor(Color.RED);

                                    if (btn1.getText().toString().equals(Aswer)) {

                                        btn1.setBackgroundColor(Color.GREEN);
                                    } else if (btn2.getText().toString().equals(Aswer)) {

                                        btn2.setBackgroundColor(Color.GREEN);
                                    } else if (btn3.getText().toString().equals(Aswer)) {

                                        btn3.setBackgroundColor(Color.GREEN);
                                    }


                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                            updatequestion();
                                        }
                                    }, 1000);


                                }
//                            else

                            }
                        });


                   // }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }



    }


    public void reuqesttimer(final int seconds , final TextView txtVi){

        new CountDownTimer(seconds * 700 + 700, 800) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 700);
                int minutes = seconds /60;

                seconds = seconds %60;

                txtVi.setText(String.format("%02d",minutes) + ":" + String.format("%02d",seconds));

            }

            @Override
            public void onFinish() {
                txtVi.setText("Completed");
                Intent intent = new Intent(BACKUPMainActivity.this,ResultActivity.class);
                intent.putExtra("total" , String.valueOf(total));
                intent.putExtra("correct" , String.valueOf(correct));
                intent.putExtra("wrong",String.valueOf(wrong));
                startActivity(intent);

            }
        }.start();
    }
}