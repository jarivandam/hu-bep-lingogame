package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameRepository;
import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameRepository repository;

    @PostMapping("/game")
    Game newGame (@RequestBody Game newGame){
        return repository.save(newGame);
    }

    @GetMapping("/games")
    List<Game> all(){
       return repository.findAll();
    }

    @GetMapping("/games/{id}")
    Game singleGame(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
}
