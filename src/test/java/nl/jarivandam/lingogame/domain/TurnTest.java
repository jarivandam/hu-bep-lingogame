package nl.jarivandam.lingogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("Turn")
public class TurnTest {
    @Test
    @DisplayName("Standard turn")
    public void standardTurn(){
        Turn turn = new Turn();
        Word word = new Word("hello");
        Round round = new Round();

        turn.setGuessedWord(word);
        turn.setRound(round);

        assertSame(word.getWord(),turn.getGuessedWord().getWord());
        assertSame(round,turn.getRound());
    }
}
