/*package my.testbot.handler;

import java.util.Random;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TestTelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (hasNewUpdate(update)) {
            execute(update);
        }
    }

    private void execute(Update update) {
        Message incomingMsg = update.getMessage();
        
        SendMessage message = createMessage(incomingMsg);

        executeSendMessage(message);
    }

    private SendMessage createMessage(Message incomingMsg) {
        String incomingMsgLowerCase = incomingMsg.getText().toString().toLowerCase();
        
        SendMessage message = null;
        if (incomingMsgLowerCase.contains("pig")) {
            message = new SendMessage() 
                                .setChatId(incomingMsg.getChatId())
                                .setText("HAHAHA! " + incomingMsg.getFrom().getFirstName() + " is a pig");
        }
        
        else if (incomingMsgLowerCase.equals("hi") || incomingMsgLowerCase.equals("hello")
                || incomingMsgLowerCase.contains("hii")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("Aye aye Captain " + incomingMsg.getFrom().getFirstName() + "!");
        }
        
        else if (incomingMsgLowerCase.contains("bye") || incomingMsgLowerCase.contains("cya")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("Good bye " + incomingMsg.getFrom().getFirstName() + "!");
        }
        
        else if (incomingMsgLowerCase.contains("lol") || incomingMsgLowerCase.contains("haha")) {
            message = generateReplyToLaughter(incomingMsg);
        }
        
        else if (incomingMsgLowerCase.contains("shut up") || incomingMsgLowerCase.contains("quiet")
                || incomingMsgLowerCase.contains("shaddup") || incomingMsgLowerCase.contains("shuddup")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("BB ish sad... Please don't scold me ><");
        }
        
        else if (incomingMsgLowerCase.contains("thanks") || incomingMsgLowerCase.contains("tks")
                || incomingMsgLowerCase.contains("thx") || incomingMsgLowerCase.equals("ty")
                || incomingMsgLowerCase.contains("thank you") || incomingMsgLowerCase.contains("arigato")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("I'm not sure if you are thanking me, but I assume you are. So you are welcome! Love you muacks!");
        }
        
        else if (incomingMsgLowerCase.contains("weird")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("Who's weird? Lai lai, come gossip!");
        }
        
        else if (incomingMsgLowerCase.contains("stupid") || (incomingMsgLowerCase).contains("dumb")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("My mummy say cannot scold people stupid. Don't scold ok?");
        }
        
        else if (incomingMsgLowerCase.contains("good")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("I see the word good, you saying me uh? So embarrassing! ");
        }
        
        else if (incomingMsgLowerCase.contains("yay")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("I feel so happy for you, " + incomingMsg.getFrom().getFirstName());
        }
        
        else if (incomingMsgLowerCase.equals("die")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("Oh my? Who died? Nuuuuuuuuuu......");
        }
        
        else if (incomingMsgLowerCase.contains("/stop")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("Why my lord... Why you want to stop...");
        }
        
        else if (incomingMsgLowerCase.contains("/start")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("Yup! I'm bored, let's play!");
        }
        
        else if (incomingMsgLowerCase.contains("eygpt")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText("The place of pyramids");
        }
        
        else if (incomingMsgLowerCase.contains("india")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText(incomingMsg.getFrom().getFirstName() + ", do you know there are 22 official languages in India?");
        }
        
        else if (incomingMsgLowerCase.contains("japan")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText(incomingMsg.getFrom().getFirstName() + ", konnichiwa! Ganbatte!");
        }
        
        else if (incomingMsgLowerCase.contains("korea")) {
            message = new SendMessage() 
                    .setChatId(incomingMsg.getChatId())
                    .setText(incomingMsg.getFrom().getFirstName() + ", saranghaeyo!");
        }
        
        
        
        
        return message;
        
    }
    
    private SendMessage generateReplyToLaughter(Message incomingMsg) {
        String user = incomingMsg.getFrom().getFirstName();
        
        String[] replyArr = { "Quiet " + user + "! Very funny izzit?!" ,
                              "Hahahah, yeah very funny. Keep laughing " + user + ", I wont stop you" , 
                              "Shut up" , 
                              "Lololol" ,
                              "Lame" ,
                              "HAHAHA! I kennot! Please stop!", 
                              user + ", eh, very funny harh? Dun laugh till die, I wont save you" ,
                              "Awww your laughter is so KAWAII!!!!" ,
                              "Shyttt!!! Im dying!!!" ,
                              "not funny. very funny meh?" ,
                              "Quiet la. noisy sia you" ,
                              "Your laughter makes me fall in love w you. Muacks!" ,
                              "Joke" ,
                              "You look dumb. Please stop laughing"};
        
        Random rn = new Random();
        int maximum = replyArr.length-1;
        int minimum = 0;
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;
                
                
        return new SendMessage() 
                .setChatId(incomingMsg.getChatId())
                .setText(replyArr[randomNum]);
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

    *//**
     * Check if the update has a message and the message has text
     *//*
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