package javaeetutorial.dukesbookstore.web.managedbeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jonathan Anders
 */
@Named(value = "orderTotalsBean")
@RequestScoped
public class OrderTotalsBean {

    /**
     * Creates a new instance of OrderTotalsBean
     */
    public OrderTotalsBean()
    {
    }
    
}
