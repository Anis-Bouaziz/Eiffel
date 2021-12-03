package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProductService extends Remote{

	boolean addProduct(Long ID, String name,String url, Categories category, Double price, Statuses status, IEmployee owner,
			Long quantity) throws RemoteException;

	boolean deleteProduct(Long ID) throws RemoteException;

	List<IProduct> getByCategory(Categories c) throws RemoteException;

	List<IProduct> getByPrice(Double r) throws RemoteException;

	List<IProduct> getByStatus(Statuses s) throws RemoteException;
	List<IProduct> getBySoldOnce() throws RemoteException;

	IProduct getByID(long id) throws RemoteException;

	String show() throws RemoteException;

	boolean buyProduct(Long productID, Long userID) throws RemoteException;

	boolean addNote(Long ID, String note) throws RemoteException;

	boolean modifyQuantity(Long ID, Long q) throws RemoteException;

}