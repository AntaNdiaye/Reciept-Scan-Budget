package exceptions.user;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(Long userId) {
        super("Custer " + userId + " already present in db");
    }
}
