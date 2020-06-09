package nl.jarivandam.lingogame.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Game {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private List<Round> rounds;

    public long getId() {
        return id;
    }

}
