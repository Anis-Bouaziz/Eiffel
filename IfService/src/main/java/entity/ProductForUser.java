/**
 * ProductForUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entity;

public class ProductForUser  implements java.io.Serializable {
    private java.lang.Long ID;

    private java.lang.String category;

    private java.lang.String currency;

    private java.lang.String name;

    private java.lang.String[] notes;

    private double price;

    private java.lang.String status;

    private java.lang.String url;

    public ProductForUser() {}
    public ProductForUser(
    		
           java.lang.Long ID,
           java.lang.String name,
           String url,
           java.lang.String category,
           double d,
           java.lang.String string,

           String[] notes2
           ,
           String currency
           ) {
           this.ID = ID;
           this.category = category;
           this.currency = currency;
           this.name = name;
           this.notes = notes2;
           this.price = d;
           this.status =string ;
           this.url = url;
    }


    /**
     * Gets the ID value for this ProductForUser.
     * 
     * @return ID
     */
    public java.lang.Long getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ProductForUser.
     * 
     * @param ID
     */
    public void setID(java.lang.Long ID) {
        this.ID = ID;
    }


    /**
     * Gets the category value for this ProductForUser.
     * 
     * @return category
     */
    public java.lang.String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this ProductForUser.
     * 
     * @param category
     */
    public void setCategory(java.lang.String category) {
        this.category = category;
    }


    /**
     * Gets the currency value for this ProductForUser.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this ProductForUser.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the name value for this ProductForUser.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ProductForUser.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the notes value for this ProductForUser.
     * 
     * @return notes
     */
    public java.lang.String[] getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this ProductForUser.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String[] notes) {
        this.notes = notes;
    }


    /**
     * Gets the price value for this ProductForUser.
     * 
     * @return price
     */
    public java.lang.Double getPrice() {
        return price;
    }


    /**
     * Sets the price value for this ProductForUser.
     * 
     * @param price
     */
    public void setPrice(java.lang.Double price) {
        this.price = price;
    }


    /**
     * Gets the status value for this ProductForUser.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ProductForUser.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the url value for this ProductForUser.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this ProductForUser.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    

}
