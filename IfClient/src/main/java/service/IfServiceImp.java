/**
 * IfServiceImp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface IfServiceImp extends java.rmi.Remote {
    public entity.ProductForUser[] convert(java.lang.String cTo) throws java.rmi.RemoteException;
    public entity.ProductForUser[] getByCategory(java.lang.String c) throws java.rmi.RemoteException;
    public entity.ProductForUser[] getProducts() throws java.rmi.RemoteException;
    public boolean checkout(long userID, long IBAN, int cvv2, java.lang.String curr) throws java.rmi.RemoteException;
    public entity.ProductForUser[] getCart(java.lang.String currency) throws java.rmi.RemoteException;
    public boolean addToCart(long productID) throws java.rmi.RemoteException;
    public double getTotal(java.lang.String curr) throws java.rmi.RemoteException;
    public boolean removeFromCart(long productID) throws java.rmi.RemoteException;
}
