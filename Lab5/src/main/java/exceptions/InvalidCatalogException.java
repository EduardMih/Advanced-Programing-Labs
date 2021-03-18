//Hamza Eduard-Mihail, 2A4
package exceptions;

public class InvalidCatalogException extends Exception{
    public InvalidCatalogException(Exception ex)
    {
        super("Invalid catalog file.", ex);
    }
}
