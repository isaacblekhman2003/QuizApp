package com.example.quizapp;

import android.content.Intent;

import java.util.List;

public class Quiz {

   private List<Question> questionList;
    private int wrong;
    private int questionNum;

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }



    public Quiz(List<Question> questionList) {
        this.questionList = questionList;
        questionNum = 0;
        wrong = 0;
    }
    public void checkAnswer(Question currentQuestion, boolean answer){

        if(currentQuestion.getAnswer() != answer){
            wrong++;
        }
        }

    public Question currentQuestion(){
        return questionList.get(questionNum);
    }


}