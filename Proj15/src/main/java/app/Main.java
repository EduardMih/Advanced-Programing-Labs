package app;

import model.ChartEntity;
import model.ChartMovieEntity;
import model.MovieEntity;
import repository.MovieRepository;

import javax.persistence.*;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf= MyEntityManagerFactory.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        MovieEntity movie;
        MovieRepository movieRepository = new MovieRepository(em);
        List<MovieEntity> movies = new ArrayList<>();
        ChartEntity chartEntity = new ChartEntity();

        movies.add(movieRepository.findById(1));
        movies.add(movieRepository.findById(2));

        chartEntity.setName("My Chart");
        chartEntity.setCreationDate(LocalDate.now());

        em.getTransaction().begin();
        em.persist(chartEntity);
        em.getTransaction().commit();

        System.out.println(chartEntity);

        chartEntity.addMovie(new ChartMovieEntity(movies.get(0), chartEntity));
        chartEntity.addMovie(new ChartMovieEntity(movies.get(1), chartEntity));

        em.getTransaction().begin();
        em.persist(chartEntity);
        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
