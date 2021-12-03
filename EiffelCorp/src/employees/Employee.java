package employees;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Common.IEmployee;
import Common.IProduct;
import Common.IStock;

public class Employee extends UnicastRemoteObject implements Serializable , IEmployee{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Employee() throws RemoteException {
		super();
		
	}
	/**
	 * 
	 */
	protected Long ID;
	protected String name;
	protected ArrayList<IProduct> ownedProducts;
	public Employee(Long ID,String name) throws RemoteException {
		super();
		this.ID=ID;
		this.name = name;
		this.ownedProducts = new ArrayList<IProduct>();
	}
	@Override
	public void buyProduct(IProduct p,IStock s) throws RemoteException {
		Long q = s.getQuantity().get(p);
		if (q==0) {p.getWaitingList().add(this);}
		else {
		s.getQuantity().put(p, s.getQuantity().get(p)-1);
		}
	}
	@Override
	public void addNote(IProduct p, String note) throws RemoteException {
		p.getNotes().put(this, note);
		
	}
	@Override
	public void addQuantity(IProduct p,IStock s, Long q) throws RemoteException {
		
		if (p.getOwner().equals(this)) {
			s.getQuantity().put(p, q+s.getQuantity().get(p));
		}
		
		for (int i=0;i <= s.getQuantity().get(p);i++) {
			if (p.getWaitingList().isEmpty()==false) {
				p.getWaitingList().remove(0);
			}
		}
	}
	public Long getID() throws RemoteException{
		return ID;
	}
	public void setID(Long iD) throws RemoteException{
		ID = iD;
	}
	public String getName() throws RemoteException{
		return name;
	}
	public void setName(String name) throws RemoteException{
		this.name = name;
	}
	public ArrayList<IProduct> getOwnedProducts() throws RemoteException{
		return ownedProducts;
	}
	public void setOwnedProducts(ArrayList<IProduct> ownedProducts) throws RemoteException{
		this.ownedProducts = ownedProducts;
	}

}
