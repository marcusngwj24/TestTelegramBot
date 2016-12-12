package me.testmycurrentbot.handler;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TestTelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
     // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Testmycurrentbot";
    }

    @Override
    public String getBotToken() {
        return "311880983:AAGg0tpVm1zntz7Sb9EzrhbGCczl1HifID4";
    }
}
