package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word,Integer> {
    Word findByWord(String wordString);
}