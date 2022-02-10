/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ai365ak
 */
public class JpaCrud {
    public  void createRecord()
    {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager entityManager = emf.createEntityManager();

 entityManager.getTransaction().begin();

 Model p = new Model();
 p.setOperation("allOperationHappend");
 entityManager.persist(p);

 entityManager.getTransaction().commit();
    }
  public  void retrieveRecord()
  { 
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
 EntityManager entityManager = emf.createEntityManager();
      entityManager.getTransaction().begin();

 entityManager.getTransaction().commit();
  }
  public  void updateRecord()
  {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
 EntityManager entityManager = emf.createEntityManager();
      entityManager.getTransaction().begin();

 entityManager.getTransaction().commit();
  }
  public  void deleteRecord() 
  {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
 EntityManager entityManager = emf.createEntityManager();
      entityManager.getTransaction().begin();

 entityManager.getTransaction().commit();
  }
    
}
