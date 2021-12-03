package Common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IEmployee extends Remote{
	public void buyProduct (IProduct p,IStock s) throws RemoteException;
	
	public void addNote(IProduct p,String note) throws RemoteException;
	public void addQuantity(IProduct p,IStock s,Long q) throws RemoteException;
	public Long getID() throws RemoteException;
	public void setID(Long iD) throws RemoteException;
	public String getName() throws RemoteException;
	public void setName(String name) throws RemoteException;
	public ArrayList<IProduct> getOwnedProducts() throws RemoteException;
	public void setOwnedProducts(ArrayList<IProduct> ownedProducts) throws RemoteException;
}

