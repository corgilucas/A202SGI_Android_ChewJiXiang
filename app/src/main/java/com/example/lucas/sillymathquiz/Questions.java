package com.example.lucas.sillymathquiz;

public class Questions {
    //Create an array to store questions.
    public String mQuestions[] = {
            "1 + 2 = ?",
            "58 + 77 = ?",
            "38 + ? = 91",
            "If 5A = 3B, 1B = 6C,\nthen 1A = ?C",
            "If 5.2A = 1.3B, 1B = 340C,\nthen 2A = ?C",
            "? + 45 = 81",
            "20 - 4 = ?",
            "24 x ? = 216",
            "87 x ? = 261",
            "520 - ? = 98",
    };

    //Create an array to store available answer for each question.
    private String mChoices[][] = {
            {"3","4","5","6"},
            {"125","135","145","155"},
            {"52","60","53","48"},
            {"3.6","3.8","2.6","3.5"},
            {"163","160","168","170"},
            {"36","33","42","26"},
            {"15","16","13","12"},
            {"6","7","8","9"},
            {"2","3","4","5"},
            {"430","421","422","432"}
    };

    //Create an array to store the correct answer for each questions.
    private String mCorrectAnswers[] = {"3","135","53","3.6","170","36","16","9","3","422"};

    public String getQuestions(int a){
        String question = mQuestions[a];
        return question;
    }

    public  String getChoice1(int a){
        String choice = mChoices[a][0];
        return  choice;
    }

    public  String getChoice2(int a){
        String choice = mChoices[a][1];
        return  choice;
    }

    public  String getChoice3(int a){
        String choice = mChoices[a][2];
        return  choice;
    }

    public  String getChoice4(int a){
        String choice = mChoices[a][3];
        return  choice;
    }

    public  String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return  answer;
    }
}
