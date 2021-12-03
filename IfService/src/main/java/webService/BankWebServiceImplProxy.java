package webService;

public class BankWebServiceImplProxy implements webService.BankWebServiceImpl {
  private String _endpoint = null;
  private webService.BankWebServiceImpl bankWebServiceImpl = null;
  
  public BankWebServiceImplProxy() {
    _initBankWebServiceImplProxy();
  }
  
  public BankWebServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankWebServiceImplProxy();
  }
  
  private void _initBankWebServiceImplProxy() {
    try {
      bankWebServiceImpl = (new webService.BankWebServiceImplServiceLocator()).getBankWebServiceImpl();
      if (bankWebServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankWebServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankWebServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankWebServiceImpl != null)
      ((javax.xml.rpc.Stub)bankWebServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webService.BankWebServiceImpl getBankWebServiceImpl() {
    if (bankWebServiceImpl == null)
      _initBankWebServiceImplProxy();
    return bankWebServiceImpl;
  }
  
  public boolean performPurchace(long IBAN, int cvv2, double price) throws java.rmi.RemoteException{
    if (bankWebServiceImpl == null)
      _initBankWebServiceImplProxy();
    return bankWebServiceImpl.performPurchace(IBAN, cvv2, price);
  }
  
  
}