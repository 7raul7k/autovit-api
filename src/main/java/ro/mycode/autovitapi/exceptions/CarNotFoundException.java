package ro.mycode.autovitapi.exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException() {
        super("Car not found ");
    }
}
