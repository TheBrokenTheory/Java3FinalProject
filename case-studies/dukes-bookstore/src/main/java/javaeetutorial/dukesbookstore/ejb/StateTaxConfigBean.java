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
        request.createState("AL", 4.0);
        request.createState("AK", 0.0);
        request.createState("AZ", 5.6);
        request.createState("AR", 6.50);
        request.createState("CA", 7.25);
        request.createState("CO", 2.90);
        request.createState("CT", 6.35);
        request.createState("DE", 0.00);
        request.createState("FL", 6.00);
        request.createState("GA", 4.00);
        request.createState("HI", 4.00);
        request.createState("ID", 6.00);
        request.createState("IL", 6.25);
        request.createState("IN", 7.00);
        request.createState("IA", 6.00);
        request.createState("KS", 6.00);
        request.createState("KY", 6.00);
        request.createState("LA", 4.45);
        request.createState("ME", 5.50);
        request.createState("MD", 6.00);
        request.createState("MA", 6.25);
        request.createState("MI", 6.00);
        request.createState("MN", 6.875);
        request.createState("MS", 7.00);
        request.createState("MO", 4.225);
        request.createState("MT", 0.00);
        request.createState("NE", 5.50);
        request.createState("NV", 6.85);
        request.createState("NH", 0.00);
        request.createState("NJ", 6.625);
        request.createState("NM", 5.125);
        request.createState("NY", 4.00);
        request.createState("NC", 4.75);
        request.createState("ND", 5.00);
        request.createState("OH", 5.75);
        request.createState("OK", 4.50);
        request.createState("OR", 0.00);
        request.createState("PA", 6.00);
        request.createState("RI", 7.00);
        request.createState("SC", 6.00);
        request.createState("SD", 4.50);
        request.createState("TN", 7.00);
        request.createState("TX", 6.25);
        request.createState("UT", 5.95);
        request.createState("VT", 6.00);
        request.createState("VA", 5.30);
        request.createState("WA", 6.50);
        request.createState("WV", 6.00);
        request.createState("WI", 5.00);
        request.createState("WY", 4.00);
    }
}
