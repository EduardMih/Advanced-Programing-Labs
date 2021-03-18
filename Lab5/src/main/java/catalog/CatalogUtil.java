//Hamza Eduard-Mihail, 2A4
package catalog;

import catalog.Catalog;
import entries.Item;
import exceptions.InvalidCatalogException;
import exceptions.ViewItemException;

import java.awt.*;
import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath())))
        {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException
    {
        Catalog catalog;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            catalog = (Catalog) (ois.readObject());
        }
        catch (IOException | ClassNotFoundException e1)
        {
            throw new InvalidCatalogException(e1);
        }


        return catalog;

    }

    public static void view(Item item) throws ViewItemException
    {
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.open(new File(item.getLocation()));
        }
        catch(IOException | IllegalArgumentException e1)
        {
            throw new ViewItemException(e1);
        }
    }
}
