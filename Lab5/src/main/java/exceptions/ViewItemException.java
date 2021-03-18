//Hamza Eduard-Mihail, 2A4
package exceptions;

public class ViewItemException extends Exception{
    public ViewItemException(Exception ex) {
        super("Invalid item location", ex);
    }
}
