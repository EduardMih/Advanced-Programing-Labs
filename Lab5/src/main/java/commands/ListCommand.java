//Hamza Eduard-Mihail, 2A4
package commands;

import catalog.Catalog;
import exceptions.WrongArguments;

import java.util.List;

public class ListCommand extends AbstractCommand{
    public ListCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void execute() throws WrongArguments {
        if(!checkArguments())
            throw new WrongArguments("List");

        list();
    }

    boolean checkArguments()
    {
        if(!arguments.isEmpty())

            return false;

        return true;
    }

    private void list()
    {
        System.out.println("Catalog " + catalog.getName() + ":");
        catalog.getItems().stream()
                .forEach(System.out::println);
    }
}
