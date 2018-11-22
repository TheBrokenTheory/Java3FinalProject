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
        request.createState("AL", 0.04);
        request.createState("AK", 0.0);
        request.createState("AZ", 0.056);
        request.createState("AR", 0.065);
        request.createState("CA", 0.0725);
        request.createState("CO", 0.029);
        request.createState("CT", 0.0635);
        request.createState("DE", 0.00);
        request.createState("FL", 0.06);
        request.createState("GA", 0.04);
        request.createState("HI", 0.04);
        request.createState("ID", 0.06);
        request.createState("IL", 0.0625);
        request.createState("IN", 0.07);
        request.createState("IA", 0.06);
        request.createState("KS", 0.06);
        request.createState("KY", 0.06);
        request.createState("LA", 0.0445);
        request.createState("ME", 0.055);
        request.createState("MD", 0.06);
        request.createState("MA", 0.0625);
        request.createState("MI", 0.06);
        request.createState("MN", 0.06875);
        request.createState("MS", 0.07);
        request.createState("MO", 0.04225);
        request.createState("MT", 0.00);
        request.createState("NE", 0.0550);
        request.createState("NV", 0.0685);
        request.createState("NH", 0.00);
        request.createState("NJ", 0.06625);
        request.createState("NM", 0.05125);
        request.createState("NY", 0.04);
        request.createState("NC", 0.0475);
        request.createState("ND", 0.05);
        request.createState("OH", 0.0575);
        request.createState("OK", 0.0475);
        request.createState("OR", 0.00);
        request.createState("PA", 0.06);
        request.createState("RI", 0.07);
        request.createState("SC", 0.06);
        request.createState("SD", 0.045);
        request.createState("TN", 0.07);
        request.createState("TX", 0.0625);
        request.createState("UT", 0.0595);
        request.createState("VT", 0.06);
        request.createState("VA", 0.053);
        request.createState("WA", 0.065);
        request.createState("WV", 0.06);
        request.createState("WI", 0.05);
        request.createState("WY", 0.04);
    }
}
