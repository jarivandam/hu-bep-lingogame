package nl.jarivandam.lingogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Score")
public class ScoreTest {
    @Test
    @DisplayName("Set and get name")
    public void NameTest(){
        String name = "Jari";
        Score score = new Score();

        score.setName(name);

        assertEquals(name, score.getName());
    }
}
