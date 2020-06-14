package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.domain.Game;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Game controller test")
public class GameControllerTest {
    @InjectMocks
    private GameController gameController;

    @Mock
    GameService gameService;

    @Test
    @DisplayName("Smoke test")
    public void SmokeTest(){
        assertThat(gameController).isNotNull();
    }

    @Test
    @DisplayName("Get all Games")
    public void GetAll(){
        List<Game> games = new ArrayList<Game>();
        games.add(new Game());
        games.add(new Game());
        when(gameService.findAll()).thenReturn(games);

        List<Game> response = gameController.all();

        assertEquals(games,response);
    }

    @Test
    @DisplayName("Get single Game")
    public void GetSingleGame(){
        Game game = new Game();
        when(gameService.findById(anyLong())).thenReturn(java.util.Optional.of(game));

        Game response = gameController.singleGame(Long.valueOf(1));

        assertEquals(game,response);
    }



}
