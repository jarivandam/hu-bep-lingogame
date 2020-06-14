package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@DisplayName("Word service test")
@ExtendWith(MockitoExtension.class)
public class WordServiceTest {
    @Mock
    WordRepository wordRepository;

    @InjectMocks
    WordService wordService;

    @Test
    @DisplayName("Get random word")
    public void getRandomWord() {
        Word word = new Word("hello");
        when(wordRepository.findById(anyInt())).thenReturn(Optional.of(word));
        when(wordRepository.count()).thenReturn((long) 8000);

        Word result = wordService.getRandom();

        assertEquals(word.getWord(),result.getWord());
    }
}