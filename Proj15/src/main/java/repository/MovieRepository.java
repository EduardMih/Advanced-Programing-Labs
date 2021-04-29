package repository;

import model.MovieEntity;

import javax.persistence.EntityManager;

public class MovieRepository {
    private EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }

    public MovieEntity findByName(String name)
    {
        MovieEntity movieEntity;
        em.getTransaction().begin();

        movieEntity = (MovieEntity) em.createNamedQuery("MoviesEntity.findByName").setParameter("name", name)
                .setMaxResults(1)
                .getSingleResult();
        em.getTransaction().commit();


        return movieEntity;

    }

    public MovieEntity findById(Integer id)
    {
        MovieEntity movieEntity;
        em.getTransaction().begin();

        movieEntity = (MovieEntity) em.createNamedQuery("MoviesEntity.findById").setParameter("id", id)
                .getSingleResult();
        em.getTransaction().commit();

        return movieEntity;

    }

    public void create(MovieEntity movie)
    {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
    }
}
