package nl.jarivandam.lingogame.domain;

import javax.persistence.*;

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

    public boolean won;

    public Word getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(Word guessedWord) {
        this.guessedWord = guessedWord;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
