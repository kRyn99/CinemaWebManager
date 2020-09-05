/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Customers;

/**
 *
 * @author duckh
 */
public class HomePageAction extends ActionSupport {
    EntityManager em = Persistence.createEntityManagerFactory("CinemaWebManagerPU").createEntityManager();
    List<Customers> customers;

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
    
    public HomePageAction() {
    }
    
    public String Prepare(){
        em.getTransaction().begin();
        Integer primaryKey = 1;
        customers = new ArrayList<>();
        Customers cm = em.find(Customers.class, primaryKey);
        customers.add(cm);

        System.out.println(cm.getName());
        System.out.println(cm.getCitizenID());
        System.out.println(cm.getBirthDate());
        
        em.getTransaction().commit();
        em.close();
        return "prepare";
    }
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
