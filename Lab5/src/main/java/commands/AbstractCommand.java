//Hamza Eduard-Mihail, 2A4
package commands;

import catalog.Catalog;

import java.util.List;

public abstract class AbstractCommand implements Command {
    protected static Catalog catalog = new Catalog("MyCatalog", "d:/MyCatalog.ser");
    protected List<String> arguments;

    public AbstractCommand(List<String> arguments) {
        this.arguments = arguments;
    }
    abstract boolean checkArguments();

}
