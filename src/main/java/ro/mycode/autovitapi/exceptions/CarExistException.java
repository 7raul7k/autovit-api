package ro.mycode.autovitapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarExistException extends RuntimeException {

    public CarExistException() {
        super("This car exist!");
    }
}
