/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jonas
 */
public class PetFacade implements IPetFacade{
    
    EntityManagerFactory emf;

public PetFacade(EntityManagerFactory emf){
    this.emf = emf;
}

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Pet> getPets() {
        EntityManager em = emf.createEntityManager();
        List<Pet> pets = null;
        try{
            em.getTransaction().begin();
            pets = em.createNamedQuery("Pet.findAll").getResultList();
            em.getTransaction().commit();
        }finally{
            em.close();
        }
      return pets;
    }
    }
    

