package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.GameService;
import nl.jarivandam.lingogame.application.RoundRepository;
import nl.jarivandam.lingogame.application.WordService;
import nl.jarivandam.lingogame.domain.Round;
import nl.jarivandam.lingogame.domain.Word;
import nl.jarivandam.lingogame.domain.exceptions.RoundExceptions;
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

    @GetMapping("/rounds/{id}")
    Round singleRound(@PathVariable Long id){
        return roundRepository.findById(id).orElseThrow(() -> RoundExceptions.roundNotFound());
    }


    @PostMapping("/rounds/{id}")
    Round newRound(@PathVariable Long id){
        Round newRound = new Round(gameService.findById(id).get());
        Word word = wordService.getRandom();
        newRound.setWord(word);
        return roundRepository.save(newRound);
    }

    @GetMapping("/round")
    public Round round(@RequestParam(value="name",defaultValue = "1") String name){
        return new Round(wordService.getRandom());
    }


}
