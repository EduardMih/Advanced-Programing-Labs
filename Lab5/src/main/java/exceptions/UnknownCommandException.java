//Hamza Eduard-Mihail, 2A4
package exceptions;

public class UnknownCommandException extends AbstractCustomException{
    public UnknownCommandException() {
        super("Unknown command");
    }
}
