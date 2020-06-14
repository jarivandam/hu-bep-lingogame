package nl.jarivandam.lingogame.application;

import nl.jarivandam.lingogame.domain.*;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("Turn Service")
@ExtendWith(MockitoExtension.class)
public class TurnServiceTest {
    @Mock
    TurnRepository turnRepository;

    @Mock
    RoundRepository roundRepository;

    @Mock
    WordRepository wordRepository;

    @Spy
    Validator validator = new Validator();

    @InjectMocks
    TurnService turnService;

    @Test
    @DisplayName("Add new turn")
    public void newTurn(){
        Word word = new Word("hello");
        Round testRound = new Round(word);
        List<Turn> turns = new ArrayList<Turn>();
        Turn testTurn = new Turn();
        testTurn.setWon(true);
        testTurn.setGuessedWord(word);
        turns.add(testTurn);

        testRound.setTurns(turns);
        List< Round > rounds = new ArrayList<Round>();
        rounds.add(testRound);

        when(roundRepository.getOne(Mockito.anyLong())).thenReturn(testRound);
        when(wordRepository.findByWord(Mockito.anyString())).thenReturn(word);

        List<CharPresent> expectedResult = new ArrayList<>();
        expectedResult.add(CharPresent.GOOD);
        expectedResult.add(CharPresent.GOOD);
        expectedResult.add(CharPresent.GOOD);
        expectedResult.add(CharPresent.GOOD);
        expectedResult.add(CharPresent.GOOD);

        List<CharPresent> result =  turnService.addTurn(testTurn,Long.valueOf(1));

        assertEquals(expectedResult.toArray()[0],result.toArray()[0]);
        assertEquals(expectedResult.toArray()[1],result.toArray()[1]);
        assertEquals(expectedResult.toArray()[2],result.toArray()[2]);
        assertEquals(expectedResult.toArray()[3],result.toArray()[3]);
        assertEquals(expectedResult.toArray()[4],result.toArray()[4]);

    }
}
