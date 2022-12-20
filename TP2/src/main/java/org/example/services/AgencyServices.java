/*
package org.example.services;

import org.example.interfaces.DAO;
import org.example.model.Agency;

public class AgencyServices implements DAO<Agency> {
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
}
*/
