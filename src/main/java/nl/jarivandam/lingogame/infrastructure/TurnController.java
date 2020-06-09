package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.TurnRepository;
import nl.jarivandam.lingogame.domain.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurnController {
    @Autowired
    TurnRepository turnRepository;

    @GetMapping("/turns")
    List<Turn> all(){
        return turnRepository.findAll();
    }
    @GetMapping("/turns/{id}")
    Turn single(@PathVariable Long id){
        return turnRepository.findById(id).get();
    }

    @PostMapping("/turns")
    Turn newTurn(@RequestBody Turn newTurn){
        return turnRepository.save(newTurn);
    }

}
