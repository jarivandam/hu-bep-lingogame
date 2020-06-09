package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn,Long> {
}
