package app;

import model.ChartEntity;
import model.MovieEntity;
import repository.ChartRepository;
import repository.MovieRepository;

import javax.persistence.*;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf= MyEntityManagerFactory.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        MovieRepository movieRepository = new MovieRepository(em);
        ChartRepository chartRepository = new ChartRepository(em);
        ChartEntity chartEntity = new ChartEntity();


        chartEntity.setName("My Chart2");
        chartEntity.setCreationDate(LocalDate.now());
        chartEntity.addMovie(movieRepository.findById(12));
        chartEntity.addMovie(movieRepository.findById(89));

        chartRepository.create(chartEntity);

        System.out.println(chartRepository.findByName("My Chart2"));


        em.close();
        emf.close();
    }
}
