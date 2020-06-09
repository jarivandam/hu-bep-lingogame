package nl.jarivandam.lingogame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Round {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Game game;
    private int turnsPlayed = 0;

    @OneToOne
    private Word word;
    protected Round(){

    }

    public Round(Game game){
        this.game = game;
    }
    public Round(Word word){

        this.word = word;
    }

    public int getTurnsPlayed(){
        return this.turnsPlayed;
    }
    @JsonIgnore
    public Word getWord(){
        return this.word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Game getGame(){
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
