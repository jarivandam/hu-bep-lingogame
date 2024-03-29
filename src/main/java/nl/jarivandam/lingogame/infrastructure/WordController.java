package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.application.WordRepository;
import nl.jarivandam.lingogame.application.WordService;
import nl.jarivandam.lingogame.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {
    @Autowired
    WordService wordService;

    @Autowired
    WordRepository wordRepository;

    @GetMapping("/words")
    public List<Word> getWords(){
        List<Word> words = (List<Word>) wordService.findAll();

        return words;
    }
    @GetMapping("/randomWord")
    public Word getRandomWord(){
            return wordService.getRandom();
    }

    @PostMapping("/words")
    public Word newWord(@RequestBody Word newWord){
        return wordRepository.save(newWord);
    }
}
