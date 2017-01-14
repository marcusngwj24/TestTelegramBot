package my.testbot.game;

import java.util.HashMap;
import java.util.Random;

import my.testbot.storage.NounBank;

public class NounQuestion {
    public static final NounBank nounBank = new NounBank();
    private String[] questionType = {"kanji", "hiragana", "katakana", "romanization", "meaning"};
    private HashMap<String, String> chosenNoun;
    private String chosenAnswer;
    
    public String getNewQuestion() {
        chosenNoun = NounBank.getRandomNoun().getNoun();
        
        int qnsIndex = getRandomQuestionType();
        String chosenQuestionType = questionType[qnsIndex];
        while(chosenNoun.get(chosenQuestionType).isEmpty()) {
            qnsIndex = getRandomQuestionType();
            chosenQuestionType = questionType[qnsIndex];
        }
        
        int ansIndex = getRandomQuestionType();
        String chosenAnswerType = questionType[ansIndex];
        chosenAnswer = chosenNoun.get(chosenAnswerType);
        while(chosenNoun.get(chosenAnswerType).isEmpty()) {
            ansIndex = getRandomQuestionType();
            chosenAnswer = chosenNoun.get(chosenAnswerType); 
        }
        System.out.println("ANS: " + chosenAnswer);
        
        return "What is the " + chosenAnswerType + " of " + chosenNoun.get(chosenQuestionType) + "?";
    }
    
    private int getRandomQuestionType() {
        Random rn = new Random();
        int range = questionType.length;
        int randomNum =  rn.nextInt(range);
        return randomNum;
    }
    
    public String getChosenAnswer() {
        return chosenAnswer;
    }
    
    public boolean isCorrectAnswer(String userInput){
        return chosenAnswer.equals(userInput);
    }
}
