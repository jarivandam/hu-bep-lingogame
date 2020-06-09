package nl.jarivandam.lingogame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;

@Entity
public class Turn {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    Word guessedWord;





}
