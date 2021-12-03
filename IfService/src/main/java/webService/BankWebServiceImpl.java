/**
 * BankWebServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webService;

public interface BankWebServiceImpl extends java.rmi.Remote {
    public boolean performPurchace(long IBAN, int cvv2, double price) throws java.rmi.RemoteException;
}
