package nl.jarivandam.lingogame.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "turn")
public class Turn {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    Word guessedWord;

    @ManyToOne
    @JoinColumn(name ="round_id",nullable = false)
    Round round;

    public Word getGuessedWord() {
        return guessedWord;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void setGuessedWord(Word guessedWord) {
        this.guessedWord = guessedWord;
    }
}
