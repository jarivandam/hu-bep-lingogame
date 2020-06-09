package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class WordService {
    @Autowired
    private WordRepository repository;

    public List<Word> findAll(){
        return (List<Word>) repository.findAll();
    }

    public Optional<Word> findById(Integer id) {

        return repository.findById(id);
    }

    public Word getRandom(){
        Long maxWordNumber = repository.count();
        Long randomNumber = ThreadLocalRandom.current().nextLong(1,maxWordNumber);
        Word word = repository.findById(randomNumber.intValue()).orElse(new Word("Not found"));
        return word;
    }
}
