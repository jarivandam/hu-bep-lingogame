package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameRepository;
import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.domain.Game;
import nl.jarivandam.lingogame.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameRepository repository;

    @GetMapping
    List<Game> all(){
        return repository.findAll();
    }

    @PostMapping
    Game newGame (@RequestBody Game newGame){
        return repository.save(newGame);
    }

    @GetMapping("/{id}")
    Game singleGame(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

}
