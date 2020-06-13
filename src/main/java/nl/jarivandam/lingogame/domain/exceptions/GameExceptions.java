package nl.jarivandam.lingogame.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GameExceptions  extends RuntimeException{
    public GameExceptions(String message){
        super(message);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static GameExceptions gameNotFound(){
        return new GameExceptions("Game not found");
    }
}
