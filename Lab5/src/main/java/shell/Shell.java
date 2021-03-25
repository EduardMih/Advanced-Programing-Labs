//Hamza Eduard-Mihail, 2A4
package shell;

import exceptions.*;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Shell {
    private Scanner s;
    private CommandExecutor commandExecutor;

    public void runShell()
    {
        String line;
        s = new Scanner(System.in);

        while(true)
        {
            line = s.nextLine();
            commandExecutor = new CommandExecutor(line);

            try {
                commandExecutor.execute();
            } catch (AbstractCustomException | IOException | TemplateException | URISyntaxException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
