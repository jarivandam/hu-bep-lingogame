package nl.jarivandam.lingogame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private int id;
    private String word;

    protected Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
    public int getId() {return id;}
    public List<Character> wordAsChars(){
        List<Character> result = new ArrayList<Character>();
        for(char c : this.word.toCharArray()){
            result.add(c);
        }
        return result;
    }

    public Set<Character> wordAsCharsSet(){
        Set<Character> result = new HashSet<Character>() {};
        for(char c : this.word.toCharArray()){
            result.add(c);
        }
        return result;
    }
}
