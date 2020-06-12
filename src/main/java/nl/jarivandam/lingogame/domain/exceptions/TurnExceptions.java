package nl.jarivandam.lingogame.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TurnExceptions  extends RuntimeException{
    public TurnExceptions(String message){
        super(message);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public static TurnExceptions tooMuchTurnsPlayed(){
        return new TurnExceptions("Only 5 turns are allowed per round");
    }
}
