package my.testbot.handler;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TestTelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        execute(update);
    }

    @Override
    public String getBotUsername() {
        return "Testmycurrentbot";
    }

    @Override
    public String getBotToken() {
        return "311880983:AAGg0tpVm1zntz7Sb9EzrhbGCczl1HifID4";
    }
    
    private void execute(Update update) {
     // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                        .setChatId(update.getMessage().getChatId())
                        .setText(update.getMessage().getFrom().getFirstName());
            
            try {
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}


/*public class TestTelegramBot extends TelegramWebhookBot {

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText("Hello " + update.getMessage().getFrom().getFirstName());
            
            return message; // Call method to send the message
        }
        return null;
    }

    @Override
    public String getBotUsername() {
        return "Testmycurrentbot";
    }

    @Override
    public String getBotPath() {
        // TODO Auto-generated method stub
        return "";
    }

    @Override
    public String getBotToken() {
        return "311880983:AAGg0tpVm1zntz7Sb9EzrhbGCczl1HifID4";
    }
    
}*/