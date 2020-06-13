package nl.jarivandam.lingogame.domain.exceptions;

public class RoundExceptions extends RuntimeException{
    public RoundExceptions(String message){
        super(message);
    }
    public static RoundExceptions roundNotFound(){
        return new RoundExceptions("Round not found");
    }
}
