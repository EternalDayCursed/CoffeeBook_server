package Larome.CoffeeBook_server.exceptions;

public class UserNotCreatedException extends RuntimeException{
    public UserNotCreatedException(String msg) {
        super(msg);
    }
}
