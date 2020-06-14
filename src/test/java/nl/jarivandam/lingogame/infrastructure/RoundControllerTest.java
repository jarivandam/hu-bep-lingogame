package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.application.RoundRepository;
import nl.jarivandam.lingogame.application.WordService;
import nl.jarivandam.lingogame.domain.Game;
import nl.jarivandam.lingogame.domain.Round;
import nl.jarivandam.lingogame.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@DisplayName("Word controller")
@ExtendWith(MockitoExtension.class)
public class RoundControllerTest {
    @InjectMocks
    private RoundController roundController;

    @Mock
    RoundRepository roundRepository;

    @Mock
    GameService gameService;

    @Mock
    WordService wordService;

    @Test
    @DisplayName("Get all words")
    public void GetAll(){
        Game game = new Game();
        List<Round> rounds = new ArrayList<Round>();
        rounds.add(new Round(game));
        rounds.add(new Round(game));
        when(roundRepository.findAll()).thenReturn(rounds);

        List<Round> response = roundController.all();

        assertEquals(rounds,response);
    }

    @Test
    @DisplayName("New Round")
    public void StartNewRound(){
        Game game = new Game();
        Round round = new Round(game);
        Word word = new Word("aapje");
        when(wordService.getRandom()).thenReturn(word);
        when(gameService.findById(anyLong())).thenReturn(java.util.Optional.of(game));
        when(roundRepository.save(any(Round.class))).thenReturn(round);

        Round response = roundController.newRound(Long.valueOf(1));

        assertEquals(round,response);
    }
}
