package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.rpc.ServiceException;
import org.json.JSONObject;

import common.Categories;
import common.IProduct;
import common.IProductService;
import common.IUserService;
import entity.ProductForUser;
import webService.BankWebServiceImpl;
import webService.BankWebServiceImplServiceLocator;
import webService.BankWebServiceImplSoapBindingStub;

public class IfService {
	double rate = 1;
	IProductService ps;
	IUserService us;
	List<IProduct> cart=null;
	  List<IProduct> products;
	  protected static IfService instance = null;
	public IfService() throws MalformedURLException, RemoteException, NotBoundException {
		ps= (IProductService) Naming.lookup("rmi://localhost:1199/ProductService");
		us=(IUserService) Naming.lookup("rmi://localhost:1200/UserService");
	
		
			cart=new ArrayList<IProduct>();
		
		products=ps.getBySoldOnce();
		
	} 

	public static IfService GetInstance() throws RemoteException, MalformedURLException, NotBoundException {
		if (instance == null) {
			instance = new IfService();
		}
		return instance;
	}
	public boolean login() throws RemoteException {
		
		return true;
	}
	public ProductForUser[] getCart(String currency) throws RemoteException, IOException {
		
	
		
		ProductForUser[] res= new ProductForUser[cart.size()];
		for (int i=0; i<cart.size();i++) {
			IProduct prod=cart.get(i);
			String notes[] =new String[prod.getNotes().size()];
			for(int j=0;j<prod.getNotes().size();j++) {
				notes[j]=prod.getNotes().get(j);
			}
	res[i]=new ProductForUser(prod.getID(),prod.getName(),prod.getUrl(),prod.getCategory().toString(), prod.getPrice()*rate, prod.getStatus().toString(),notes,currency);
	
	}
		return res;}
	
	public ProductForUser[] getProducts() throws RemoteException{
		
		ProductForUser[] res= new ProductForUser[products.size()];
		for (int i=0; i<products.size();i++) {
			IProduct prod=products.get(i);
			String notes[] =new String[prod.getNotes().size()];
			for(int j=0;j<prod.getNotes().size();j++) {
				notes[j]=prod.getNotes().get(j);
			}
			res[i]=(new ProductForUser(prod.getID(),prod.getName(),prod.getUrl(),prod.getCategory().toString(), prod.getPrice(), prod.getStatus().toString(),notes,"EU"));
		}
		
		return res;
	}
	public boolean addToCart(Long productID) throws RemoteException {
		return this.cart.add(ps.getByID(productID));
	}
	public double getTotal(String currency) throws IOException {
		
			
		double s =0;
		for ( IProduct p :cart) {
			s=s+p.getPrice();
		}
		return s*rate;
		
	}
	public boolean removeFromCart(Long productID) throws RemoteException {
		return this.cart.remove(ps.getByID(productID));
	}
	
	public boolean checkout(Long userID,Long IBAN,int cvv2,String currency) throws ServiceException, IOException {
		
		BankWebServiceImpl bankService = new BankWebServiceImplServiceLocator().getBankWebServiceImpl();
		
		((BankWebServiceImplSoapBindingStub) bankService).setMaintainSession(true);
		
		boolean result = bankService.performPurchace(IBAN, cvv2, getTotal(currency));
		
		if (result) {
			for ( IProduct p :cart) {
				
				ps.buyProduct(p.getID(), userID);
			} 
			cart.clear();
		}
		return result;
		
	}
	public   ProductForUser[]  convert(String currency) throws  IOException  {
		
		
		if ( currency.equals("EUR")==false) {URL url = new URL("http://api.exchangeratesapi.io/latest?access_key=0ba13ac6f07f9226600209d73f9f02d0&symbols="+currency+"&base=EUR");
		
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      BufferedReader reader;
			String line;
			StringBuffer responseContent = new StringBuffer();
			// Get Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			
			//Request Status
			int status = connection.getResponseCode();
			
			
			if(status>299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line=reader.readLine())!=null) {
					responseContent.append(line);
				}
				reader.close();
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line=reader.readLine())!=null) {
					responseContent.append(line);
				}
				reader.close();
			}
			
			JSONObject jsonObject =  new JSONObject(responseContent.toString());
			
			
			JSONObject rates=new JSONObject(jsonObject.get("rates").toString());
			 rate= Double.valueOf( rates.get(currency).toString());}
			
		ProductForUser[] res= new ProductForUser[products.size()];
		for (int i=0; i<products.size();i++) {
			IProduct prod=products.get(i);
			String notes[] =new String[prod.getNotes().size()];
			for(int j=0;j<prod.getNotes().size();j++) {
				notes[j]=prod.getNotes().get(j);
			}
		
			res[i]=(new ProductForUser(prod.getID(),prod.getName(),prod.getUrl(),prod.getCategory().toString(), prod.getPrice()*rate, prod.getStatus().toString(),notes,currency));
		}
		
		return res;
	
		
	}
	
	public ProductForUser[] getByCategory(String c ) throws RemoteException {
		List<IProduct> l=ps.getByCategory(Categories.valueOf(c));
		ProductForUser[] res= new ProductForUser[l.size()];
		for (int i=0; i<l.size();i++) {
			IProduct prod=l.get(i);
			String notes[] =new String[prod.getNotes().size()];
			for(int j=0;j<prod.getNotes().size();j++) {
				notes[j]=prod.getNotes().get(j);
			}
			res[i]=(new ProductForUser(prod.getID(),prod.getName(),prod.getUrl(),prod.getCategory().toString(), prod.getPrice(), prod.getStatus().toString(),notes,"EU"));
		}
		
		return res;
	}
}



