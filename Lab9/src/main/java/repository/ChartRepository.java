package repository;

import model.ChartEntity;
import model.MovieEntity;

import javax.persistence.EntityManager;

public class ChartRepository {
    private EntityManager em;

    public ChartRepository(EntityManager em)
    {
        this.em = em;
    }

    public ChartEntity findByName(String name)
    {
        ChartEntity chartEntity;
        em.getTransaction().begin();

        chartEntity = (ChartEntity) em.createNamedQuery("ChartEntity.findByName").setParameter("name", name)
                .setMaxResults(1)
                .getSingleResult();
        em.getTransaction().commit();


        return chartEntity;

    }

    public ChartEntity findById(Integer id)
    {
        ChartEntity chartEntity;
        em.getTransaction().begin();

        chartEntity = (ChartEntity) em.createNamedQuery("ChartEntity.findById").setParameter("id", id)
                .getSingleResult();
        em.getTransaction().commit();

        return chartEntity;

    }

    public void create(ChartEntity chart)
    {
        em.getTransaction().begin();
        em.persist(chart);
        em.getTransaction().commit();
    }
}
