package directory.exceptions;

import directory.exceptions.receipt.ReceiptAlreadyExistsException;
import directory.exceptions.receipt.ReceiptNotFoundException;
import directory.exceptions.user.UserAlreadyExistsException;
import directory.exceptions.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> handleException(GlobalException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request );
    }

    @ExceptionHandler({
            ReceiptAlreadyExistsException.class,
            UserAlreadyExistsException.class,
    })
    public ResponseEntity<Object> handleAlreadyExistsExceptions( RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request );

    }

    @ExceptionHandler({
            ReceiptNotFoundException.class,
            UserNotFoundException.class,
    })
    public ResponseEntity<Object> handleNotFoundExceptions( RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request );

    }
}
