package Common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.IProduct.Categories;
import Common.IProduct.Statuses;

public interface IProduct extends Remote{
	enum Categories{
		Book,
		Clothes,
		IT,
		Other
	}
	enum Statuses{
		New,
		Used,
		Old
	}
	public Categories getCategory() throws RemoteException;
	public Double getPrice() throws RemoteException ;
	public Statuses getStatus() throws RemoteException;
	public void setOwner(IEmployee owner)throws RemoteException ;
	public HashMap<IEmployee, String> getNotes() throws RemoteException;
	public void setNotes(HashMap<IEmployee, String> notes) throws RemoteException;
	public ArrayList<IEmployee> getWaitingList() throws RemoteException;
	public IEmployee getOwner()throws RemoteException;
	public Long getID() throws RemoteException;
	public void setID(Long iD) throws RemoteException;
	public void setCategory(Categories category) throws RemoteException;
	public void setPrice(Double price) throws RemoteException;
	public void setStatus(Statuses status) throws RemoteException;
	public void setWaitingList(ArrayList<IEmployee> waitingList) throws RemoteException;
}
