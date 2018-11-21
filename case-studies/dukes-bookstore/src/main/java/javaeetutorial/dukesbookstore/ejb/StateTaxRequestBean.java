/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.dukesbookstore.ejb;


import javaeetutorial.dukesbookstore.entity.StateTax;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <p>Stateful session bean for the bookstore example.</p>
 */
@Stateful
public class StateTaxRequestBean {

    @PersistenceContext
    private EntityManager em;
            
    public StateTaxRequestBean() throws Exception {
    }

    public void createState(String stateCode, Double taxRate) {
        try {
            StateTax state = new StateTax(stateCode,taxRate);       
            em.persist(state);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
 
    
}
