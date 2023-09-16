package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"this is a question1", "this is a question2", "this is a question3", "this is a question4", "this is a question5"};
    private boolean[] answers = {true, false, true, false, true};
    private int index = 0;
    private int score = 0;
    private TextView question;
    private Button yes;
    private Button no;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView) findViewById(R.id.question);
        question.setText(questions[index]);
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < questions.length) {
                    if (answers[index]) {
                        score++;
                    }
                    index++;
                    if (index < questions.length) {
                        question.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your Score Is : " + score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restart The App For Test Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < questions.length) {
                    if (!answers[index]) {
                        score++;
                    }
                    index++;
                    if (index < questions.length) {
                        question.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your Score Is : " + score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restart The App For Test Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}