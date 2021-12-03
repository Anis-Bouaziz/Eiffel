package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import common.Categories;
import common.IProductService;
import common.IUserService;
import common.Statuses;
import services.productService;


public class IfShareServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		LocateRegistry.createRegistry(1199);
		IProductService ps = productService.GetInstance();
		
		Naming.rebind("rmi://localhost:1199/ProductService",  ps);
	

	}

}
