//Hamza Eduard-Mihail, 2A4
package commands;

import entries.Item;
import exceptions.AbstractCustomException;
import freemarker.template.TemplateException;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InfoCommand extends AbstractCommand{
    public InfoCommand(List<String> arguments) {
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
    public void execute() throws IOException
    {
        Item item = catalog.findById(arguments.get(0));
        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        tika.parse(Files.newInputStream(Paths.get(item.getLocation())),metadata);

        System.out.println(metadata);
    }
}
