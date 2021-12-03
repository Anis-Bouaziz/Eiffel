package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import Common.IProduct.Categories;
import Common.IProduct.Statuses;

public interface IStock extends Remote{
	public void add(Long ID,Categories category, Double price, Statuses status, IEmployee owner, Long quantity) throws RemoteException;
	public void del(IProduct p) throws RemoteException;
	public HashMap<IProduct, Long> getQuantity() throws RemoteException;
	public void setQuantity(HashMap<IProduct, Long> q) throws RemoteException ;
	public List<IProduct> listAll() throws RemoteException;
	public List<IProduct> listByCategory(Categories c) throws RemoteException;
	public List<IProduct> listByPrice(Double p) throws RemoteException;
	public List<IProduct> listByStatus(Statuses s) throws RemoteException;
	public IProduct getProduct(long id)throws RemoteException;
	
	
	
}
