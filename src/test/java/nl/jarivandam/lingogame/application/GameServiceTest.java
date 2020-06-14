package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Game Service")
@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    GameRepository gameRepository;

    @Mock
    ScoreRepository scoreRepository;

    @InjectMocks
    GameService gameService;

    @Test
    @DisplayName("End game test")
    public void endGameTest(){
        Game game = new Game();
        game.setId(Long.valueOf(1));
        Round testRound = new Round(new Word("hello"));
        List <Turn> turns = new ArrayList<Turn>();
        Turn testTurn = new Turn();
        testTurn.setWon(true);
        turns.add(testTurn);

        testRound.setTurns(turns);
        List< Round > rounds = new ArrayList<Round>();
        rounds.add(testRound);

        game.setRounds(rounds);
        Score score = new Score();
        score.setName("Jantje");


        when(gameRepository.findById(game.getId())).thenReturn(Optional.of(game));
        when(scoreRepository.save(score)).thenReturn(score);

        Score result = gameService.endGame(game.getId(),score);
        score.setScore(50);

        assertEquals(50,result.getScore());
    }
}
