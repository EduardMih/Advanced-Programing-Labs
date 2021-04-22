package app;

import model.MovieEntity;
import repository.MovieRepository;

import javax.persistence.*;
import javax.persistence.EntityManager;


public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf= MyEntityManagerFactory.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        MovieEntity movie;
        MovieRepository movieRepository = new MovieRepository(em);

        //em.getTransaction().begin();
        movie = new MovieEntity();
        movie.setTitle("The Journal");
        movie.setDuration(110);
        movie.setScore((float)(9.8));

        /*em.persist(movie);
        em.getTransaction().commit();


        em.close();
        emf.close();*/

        movieRepository.create(movie);
        System.out.println(movieRepository.findByName("The Journal"));
        System.out.println(movieRepository.findById(1));

    }
}
