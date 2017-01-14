package my.testbot.storage;

import java.util.ArrayList;
import java.util.Random;

import my.testbot.game.Noun;

public class NounBank {
    private static ArrayList<Noun> bank;
    
    public NounBank() {
        bank = new ArrayList<Noun>();
        bank.add(new Noun("魚", "さかな", "", "sakana", "fish"));
        bank.add(new Noun("雨", "あめ", "", "ame", "rain"));
        bank.add(new Noun("熊", "くま", "", "kuma", "bear"));
    }
    
    public static Noun getRandomNoun() {
        Random rn = new Random();
        int range = bank.size();
        int randomNum =  rn.nextInt(range);
        return bank.get(randomNum);
    }
}
