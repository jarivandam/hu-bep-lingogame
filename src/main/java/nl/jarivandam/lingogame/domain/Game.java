package nl.jarivandam.lingogame.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "game",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Round> rounds;

    public Game(){

    };
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
