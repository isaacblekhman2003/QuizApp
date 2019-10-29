package com.example.quizapp;
public class Question {
 public String question;
 public Boolean answer;

 public Question() {

 }


 public void setQuestion(String question) {
  this.question = question;
 }

 public void setAnswer(Boolean answer) {
  this.answer = answer;
 }


 public String getQuestion() {
  return question;
 }

 public Boolean getAnswer() {
  return answer;
 }


 public Boolean checkAnswer(Boolean theirAnswer){
  if (theirAnswer = answer)
  {
   return true;

  }
  else{
return false;
  }

 }
 }
