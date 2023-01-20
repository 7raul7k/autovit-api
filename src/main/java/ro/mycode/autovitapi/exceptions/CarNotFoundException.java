package ro.mycode.autovitapi.exceptions;

public class CarNotFoundException extends Exception {

    public CarNotFoundException() {
        super("Car not found ");
    }
}
