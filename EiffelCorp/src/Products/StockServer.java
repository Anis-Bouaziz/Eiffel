package Products;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import Common.IStock;



public class StockServer {

	public static void main(String[] args)throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);
		IStock stock=new Stock();
		Naming.rebind("stock", stock);

	}

}
