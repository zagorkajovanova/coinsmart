package mk.ukim.finki.hci.coinsmart.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("Passwords do not match!!!");
    }
}

