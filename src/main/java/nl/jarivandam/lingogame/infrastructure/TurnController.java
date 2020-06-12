package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.RoundRepository;
import nl.jarivandam.lingogame.application.TurnRepository;
import nl.jarivandam.lingogame.application.TurnService;
import nl.jarivandam.lingogame.application.WordRepository;
import nl.jarivandam.lingogame.domain.CharPresent;
import nl.jarivandam.lingogame.domain.Turn;
import nl.jarivandam.lingogame.domain.Validator;
import nl.jarivandam.lingogame.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurnController {
    @Autowired
    TurnRepository turnRepository;

//    @Autowired
//    RoundRepository roundRepository;

//    @Autowired
//    WordRepository wordRepository;

    @Autowired
    TurnService service;


    @GetMapping("/turns")
    List<Turn> all(){
        return turnRepository.findAll();
    }
    @GetMapping("/turns/{id}")
    Turn single(@PathVariable Long id){
        return turnRepository.findById(id).get();
    }

    @PostMapping("/round/{roundId}/turns")
    List<CharPresent> newTurn(@RequestBody Turn newTurn,@PathVariable Long roundId){
            return service.addTurn(newTurn,roundId);
    }

}
