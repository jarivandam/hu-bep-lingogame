package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.*;
import nl.jarivandam.lingogame.domain.exceptions.TurnExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {
    @Autowired
    WordRepository wordRepository;

    @Autowired
    TurnRepository turnRepository;

    @Autowired
    RoundRepository roundRepository;

    @Autowired
    Validator validator;


    public List<CharPresent> addTurn(Turn newTurn, Long roundId){
        Round round = roundRepository.getOne(roundId);
        if (round.getTurnsPlayed() >= 5){
            throw TurnExceptions.tooMuchTurnsPlayed();
        }
        newTurn.setRound(round);

        Word databaseSearch  = wordRepository.findByWord(newTurn.getGuessedWord().getWord());

        newTurn.setGuessedWord(databaseSearch);
        Turn result = turnRepository.save(newTurn);

        List<CharPresent> returnValue = validator.validate(result.getGuessedWord(),result.getRound().getWord());

        return returnValue;

    }
}
