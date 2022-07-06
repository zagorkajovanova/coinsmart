package mk.ukim.finki.hci.coinsmart.model.exceptions;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(Long id){
        super(String.format("Invalid user: %d", id));
    }
}
