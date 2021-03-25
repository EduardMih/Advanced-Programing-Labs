//Hamza Eduard-Mihail, 2A4
package commands;

import exceptions.UnknownItemException;
import exceptions.ViewItemException;
import exceptions.WrongArguments;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveCommand extends AbstractCommand{
    public SaveCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    boolean checkArguments() {
        if(arguments.size() != 0)

            return false;

        return true;
    }

    @Override
    public void execute() throws WrongArguments, UnknownItemException, ViewItemException, IOException
    {
        if(!checkArguments())
            throw new WrongArguments("Save");

        save();

    }

    private void save() throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath())))
        {
            oos.writeObject(catalog);
        }
    }
}
