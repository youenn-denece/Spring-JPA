/*
package org.example.services;

import org.example.interfaces.DAO;
import org.example.model.Client;

public class ClientServices implements DAO<Client> {
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

}
*/
