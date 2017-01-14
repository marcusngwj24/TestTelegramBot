package my.testbot.handler;

import java.util.Random;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import my.testbot.common.GameManager;
import my.testbot.game.Game;
import my.testbot.game.NounQuestion;

public class TestTelegramBot extends TelegramLongPollingBot {
    public static GameManager gameManager = GameManager.getInstance();
           
    @Override
    public void onUpdateReceived(Update update) {
        if (hasNewUpdate(update)) {
            execute(update);
        }
    }

    private void execute(Update update) {
        Message incomingMsg = update.getMessage();
        
        System.out.println("Incoming Msg: " + incomingMsg);        
        SendMessage message = createMessage(incomingMsg);

        executeSendMessage(message);
    }

    private SendMessage createMessage(Message incomingMsg) {
        long chatId = incomingMsg.getChatId();
        String incomingMsgLowerCase = incomingMsg.getText().toString().toLowerCase();
        Game currentGame;
        
        SendMessage message = null;
        
        
        if (incomingMsgLowerCase.contains("/start@testmycurrentbot")) {
            if (gameManager.getGameList().containsKey(chatId) && gameManager.getGameList().get(chatId).getGameStatus()) {
                message = new SendMessage()
                        .setChatId(chatId)
                        .setText("There is already an ongoing session.\nごめんなさい >.<");
            }
            else if (gameManager.getGameList().containsKey(chatId)) {
                message = playGame(chatId, incomingMsgLowerCase);
            }
            else {
                Game newGame = new Game();
                newGame.startGame(chatId);
                gameManager.addGame(chatId, newGame);
                message = playGame(chatId, incomingMsgLowerCase);
            }
        }
        
        else if (incomingMsgLowerCase.contains("/stop@testmycurrentbot")) {
            currentGame = gameManager.getGameList().get(chatId);
            currentGame.stopGame(chatId);
            message = new SendMessage()
                    .setChatId(chatId)
                    .setText("Thanks for playing");
        }
        
        else if (gameManager.getGameList().containsKey(chatId) 
                && gameManager.getGameList().get(chatId).getGameStatus() 
                && incomingMsgLowerCase.contains("/next")) {
            currentGame = gameManager.getGameList().get(chatId);
            message = new SendMessage()
                    .setChatId(chatId)
                    .setText(currentGame.newQuestion());
        }
        
        else if (gameManager.getGameList().containsKey(chatId) && gameManager.getGameList().get(chatId).getGameStatus()){
            currentGame = gameManager.getGameList().get(chatId);
            
            if (currentGame.getCurrentNounQuestion().isCorrectAnswer(incomingMsgLowerCase)) {
                message = new SendMessage()
                        .setChatId(chatId)
                        .setText("IT IS CORRECT!");
            }
        }
        
        return message;
    }
    
    private SendMessage playGame(long chatId, String userInput){
        Game currentGame = gameManager.getGameList().get(chatId);
        currentGame.startGame(chatId);
        String question = currentGame.newQuestion();
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(question);
        return message;
    }
    
    private void executeSendMessage(SendMessage message) {
        try {
            if (message!=null) {
                sendMessage(message); // Call method to send the message
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if the update has a message and the message has text
     */
    private boolean hasNewUpdate(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
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

/*
 * public class TestTelegramBot extends TelegramWebhookBot {
 * 
 * @Override public BotApiMethod onWebhookUpdateReceived(Update update) { if
 * (update.hasMessage() && update.getMessage().hasText()) {
 * 
 * SendMessage message = new SendMessage() // Create a SendMessage object with
 * mandatory fields .setChatId(update.getMessage().getChatId())
 * .setText("Hello " + update.getMessage().getFrom().getFirstName());
 * 
 * return message; // Call method to send the message } return null; }
 * 
 * @Override public String getBotUsername() { return "Testmycurrentbot"; }
 * 
 * @Override public String getBotPath() { // TODO Auto-generated method stub
 * return ""; }
 * 
 * @Override public String getBotToken() { return
 * "311880983:AAGg0tpVm1zntz7Sb9EzrhbGCczl1HifID4"; }
 * 
 * }
 */