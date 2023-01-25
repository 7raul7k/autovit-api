package ro.mycode.autovitapi.exceptions;

public class MakeNotFoundException extends RuntimeException{
    public MakeNotFoundException() {
        super("Make not found");
    }
}
