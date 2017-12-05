package com.example.lucas.sillymathquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView score, question;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    //mScore is used to calculate how many questions that user has answered correctly
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Create a random variable to use for randomly picking a question from questions array.
        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        score.setText("Score: " + mScore);

        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Checking the answer of the question is matching with the text of button.
                if(answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    //If correct answer has selected, a toast message will pop up.
                    Toast.makeText(QuizActivity.this,
                                    R.string.toast,
                            Toast.LENGTH_SHORT).show();
                    //random picking a question from the questions array as next question.
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else { //Call game over function if user has picked the wrong answer.
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Checking the answer of the question is matching with the text of button.
                if(answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    //If correct answer has selected, a toast message will pop up.
                    Toast.makeText(QuizActivity.this,
                            R.string.toast,
                            Toast.LENGTH_SHORT).show();
                    //random picking a question from the questions array as next question.
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else { //Call game over function if user has picked the wrong answer.
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Checking the answer of the question is matching with the text of button.
                if(answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    //If correct answer has selected, a toast message will pop up.
                    Toast.makeText(QuizActivity.this,
                            R.string.toast,
                            Toast.LENGTH_SHORT).show();
                    //random picking a question from the questions array as next question.
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else { //Call game over function if user has picked the wrong answer.
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Checking the answer of the question is matching with the text of button.
                if(answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    //If correct answer has selected, a toast message will pop up.
                    Toast.makeText(QuizActivity.this,
                            R.string.toast,
                            Toast.LENGTH_SHORT).show();
                    //random picking a question from the questions array as next question.
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else { //Call game over function if user has picked the wrong answer.
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestions(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    /*When game is over, display a pop up message with the user's scores and
    ask if user wants to quit the apps or start a new game.*/
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
