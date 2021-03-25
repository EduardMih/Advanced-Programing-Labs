//Hamza Eduard-Mihail, 2A4
package shell;

import commands.*;
import exceptions.*;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CommandExecutor {
    private String line;
    private String command;
    private List<String> arguments;
    private StringTokenizer tokenizer;
    private Command comm;
    public CommandExecutor(String line) {
        this.line = line;
    }

    public void execute() throws AbstractCustomException, IOException, TemplateException, URISyntaxException
    {
        tokenizeLine();
        createCommand();
        comm.execute();

    }

    private void tokenizeLine()
    {
        tokenizer = new StringTokenizer(line);
        arguments = new ArrayList<>();

        command = tokenizer.nextToken();

        while(tokenizer.hasMoreTokens())
        {
            arguments.add(tokenizer.nextToken());
        }
    }

    private void createCommand() throws UnknownCommandException
    {
        switch(command)
        {
            case "List":
                comm = new ListCommand(arguments);
                break;
            case "Add":
                comm = new AddCommand(arguments);
                break;
            case "Play":
                comm = new PlayCommand(arguments);
                break;
            case "Save":
                comm = new SaveCommand(arguments);
                break;
            case "Load":
                comm = new LoadCommand(arguments);
                break;
            case "Report":
                comm = new ReportCommand(arguments);
                break;
            case "Info":
                comm = new InfoCommand(arguments);
                break;
            case "Exit":
                comm = new ExitCommand(arguments);
                break;
            default:
                throw new UnknownCommandException();
        }
    }
}
