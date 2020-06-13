package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Game;
import nl.jarivandam.lingogame.domain.Round;
import nl.jarivandam.lingogame.domain.Score;
import nl.jarivandam.lingogame.domain.exceptions.GameExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Game> findAll(){
        return (List<Game>) gameRepository.findAll();
    }

    public Optional<Game> findById(Long id){
        return gameRepository.findById(id);
    }

    public void startGame(){
        this.gameRepository.save(new Game());
    }

    public Score endGame(Long id, Score score){
        Game game = this.gameRepository.findById(id).orElseThrow(() -> GameExceptions.gameNotFound());
        Integer scoreValue = 0;
        for (Round round: game.getRounds()){
            if(round.won()){
                scoreValue += 50;
            }
        }
        score.setScore(scoreValue);
        return scoreRepository.save(score);
    }
}
