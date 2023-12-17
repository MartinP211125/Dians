package mk.ukim.finki.dians.model.exceptions;

public class PasswordsDoNotMatchException extends Exception{
    public PasswordsDoNotMatchException(){
        super("Password does not match");
    }
}
