package service;

public class IfServiceImpProxy implements service.IfServiceImp {
  private String _endpoint = null;
  private service.IfServiceImp ifServiceImp = null;
  
  public IfServiceImpProxy() {
    _initIfServiceImpProxy();
  }
  
  public IfServiceImpProxy(String endpoint) {
    _endpoint = endpoint;
    _initIfServiceImpProxy();
  }
  
  private void _initIfServiceImpProxy() {
    try {
      ifServiceImp = (new service.IfServiceImpServiceLocator()).getIfServiceImp();
      if (ifServiceImp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ifServiceImp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ifServiceImp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ifServiceImp != null)
      ((javax.xml.rpc.Stub)ifServiceImp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.IfServiceImp getIfServiceImp() {
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp;
  }
  
  public entity.ProductForUser[] convert(java.lang.String cTo) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.convert(cTo);
  }
  
  public entity.ProductForUser[] getProducts() throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.getProducts();
  }
  
  public entity.ProductForUser[] getCart(java.lang.String currency) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.getCart(currency);
  }
  
  public boolean addToCart(long productID) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.addToCart(productID);
  }
  
  public boolean removeFromCart(long productID) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.removeFromCart(productID);
  }
  
  public boolean checkout(long userID, long IBAN, int cvv2, java.lang.String curr) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.checkout(userID, IBAN, cvv2, curr);
  }
  
  public double getTotal(java.lang.String curr) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.getTotal(curr);
  }
  
  public entity.ProductForUser[] getByCategory(java.lang.String c) throws java.rmi.RemoteException{
    if (ifServiceImp == null)
      _initIfServiceImpProxy();
    return ifServiceImp.getByCategory(c);
  }
  
  
}