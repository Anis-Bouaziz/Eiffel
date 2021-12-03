package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import common.Categories;
import common.IEmployee;
import common.IProduct;
import common.IUser;
import common.Statuses;

public class Product extends UnicastRemoteObject implements Serializable, IProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	

	public Product() throws RemoteException {
		super();
	}
	protected Long ID;
	protected String name;
	protected String url;
	protected Categories category;
	protected Double price;
	protected Statuses status;
	protected IEmployee Owner;
	protected ArrayList<IUser> waitingList;
	protected ArrayList<String> notes;
	protected Boolean sold;
	protected Long quantity ;
	public Product(Long ID,String name, String url,Categories category, Double price, Statuses status, IEmployee owner,Long quantity)
			throws RemoteException {
		super();
		this.ID = ID;
		this.name=name;
		this.url=url;
		this.category = category;
		this.price = price;
		this.status = status;
		this.Owner = owner;
		//this.Owner.getOwnedProducts().add(this);
		this.waitingList = new ArrayList<IUser>();
		this.notes = new ArrayList<String>();
		this.sold = false;
		this.quantity=quantity;
	}
	@Override
	public Boolean getSold() throws RemoteException{
		return sold;
	}

	@Override
	public void setSold(Boolean sold) throws RemoteException{
		this.sold = sold;
	}

	@Override
	public Long getQuantity() throws RemoteException{
		return quantity;
	}

	@Override
	public void setQuantity(Long quantity) throws RemoteException{
		this.quantity = quantity;
	}



	@Override
	public ArrayList<String> getNotes() throws RemoteException {
		return notes;
	}

	@Override
	public void setNotes(ArrayList<String> notes) throws RemoteException {
		this.notes = notes;
	}

	@Override
	public Long getID() throws RemoteException {
		return ID;
	}

	@Override
	public void setID(Long iD) throws RemoteException {
		ID = iD;
	}

	@Override
	public Categories getCategory() throws RemoteException {
		return category;
	}

	@Override
	public void setCategory(Categories category) throws RemoteException {
		this.category = category;
	}

	@Override
	public Double getPrice() throws RemoteException {
		return price;
	}

	@Override
	public void setPrice(Double price) throws RemoteException {
		this.price = price;
	}

	@Override
	public Statuses getStatus() throws RemoteException {
		return status;
	}

	@Override
	public void setStatus(Statuses status) throws RemoteException {
		this.status = status;
	}

	@Override
	public IEmployee getOwner() throws RemoteException {
		return Owner;
	}

	@Override
	public void setOwner(IEmployee owner) throws RemoteException {
		Owner = owner;
	}

	@Override
	public ArrayList<IUser> getWaitingList() throws RemoteException {
		return waitingList;
	}

	@Override
	public void setWaitingList(ArrayList<IUser> waitingList) throws RemoteException {
		this.waitingList = waitingList;
	}


	@Override
	public String getName() throws RemoteException{
		return name;
	}
	@Override
	public void setName(String name) throws RemoteException{
		this.name = name;
	}
	public String getUrl()throws RemoteException {
		return url;
	}
	public void setUrl(String url) throws RemoteException{
		this.url = url;
	}
	@Override
	public String toString() {
		String res = "ID: " + this.ID + " category: " + this.category + " price: " + this.price + " status: "
				+ this.status +"Quantity: "+ this.quantity+ ", product notes: ";
		try {
			for (String note : this.getNotes()) {
				res += "\n\t\t";
				res += note;
			}
			res += "\n";
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	

}
