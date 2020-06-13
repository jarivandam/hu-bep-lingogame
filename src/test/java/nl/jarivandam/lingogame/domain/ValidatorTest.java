package nl.jarivandam.lingogame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Check validation rules of words")
public class ValidatorTest {
    private Validator validator;
    private List<CharPresent> expected;
    private List<CharPresent> result;
    private Word goodWord;
    private Word guesedWord;
    @BeforeEach
    public void setUp(){
        this.validator = new Validator();
        this.expected = new ArrayList<CharPresent>();
        this.result = new ArrayList<CharPresent>();
    }

    @Test
    public void correctWordTest(){
        this.goodWord = new Word("aapje");
        this.guesedWord = new Word("aapje");

        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
    }
    @Test
    public void allLettersOccur(){
        this.goodWord = new Word("antiek");
        this.guesedWord = new Word("intake");

        this.expected.add(CharPresent.CONTAINS);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.CONTAINS);
        this.expected.add(CharPresent.CONTAINS);
        this.expected.add(CharPresent.CONTAINS);
    }
    @Test
    public void oneletterWrong(){
        this.goodWord = new Word("draai");
        this.guesedWord = new Word("draad");

        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.FAULT);
    }

    @Test
    public void letterOccursTwiceInGuess(){
        this.goodWord = new Word("drang");
        this.guesedWord = new Word("draai");

        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
    }

    @Test
    public void twoWordsOnSameValidator(){
        this.goodWord = new Word("drang");
        this.guesedWord = new Word("draai");

        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
        this.checkResult();

        this.expected = new ArrayList<CharPresent>();
        this.guesedWord = new Word("delen");
        this.expected.add(CharPresent.GOOD);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.CONTAINS);

    }

    @Test
    public void testWithEmptyGuesedWord(){
        this.goodWord = new Word("drang");
        this.guesedWord = null;

        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
        this.expected.add(CharPresent.FAULT);
    }

    @AfterEach
    public void checkResult(){
        this.result = this.validator.validate(guesedWord,goodWord);

        assertEquals(this.expected,this.result);
    }

}
