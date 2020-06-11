package nl.jarivandam.lingogame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
//    private List<CharPresent> result = new ArrayList<CharPresent>();

    public List <CharPresent> validate( Word guessedWord,Word correctWord){
        List<CharPresent> result = new ArrayList<CharPresent>();
        Set<Character> correctChars = correctWord.wordAsCharsSet();
        int wordLenght = correctWord.wordAsChars().size();
        for (int i = 0 ; i <  wordLenght ; i++) {
            char c = guessedWord.wordAsChars().get(i);
            if (c == correctWord.wordAsChars().get(i)) {
                result.add(CharPresent.GOOD);
                correctChars.remove(c);
            }
            else if (correctChars.contains(c)) {
                result.add(CharPresent.CONTAINS);
                correctChars.remove(c);
            }
            else {
                result.add(CharPresent.FAULT);
            }
        }

        return result;
    }
}
