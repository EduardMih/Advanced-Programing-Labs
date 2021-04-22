package app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
    private static javax.persistence.EntityManagerFactory emf;

    static
    {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static javax.persistence.EntityManagerFactory getEntityManagerFactory()
    {

        return emf;

    }
}
