package org.example.services;

import org.example.interfaces.IDAO;
import org.example.model.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class ProduitService implements IDAO<Produit> {

    private EntityManagerFactory emf;
    private EntityManager em;
    public ProduitService(){
        emf = Persistence.createEntityManagerFactory("TP1");
        em = emf.createEntityManager();
    }
    @Override
    public void begin() {
        em.getTransaction().begin();
    }
    @Override
    public boolean create(Produit o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean update(Produit o) {
        em.persist(o);
        return true;
    }
    @Override
    public boolean delete(Produit o) {
        em.remove(o);
        return true;
    }

    @Override
    public List<Produit> findAll() {
        Query q1 = em.createQuery("select p from Produit p");
        List<Produit> list = q1.getResultList();
        return list;
    }
    @Override
    public List<Produit> selectByPrice(Double min) {
        List result = em.createNativeQuery("SELECT id, marque, reference, prix FROM Produit WHERE prix >=" + min, Produit.class).getResultList();
        return result;
    }

    @Override
    public List<Produit> selectBetweenDate(Date min, Date max) throws Exception {
        if(min.before(max)){
            Query query= em.createQuery("select p from Produit  p where dateAchat >= :min and dateAchat <= :max");
            query.setParameter("min",min);
            query.setParameter("max",max);
            return query.getResultList();

        }
        throw new Exception("error date");
    }

    @Override
    public List<Produit> selectByMarque(String marque) {
        Query query = em.createQuery("SELECT p FROM Produit p WHERE marque = :marque");
        query.setParameter("marque", marque);
        List<Produit> list = query.getResultList();
        return list;
    }

    @Override
    public double sumByMarque(String marque) {
        Query query = em.createQuery("select sum(prix) from Produit p where marque = :marque");
        query.setParameter("marque", marque);
        return (double) query.getSingleResult();
    }
    @Override
    public Produit findById(int id) {
        return em.find(Produit.class,id);
    }
    @Override
    public void envoie() {
        em.getTransaction().commit();
    }
    @Override
    public void close() {
    em.close();
    emf.close();
    }
}
