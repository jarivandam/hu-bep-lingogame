package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.domain.Game;
import nl.jarivandam.lingogame.domain.Score;
import nl.jarivandam.lingogame.domain.exceptions.GameExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/")
    List<Game> all(){
        return gameService.findAll();
    }

    @PostMapping
    Game newGame (){
        return gameService.save(new Game());
    }

    @GetMapping("/{id}")
    Game singleGame(@PathVariable Long id){
        return gameService.findById(id).orElseThrow(() -> GameExceptions.gameNotFound());
    }

    @PostMapping("/{id}/end")
    Score endGame(@RequestBody Score score,@PathVariable Long id){
        return gameService.endGame(id,score);
    }

}
