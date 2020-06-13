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

    public long getId() {
        return id;
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
