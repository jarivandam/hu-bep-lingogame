package nl.jarivandam.lingogame.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Validator {
    public List <CharPresent> validate( Word guessedWord,Word correctWord) {
        List<CharPresent> result = new ArrayList<CharPresent>();
        Set<Character> correctChars = correctWord.wordAsCharsSet();
        int wordLenght = correctWord.wordAsChars().size();
        if (guessedWord == null) {
            for (int i = 0; i < wordLenght; i++) {
                result.add(CharPresent.FAULT);
            }
        } else {
            for (int i = 0; i < wordLenght; i++) {
                char c = guessedWord.wordAsChars().get(i);
                if (c == correctWord.wordAsChars().get(i)) {
                    result.add(CharPresent.GOOD);
                    correctChars.remove(c);
                } else if (correctChars.contains(c)) {
                    result.add(CharPresent.CONTAINS);
                    correctChars.remove(c);
                } else {
                    result.add(CharPresent.FAULT);
                }
            }
        }
        return result;
    }

    public boolean isWinning (List<CharPresent> feedback){
        for (CharPresent item : feedback){
            if (item != CharPresent.GOOD){
                return false;
            }
        }
        return true;
    }
}
