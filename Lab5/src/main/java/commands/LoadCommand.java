//Hamza Eduard-Mihail, 2A4
package commands;

import catalog.Catalog;
import exceptions.InvalidCatalogException;
import exceptions.UnknownItemException;
import exceptions.ViewItemException;
import exceptions.WrongArguments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadCommand extends AbstractCommand{
    public LoadCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    boolean checkArguments()
    {

        if(arguments.size() != 1)

            return false;

        return true;

    }

    @Override
    public void execute() throws WrongArguments, UnknownItemException, ViewItemException, IOException, InvalidCatalogException
    {
        if(!checkArguments())
            throw new WrongArguments("Load");

        catalog = load();

    }

    private Catalog load() throws InvalidCatalogException
    {
        Catalog catalog;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arguments.get(0))))
        {
            catalog = (Catalog) (ois.readObject());
        }
        catch (IOException | ClassNotFoundException e1)
        {
            throw new InvalidCatalogException();
        }


        return catalog;
    }
}
