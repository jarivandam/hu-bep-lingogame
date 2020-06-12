package nl.jarivandam.lingogame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "round")
public class Round {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Game game;

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

    @OneToMany(mappedBy = "round",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Turn> turns = new ArrayList<Turn> ();

    public int getTurnsPlayed(){
        return this.turns.size();
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
