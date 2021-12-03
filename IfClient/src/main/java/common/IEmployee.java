package common;

import java.rmi.RemoteException;
import java.util.List;

public interface IEmployee extends IUser{

	boolean isAdmin() throws RemoteException;

	void setAdmin(boolean admin) throws RemoteException;

	void setOwnedProducts(List<IProduct> ownedProducts) throws RemoteException;

	List<IProduct> getOwnedProducts() throws RemoteException;

	

}