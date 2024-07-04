package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity<String> handleBranchNotFoundException(BranchNotFoundException ex, WebRequest request) {
        String message = ex.getMessage() + " " + request.getDescription(false);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
