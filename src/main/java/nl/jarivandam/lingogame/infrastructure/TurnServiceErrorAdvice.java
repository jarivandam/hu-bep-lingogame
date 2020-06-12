package nl.jarivandam.lingogame.infrastructure;

import nl.jarivandam.lingogame.domain.exceptions.TurnExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class TurnServiceErrorAdvice {

    @ExceptionHandler(TurnExceptions.class)
    public ResponseEntity<Object> handle(TurnExceptions e, WebRequest request){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message",e.getMessage());
        return new ResponseEntity<>(body,HttpStatus.CONFLICT);
    };

}
