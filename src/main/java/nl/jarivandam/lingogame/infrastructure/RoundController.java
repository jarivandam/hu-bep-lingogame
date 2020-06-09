package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.application.RoundRepository;
import nl.jarivandam.lingogame.application.WordService;
import nl.jarivandam.lingogame.domain.Round;
import nl.jarivandam.lingogame.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoundController {
    @Autowired
    WordService wordService;

    @Autowired
    RoundRepository roundRepository;

    @Autowired
    GameService gameService;
    @GetMapping("/rounds")
    List<Round> all(){
        return roundRepository.findAll();
    }

    @PostMapping("/rounds/{id}")
    Round newRound(@RequestBody Round newRound,@PathVariable Long id){
        Word word = wordService.getRandom();
        newRound.setWord(word);
        newRound.setGame(gameService.findById(id).get());
        return roundRepository.save(newRound);
    }

    @GetMapping("/round")
    public Round round(@RequestParam(value="name",defaultValue = "1") String name){
        return new Round(wordService.getRandom());
    }


}
