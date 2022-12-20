package org.example.services;

import org.example.interfaces.DAO;
import org.example.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccountServices implements DAO<Account> {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    public AccountServices(){
        emf = Persistence.createEntityManagerFactory("TP2");
        em = emf.createEntityManager();
    }
    @Override
    public void begin() {
        em.getTransaction().begin();
    }

    @Override
    public boolean create(Account o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean update(Account o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean delete(Account o) {
        em.remove(o);
        return true;
    }

    @Override
    public Account findById(int id) {
        return em.find(Account.class, id);
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
