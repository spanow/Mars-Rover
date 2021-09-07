package marsrover.exceptions;

public class InvalideCoordinateException extends RuntimeException{

    public InvalideCoordinateException(){
        super("The coordinate cannot be negative");
    }
}
