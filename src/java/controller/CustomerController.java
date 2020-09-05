/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Customers;

/**
 *
 * @author duckh
 */
public class CustomerController {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CinemaWebManagerPU");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Integer primaryKey = 1;
        Customers cm = entityManager.find(Customers.class, primaryKey);

        System.out.println(cm.getName());
        System.out.println(cm.getCitizenID());
        System.out.println(cm.getBirthDate());
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        factory.close();
    }
}
