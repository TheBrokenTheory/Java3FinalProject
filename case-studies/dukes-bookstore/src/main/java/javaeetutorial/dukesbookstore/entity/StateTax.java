/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>Entity class for bookstore example.</p>
 */
@Entity
@Table(name = "WEB_BOOKSTORE_STATE")
@NamedQuery(
        name = "findStates",
        query = "SELECT b FROM state b ORDER BY b.stateCode")
public class StateTax implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    @Id
    @NotNull
    private String stateCode;
    private Double taxRate;

    public StateTax() {
    }

    public StateTax(String stateCode, Double taxRate) {
        this.stateCode = stateCode;
        this.taxRate = taxRate;
        
    }
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateCode != null ? stateCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StateTax)) {
            return false;
        }
        StateTax other = (StateTax) object;
        return this.stateCode != null || this.stateCode == null 
                && other.stateCode == null || this.stateCode.equals(other.stateCode);
    }

    @Override
    public String toString() {
        return "bookstore.entities.Book[ bookId=" + stateCode + " ]";
    }
}
