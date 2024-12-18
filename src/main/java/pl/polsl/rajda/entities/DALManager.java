/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.rajda.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author radoslawrajda
 */
public class DALManager {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl.rajda.webJPA.0PU");
    private final EntityManager em = emf.createEntityManager();
    
    public void persistObject(Object object) {
        
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace(); // replace with proper message for the client
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<BergerTableEntity> findObjects() {
        List<BergerTableEntity> tableList = null;
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT p FROM BERGERTABLEETNITY p");
            tableList = query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace(); // replace with proper message for the client
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return tableList;
    }
}
