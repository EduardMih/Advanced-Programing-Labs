//Hamza Eduard-Mihail, 2A4
package exceptions;

public class WrongArguments extends AbstractCustomException{
    public WrongArguments(String message) {
        super("Wrong arguments in command " + message);
    }
}
