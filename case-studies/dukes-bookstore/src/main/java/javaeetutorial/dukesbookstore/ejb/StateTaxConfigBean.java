/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.dukesbookstore.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * <p>Singleton bean that initializes the book database for the bookstore
 * example.</p>
 */
@Singleton
@Startup
public class StateTaxConfigBean {

    @EJB
    private StateTaxRequestBean request;

    @PostConstruct
    public void createData() {
        request.createState("Al", 4.0);
   

    }
}
