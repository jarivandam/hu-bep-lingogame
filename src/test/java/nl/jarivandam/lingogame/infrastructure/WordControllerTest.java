package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.application.WordService;
import nl.jarivandam.lingogame.domain.Game;
import nl.jarivandam.lingogame.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Word controller")
@ExtendWith(MockitoExtension.class)
public class WordControllerTest {
    @InjectMocks
    private WordController wordController;

    @Mock
    WordService wordService;

    @Test
    @DisplayName("Get all words")
    public void GetAll(){
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("aapje"));
        words.add(new Word("hallo"));
        when(wordService.findAll()).thenReturn(words);

        List<Word> response = wordController.getWords();

        assertEquals(words,response);
    }

    @Test
    @DisplayName("Get a random word")
    public void GetRandom(){
        Word word = new Word("random");

        when(wordService.getRandom()).thenReturn(word);

        Word response = wordController.getRandomWord();

        assertEquals(word,response);
    }
}
