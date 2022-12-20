package org.example.services;

import org.example.interfaces.DAO;
import org.example.model.Agency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AgencyServices implements DAO<Agency> {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    public AgencyServices(){
        emf = Persistence.createEntityManagerFactory("TP2");
        em = emf.createEntityManager();
    }
    @Override
    public void begin(){
        em.getTransaction().begin();
    }
    @Override
    public boolean create(Agency o){
        em.persist(o);
        return true;
    }
    @Override
    public boolean update(Agency o) {
        em.persist(o);
        return true;
    }
    @Override
    public boolean delete(Agency o) {
        em.remove(o);
        return true;
    }
    @Override
    public Agency findById(int id) {
        return em.find(Agency.class, id);
    }
    @Override
    public void send() {
        em.getTransaction().commit();
    }
    @Override
    public void close() {
        em.close();
        emf.close();
    }
}
