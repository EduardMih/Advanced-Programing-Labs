package raport;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import model.Movie;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HtmlRaportGenerator {
    private static Map<String, Object> input = new HashMap<>();
    private Configuration cfg = new Configuration(new Version("2.3.31"));

    public void generateMovieReport(Movie movie) throws IOException, TemplateException, URISyntaxException
    {
        createInput(movie);
        writeReport();
        openReport();


    }

    private void createInput(Movie movie)
    {
        input.put("movie", movie);
    }

    private void writeReport() throws IOException, TemplateException, URISyntaxException
    {
        cfg.setDirectoryForTemplateLoading(new File(HtmlRaportGenerator.class.getResource("/templates").toURI()));
        Template template = cfg.getTemplate("ReportTemplate.ftl");

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
