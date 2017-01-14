package my.testbot.game;

import java.util.HashMap;

public class Noun {
    private HashMap<String, String> noun;
    
    public Noun (String kanji, String hiragana, String katakana, String romanization, String meaning) {
        noun = new HashMap<String, String>();
        noun.put("kanji", kanji);
        noun.put("hiragana", hiragana);
        noun.put("katakana", katakana);
        noun.put("romanization", romanization);
        noun.put("meaning", meaning);
    }
    
    public HashMap<String, String> getNoun() {
        return noun;
    }
    
}
