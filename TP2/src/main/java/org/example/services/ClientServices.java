package org.example.services;

import org.example.interfaces.DAO;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientServices implements DAO<Client> {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    public ClientServices(){
        emf = Persistence.createEntityManagerFactory("TP2");
        em = emf.createEntityManager();
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
    }

    @Override
    public boolean create(Client o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean update(Client o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean delete(Client o) {
        em.remove(o);
        return true;
    }

    @Override
    public Client findById(int id) {
        return em.find(Client.class, id);
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
