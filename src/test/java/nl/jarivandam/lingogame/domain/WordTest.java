package nl.jarivandam.lingogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("Word")
public class WordTest {
    @Test
    @DisplayName("Create word")
    void newWord(){
        String string = "hello";

        Word word = new Word(string);

        assertNotNull(word.getWord());
        assertSame(word.getWord(),string);
    }
}