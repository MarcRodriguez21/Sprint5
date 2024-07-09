package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<String> handlerFlowerNotFound(FlowerNotFoundException e, WebRequest request){
        String message = e.getMessage() + " " + request.getDescription(false);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
