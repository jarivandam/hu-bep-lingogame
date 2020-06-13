package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {
}

