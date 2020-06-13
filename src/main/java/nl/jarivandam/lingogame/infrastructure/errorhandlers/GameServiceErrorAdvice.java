package nl.jarivandam.lingogame.infrastructure.errorhandlers;

import nl.jarivandam.lingogame.domain.exceptions.GameExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GameServiceErrorAdvice {
    @ExceptionHandler(GameExceptions.class)
    public ResponseEntity<Object> handle(GameExceptions e){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message",e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
