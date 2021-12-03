package Products;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import Common.IEmployee;
import Common.IProduct;

public class Product extends UnicastRemoteObject implements Serializable , IProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	protected Long ID;
	public Product() throws RemoteException {
		super();
	}
	protected Categories category;
	protected Double price;
	protected Statuses status;
	protected IEmployee Owner;
	protected ArrayList<IEmployee> waitingList;
	protected  HashMap <IEmployee,String> notes ;
	public Product(Long ID,Categories category, Double price, Statuses status,IEmployee owner) throws RemoteException {
		super();
		this.ID=ID;
		this.category = category;
		this.price = price;
		this.status = status;
		this.Owner = owner;
		this.waitingList = new ArrayList<IEmployee>();
		this.notes= new HashMap<IEmployee,String>();
	}
	
	public HashMap<IEmployee, String> getNotes() throws RemoteException{
		return notes;
	}

	public void setNotes(HashMap<IEmployee, String> notes) throws RemoteException {
		this.notes = notes;
	}

	public Long getID() throws RemoteException{
		return ID;
	}

	public void setID(Long iD) throws RemoteException{
		ID = iD;
	}

	public Categories getCategory() throws RemoteException{
		return category;
	}
	public void setCategory(Categories category) throws RemoteException {
		this.category = category;
	}
	public Double getPrice() throws RemoteException  {
		return price;
	}
	public void setPrice(Double price) throws RemoteException{
		this.price = price;
	}
	public Statuses getStatus() throws RemoteException{
		return status;
	}
	public void setStatus(Statuses status) throws RemoteException{
		this.status = status;
	}
	
	public IEmployee getOwner()throws RemoteException {
		return Owner;
	}
	public void setOwner(IEmployee owner)throws RemoteException {
		Owner = owner;
	}
	public ArrayList<IEmployee> getWaitingList() throws RemoteException {
		return waitingList;
	}
	public void setWaitingList(ArrayList<IEmployee> waitingList) throws RemoteException{
		this.waitingList = waitingList;
	}

	
	
	
	

}
