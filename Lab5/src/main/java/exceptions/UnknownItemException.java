//Hamza Eduard-Mihail, 2A4
package exceptions;

public class UnknownItemException extends AbstractCustomException{
    public UnknownItemException(String message) {
        super("Unknown item in " + message + "operation");
    }
}
