package nl.jarivandam.lingogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Round")
public class RoundTest {
    @Test
    @DisplayName("Round empty constructor")
    public void emptyConstructor(){
        Game game = new Game();
        Round round = new Round();
        Word word = new Word("hello");

        round.setWord(word);
        round.setGame(game);


        assertSame(game,round.getGame());
        assertSame(word.getWord(),round.getWord().getWord());
        assertEquals(0,round.getTurnsPlayed());
    }
    @Test
    @DisplayName("Round game constructor")
    public void gameConstructor(){
        Game game = new Game();
        Round round = new Round(game);
        Word word = new Word("hello");

        round.setWord(word);

        assertSame(game,round.getGame());
        assertSame(word.getWord(),round.getWord().getWord());
        assertEquals(0,round.getTurnsPlayed());
    }

    @Test
    @DisplayName("Round word constructor")
    public void wordConstructor(){
        Game game = new Game();
        Word word = new Word("hello");

        Round round = new Round(word);
        round.setGame(game);

        assertSame(game,round.getGame());
        assertSame(word.getWord(),round.getWord().getWord());
        assertEquals(0,round.getTurnsPlayed());
    }
}
