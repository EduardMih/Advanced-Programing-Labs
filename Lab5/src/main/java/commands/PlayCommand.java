//Hamza Eduard-Mihail, 2A4
package commands;

import entries.Item;
import exceptions.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayCommand extends AbstractCommand{
    public PlayCommand(List<String> arguments) {
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
    public void execute() throws WrongArguments, ViewItemException, InexistentItemException
    {
        if(!checkArguments())
            throw new WrongArguments("Play");

        play();
    }

    private void play() throws ViewItemException, InexistentItemException
    {
        Desktop desktop = Desktop.getDesktop();
        Item item;
        item = catalog.findById(arguments.get(0));

        if(item == null)
            throw new InexistentItemException("Item doesn't exists");

        try {
            desktop.open(new File(item.getLocation()));
        }
        catch(IOException | IllegalArgumentException e1)
        {
            throw new ViewItemException();
        }
    }
}
