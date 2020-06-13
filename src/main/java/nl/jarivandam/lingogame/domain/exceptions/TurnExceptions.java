package nl.jarivandam.lingogame.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TurnExceptions  extends RuntimeException{
    public TurnExceptions(String message){
        super(message);
    }

    public static TurnExceptions tooMuchTurnsPlayed(){
        return new TurnExceptions("Only 5 turns are allowed per round");
    }
    public static TurnExceptions turnNotFound(){
        return new TurnExceptions("Turn not found");
    }
}
