package my.testbot.common;

import java.util.HashMap;

import my.testbot.game.Game;

public class GameManager {
    private static GameManager instance;
    private static HashMap<Long, Game> gameList;
    
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
            gameList = new HashMap<Long, Game>();
        }
        return instance;
    }
    
    public HashMap<Long, Game> getGameList() {
        return gameList;
    }
    
    public void addGame(long chatId, Game game) {
        gameList.put(chatId, game);
    }
}
