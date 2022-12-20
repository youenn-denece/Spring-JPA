/*
package org.example.services;

import org.example.interfaces.DAO;
import org.example.model.Account;

public class AccountServices implements DAO<Account> {
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

}
*/
