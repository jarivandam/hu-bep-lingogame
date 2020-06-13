package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.ScoreRepository;
import nl.jarivandam.lingogame.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("scores")

public class ScoreController {

    @Autowired
    ScoreRepository repository;

    @GetMapping()
    List<Score> allScores(){
        return repository.findAll();
    }

    @GetMapping("/highscores")
    List<Score> highScores(){
        return repository.findAll(Sort.by(Sort.Direction.DESC,"score"));
    }

}
