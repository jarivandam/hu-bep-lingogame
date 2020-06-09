package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        return (List<Game>) gameRepository.findAll();
    }

    public Optional<Game> findById(Long id){
        return gameRepository.findById(id);
    }

    public void startGame(){
        this.gameRepository.save(new Game());
    }
}
