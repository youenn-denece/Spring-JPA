package org.example.interfaces;

import org.example.model.Produit;

import java.util.Date;
import java.util.List;

public interface IDAO<T> {

    void begin();
    boolean create(T o);

    List<T> findAll();
    List<T> selectByPrice(Double min);

    List<T> selectByMarque(String marque);
    List<Produit> selectBetweenDate(Date min, Date max) throws Exception;
    boolean update(T o);
    boolean delete(T o);
    double sumByMarque(String marque);

    T findById(int id);
    void envoie();
    void close();
}
