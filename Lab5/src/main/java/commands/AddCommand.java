//Hamza Eduard-Mihail, 2A4
package commands;




import entries.Book;
import entries.Item;
import entries.Movie;
import exceptions.UnknownItemException;
import exceptions.WrongArguments;

import java.util.List;

public class AddCommand extends AbstractCommand{
    public AddCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void execute() throws WrongArguments, UnknownItemException
    {
        if(!checkArguments())
            throw new WrongArguments("Add");

        add();
    }

    @Override
    boolean checkArguments()
    {
        if(arguments.size() != 4)

            return false;

        return true;

    }

    private void add() throws UnknownItemException
    {
        Item item;
        switch(arguments.get(0))
        {
            case "Book":
                item = new Book(arguments.get(1), arguments.get(2), arguments.get(3));
                break;
            case "Movie":
                item = new Movie(arguments.get(1), arguments.get(2), arguments.get(3));
                break;
            default:
                throw new UnknownItemException("Add");
        }
        catalog.getItems().add(item);
    }
}
