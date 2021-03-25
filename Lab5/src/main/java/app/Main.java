//Hamza Eduard-Mihail, 2A4
package app;

import catalog.Catalog;
import catalog.CatalogUtil;
import entries.Book;
import entries.Movie;
import exceptions.InvalidCatalogException;
import exceptions.ViewItemException;
import shell.Shell;

import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        Main app = new Main();
        Shell shell = new Shell();
        shell.runShell();

    }

    private void testCreateSave() //from Compulsory, not used anymore
    {
        Catalog catalog = new Catalog("My Books", "d:/catalog.ser");
        Book book = new Book("B01", "bestBook");
        Movie movie = new Movie("M01", "bestMovie");
        book.setLocation("c:/Users/Eduard/Documents/Proiect bd/Tablouri asociative.pptx");
        movie.setLocation("d:/WebSite/Screenshot 2021-01-26 103841.png");
        catalog.add(book);
        catalog.add(movie);

        try
        {
            CatalogUtil.save(catalog);
        }
        catch (IOException e)
        {
            System.out.println("Catalog save file path exception");
        }


    }

    private void testLoadView() //from Compulsory, not used anymore
    {
        try {
            Catalog catalog = CatalogUtil.load("d:/catalog.ser");
            CatalogUtil.view(catalog.findById("B01"));
            CatalogUtil.view(catalog.findById("M01"));
        }
        catch (InvalidCatalogException | ViewItemException e1)
        {
            System.out.println(e1.getMessage());
        }
    }
}
