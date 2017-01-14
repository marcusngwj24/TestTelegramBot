package my.testbot.game;

import java.util.ArrayList;

import my.testbot.game.player.*;

public class Game {
    private boolean status = false;
    private long gameId;
    private ArrayList<Player> playerList;
    private NounQuestion currentNounQuestion;
    
    public Game() {
        playerList = new ArrayList<Player>();
    }
    
    public boolean getGameStatus() {
        return status;
    }
    
    public long getGameId() {
        return gameId;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    
    public NounQuestion getCurrentNounQuestion() {
        return currentNounQuestion;
    }
    
    public String newQuestion() {
        currentNounQuestion = new NounQuestion();
        return currentNounQuestion.getNewQuestion();
    }
    
    public void startGame(long chatId) {
        status = true;
        gameId = chatId;
    }
    
    public void stopGame(long chatId) {
        status = false;
    }
}
