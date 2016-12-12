package me.testmycurrenybot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import me.testmycurrentbot.handler.TestTelegramBot;

public class Main {
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
