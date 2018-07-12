package com.example.joker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        final TextView questionTextView = findViewById(R.id.jokeQuestionTextView);
        final TextView answerTextView = findViewById(R.id.jokeAnswerTextView);

        String joke = getIntent().getStringExtra(IntentExtrasKeys.Joke);
        String question = joke.split("//")[0];
        String answer = joke.split("//")[1];

        questionTextView.setText(question);
        answerTextView.setText(answer);

        answerTextView.postDelayed(new Runnable() {
            public void run() {
                answerTextView.setVisibility(View.VISIBLE);
            }
        }, 3000);
    }
}
