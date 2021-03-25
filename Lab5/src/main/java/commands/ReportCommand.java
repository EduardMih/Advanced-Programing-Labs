//Hamza Eduard-Mihail, 2A4
package commands;

import exceptions.AbstractCustomException;
import exceptions.WrongArguments;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import sun.security.krb5.internal.crypto.Des;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand extends AbstractCommand{
    private Map<String, Object> input = new HashMap<>();
    Configuration cfg = new Configuration(new Version("2.3.31"));

    public ReportCommand(List<String> arguments)
    {
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
    public void execute() throws WrongArguments, IOException, TemplateException, URISyntaxException
    {
        if(!checkArguments())
            throw new WrongArguments("Report");

        cfg.setDirectoryForTemplateLoading(new File(ReportCommand.class.getResource("/templates").toURI()));
        createInput();
        writeReport();
        openReport();


    }

    private void createInput()
    {
        input.put("title", catalog.getName());
        input.put("path", catalog.getPath());
        input.put("items", catalog.getItems());
    }

    private void writeReport() throws IOException, TemplateException
    {
        Template template = cfg.getTemplate("catalog.ftl.html");

        try(Writer writer = new FileWriter(new File("report.html")))
        {
            template.process(input, writer);
        }
    }

    private void openReport() throws IOException
    {
        Desktop desktop = Desktop.getDesktop();

        desktop.open(new File("report.html"));
    }
}
