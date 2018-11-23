/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.dukesbookstore.web.managedbeans;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javaeetutorial.dukesbookstore.ejb.BookRequestBean;
import javaeetutorial.dukesbookstore.ejb.StateTaxRequestBean;
import javaeetutorial.dukesbookstore.entity.StateTax;
import javaeetutorial.dukesbookstore.exception.OrderException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIOutput;
import javax.faces.component.UISelectBoolean;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 * <p>Backing bean for the <code>/bookcashier.xhtml</code> and
 * <code>bookreceipt.xhtml</code> pages.</p>
 */
@Named
@RequestScoped
public class CashierBean extends AbstractBean {

    private static final long serialVersionUID = -9221440716172304017L;
    
    @EJB
    BookRequestBean bookRequestBean;
    
    @EJB
    StateTaxRequestBean stateTaxRequestBean;
    private double stateTaxOption;
    
    //For comfirmation page variables to be displayed.
    double subtotal = 0.00;
    double taxRate = 0.00;
    double shippingCost = 0.00;
    double finalTotal = 0.00;
    
    private String name = null;
    private String creditCardNumber = null;
    private Date shipDate;
    private String shippingOption = "2";
    UIOutput specialOfferText = null;
    UISelectBoolean specialOffer = null;
    UIOutput thankYou = null;
    private String stringProperty = "This is a String property";
    private String[] newsletters;
    private static final SelectItem[] newsletterItems = {
        new SelectItem("Duke's Quarterly"),
        new SelectItem("Innovator's Almanac"),
        new SelectItem("Duke's Diet and Exercise Journal"),
        new SelectItem("Random Ramblings")
    };

    public CashierBean() {
        this.newsletters = new String[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setNewsletters(String[] newsletters) {
        this.newsletters = newsletters;
    }

    public String[] getNewsletters() {
        return this.newsletters;
    }

    public SelectItem[] getNewsletterItems() {
        return newsletterItems;
    }

    public Date getShipDate() {
        return this.shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public void setShippingOption(String shippingOption) {
        this.shippingOption = shippingOption;
    }

    public String getShippingOption() {
        return this.shippingOption;
    }
    
    // State Tax
    public List<StateTax> getStateTax() 
    {
        return stateTaxRequestBean.getStates();
    }
    
    //State Tax option getter and setter
    public double getStateTaxOption() 
    {
        return stateTaxOption;
    }
    
    public void setStateTaxOption(double stateTaxOption) 
    {
        this.stateTaxOption = stateTaxOption;
    }
    //Getters for confirmation page variables
    public double getSubtotal() 
    {
        return subtotal;
    }
    
    public double getTaxRate() 
    {
        //Calculate the tax rate based on the selected StateTax object
        taxRate = subtotal * stateTaxOption;
        return taxRate;
    }
    
    public double getShippingCost() 
    {
        //Calculate shipping based on the selected option
        int selectedShipping = Integer.parseInt(shippingOption); 
        
        switch (selectedShipping) 
        {
            case 2:
                this.shippingCost = 25.82;
                return shippingCost;
            case 5:
                this.shippingCost = 10.76;
                return shippingCost;
            default:
                this.shippingCost = 5.25;
                return shippingCost;
        }
    }
    
    public double getFinalTotal() 
    {
        //Find the total
        this.finalTotal = subtotal + taxRate + shippingCost;
        return finalTotal;
    }

    //End State Tax
    public UIOutput getSpecialOfferText() {
        return this.specialOfferText;
    }

    public void setSpecialOfferText(UIOutput specialOfferText) {
        this.specialOfferText = specialOfferText;
    }

    public UISelectBoolean getSpecialOffer() {
        return this.specialOffer;
    }

    public void setSpecialOffer(UISelectBoolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public UIOutput getThankYou() {
        return this.thankYou;
    }

    public void setThankYou(UIOutput thankYou) {
        this.thankYou = thankYou;
    }

    public String getStringProperty() {
        return (this.stringProperty);
    }

    public void setStringProperty(String stringProperty) {
        this.stringProperty = stringProperty;
    }
    

    
    public String submit() {
        // Calculate and save the ship date
        int days = Integer.valueOf(shippingOption).intValue();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        setShipDate(cal.getTime());

        if ((cart.getTotal() > 100.00) && !specialOffer.isRendered()) {
            specialOfferText.setRendered(true);
            specialOffer.setRendered(true);

            return null;
        } else if (specialOffer.isRendered() && !thankYou.isRendered()) {
            thankYou.setRendered(true);

            return null;
        } else {
            try {
                bookRequestBean.updateInventory(cart);
            } catch (OrderException ex) {
                return "bookordererror";
            }
            
            this.subtotal = cart.getTotal();
            
            cart.clear();

            return ("bookOrderTotals");
        }
    }
}
