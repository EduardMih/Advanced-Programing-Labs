package commands;

import exceptions.AbstractCustomException;
import exceptions.WrongArguments;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    boolean checkArguments()
    {

        if(arguments.size() != 0)

            return false;

        return true;

    }

    @Override
    public void execute() throws AbstractCustomException, IOException, TemplateException, URISyntaxException
    {
        if(!checkArguments())
            throw new WrongArguments("Exit");

        System.exit(0);


    }
}
