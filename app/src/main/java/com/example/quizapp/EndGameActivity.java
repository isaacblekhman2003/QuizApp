package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {
private TextView scoreText;
private Button retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        wirewidgets();
        setlisteners();
        Intent lastIntent = getIntent();
        int string = lastIntent.getIntExtra(MainActivity.EXTRA_SCORE,0);

        scoreText.setText( string + " /" + 10);


    }

    private void setlisteners() {
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent targetIntent =  new Intent(EndGameActivity.this, MainActivity.class);
                startActivity(targetIntent);

            }
        });
    }

    private void wirewidgets(){
    scoreText = findViewById(R.id.textView_end_score);
        retry = findViewById(R.id.button_end_retry);
    }


}
