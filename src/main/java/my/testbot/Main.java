package my.testbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import my.testbot.common.GameManager;
import my.testbot.handler.TestTelegramBot;

public class Main {
    public static GameManager gameManager = GameManager.getInstance();
    
    public static void main(String[] args) {

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new TestTelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
