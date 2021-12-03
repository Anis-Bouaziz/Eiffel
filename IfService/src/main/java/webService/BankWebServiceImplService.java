/**
 * BankWebServiceImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webService;

public interface BankWebServiceImplService extends javax.xml.rpc.Service {
    public java.lang.String getBankWebServiceImplAddress();

    public webService.BankWebServiceImpl getBankWebServiceImpl() throws javax.xml.rpc.ServiceException;

    public webService.BankWebServiceImpl getBankWebServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
