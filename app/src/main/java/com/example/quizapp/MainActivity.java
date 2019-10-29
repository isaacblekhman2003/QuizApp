package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private TextView loaded;
private Button trueButton;
private Button falseButton;
private Question[] questions;
private List<Question> questionList;
private int x;
private Quiz quiz;
private int score;
    public static final String EXTRA_SCORE = "score";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int x = 0;
        InputStream jsonFileInputStream   = getResources().openRawResource(R.raw.questions);
        String json = readTextFile(jsonFileInputStream);
        Gson gson = new Gson();
        questions =  gson.fromJson(json, Question[].class);
questionList = Arrays.asList(questions);
 quiz = new Quiz(questionList);

   // Log.d(TAG, "onCreate: " + questionList.toString());

        wirewidgets();
        loaded.setText(quiz.currentQuestion().getQuestion());
        setListeners(json);

    }
    public void  anyLeft(){
        if(quiz.getQuestionNum() == questionList.size()-1){
            Intent targetIntent =  new Intent(MainActivity.this, EndGameActivity.class);
            score = 10-quiz.getWrong();
            targetIntent.putExtra(EXTRA_SCORE,score);

            startActivity(targetIntent);

        }
    }

    private void setListeners(final String json) {

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quiz.checkAnswer(quiz.currentQuestion(),true);
                quiz.setQuestionNum(quiz.getQuestionNum()+1);
                loaded.setText(quiz.currentQuestion().getQuestion());
                anyLeft();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quiz.checkAnswer(quiz.currentQuestion(),false);
                quiz.setQuestionNum(quiz.getQuestionNum()+1);
                loaded.setText(quiz.currentQuestion().getQuestion());
                anyLeft();
            }
        });
    }

    private void wirewidgets() {

        loaded = findViewById(R.id.textView_main_Text);
        falseButton = findViewById(R.id.button_main_false);
       trueButton = findViewById(R.id.button_main_true);
    }
    public String readTextFile (InputStream jsonFileInputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = jsonFileInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            jsonFileInputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
