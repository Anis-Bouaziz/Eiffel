/**
 * IfServiceImpServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class IfServiceImpServiceLocator extends org.apache.axis.client.Service implements service.IfServiceImpService {

    public IfServiceImpServiceLocator() {
    }


    public IfServiceImpServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IfServiceImpServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IfServiceImp
    private java.lang.String IfServiceImp_address = "http://localhost:8080/IfService/services/IfServiceImp";

    public java.lang.String getIfServiceImpAddress() {
        return IfServiceImp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IfServiceImpWSDDServiceName = "IfServiceImp";

    public java.lang.String getIfServiceImpWSDDServiceName() {
        return IfServiceImpWSDDServiceName;
    }

    public void setIfServiceImpWSDDServiceName(java.lang.String name) {
        IfServiceImpWSDDServiceName = name;
    }

    public service.IfServiceImp getIfServiceImp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IfServiceImp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIfServiceImp(endpoint);
    }

    public service.IfServiceImp getIfServiceImp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.IfServiceImpSoapBindingStub _stub = new service.IfServiceImpSoapBindingStub(portAddress, this);
            _stub.setPortName(getIfServiceImpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIfServiceImpEndpointAddress(java.lang.String address) {
        IfServiceImp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.IfServiceImp.class.isAssignableFrom(serviceEndpointInterface)) {
                service.IfServiceImpSoapBindingStub _stub = new service.IfServiceImpSoapBindingStub(new java.net.URL(IfServiceImp_address), this);
                _stub.setPortName(getIfServiceImpWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IfServiceImp".equals(inputPortName)) {
            return getIfServiceImp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service", "IfServiceImpService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service", "IfServiceImp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IfServiceImp".equals(portName)) {
            setIfServiceImpEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
