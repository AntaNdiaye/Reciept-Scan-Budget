package directory.exceptions.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("Customer" + userId + " not found");
    }
}
