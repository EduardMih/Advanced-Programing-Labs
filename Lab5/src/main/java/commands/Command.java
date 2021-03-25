//Hamza Eduard-Mihail, 2A4
package commands;

import catalog.Catalog;
import exceptions.*;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Command {
    void execute() throws AbstractCustomException, IOException, TemplateException, URISyntaxException;
}
