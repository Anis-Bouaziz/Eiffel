package service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import common.Categories;
import entity.ProductForUser;

public class IfServiceImp {
IfService ifservice;
public IfServiceImp() throws RemoteException, MalformedURLException, NotBoundException{
	ifservice=IfService.GetInstance();
}

public entity.ProductForUser[] convert(java.lang.String cTo) throws IOException  {
	return ifservice.convert(cTo);
}
public entity.ProductForUser[] getProducts() throws RemoteException  {
	return ifservice.getProducts();
}
public boolean checkout(long userID, long IBAN, int cvv2, java.lang.String curr) throws ServiceException, IOException  {
	return ifservice.checkout(userID, IBAN, cvv2, curr);
}
public entity.ProductForUser[] getCart(java.lang.String currency) throws RemoteException, IOException {
	return ifservice.getCart(currency);
}
public boolean addToCart(long productID) throws RemoteException  {
	return ifservice.addToCart(productID);
}
public double getTotal(java.lang.String curr) throws IOException {
	return ifservice.getTotal(curr);
}
public boolean removeFromCart(long productID) throws RemoteException  {
	return ifservice.removeFromCart(productID);
}
public ProductForUser[] getByCategory(String c ) throws RemoteException {
	return ifservice.getByCategory(c);}
}


