package mk.ukim.finki.hci.coinsmart.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{
    public InvalidUsernameOrPasswordException(){
        super("Invalid username or password!");
    }
}