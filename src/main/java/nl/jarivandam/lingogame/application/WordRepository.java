package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word,Integer>{
}