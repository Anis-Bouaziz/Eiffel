package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IProduct extends Remote{

	Boolean getSold()throws RemoteException;

	void setSold(Boolean sold)throws RemoteException;

	Long getQuantity()throws RemoteException;

	void setQuantity(Long quantity)throws RemoteException;

	ArrayList<String> getNotes() throws RemoteException;

	void setNotes(ArrayList<String> notes) throws RemoteException;

	Long getID() throws RemoteException;

	void setID(Long iD) throws RemoteException;

	Categories getCategory() throws RemoteException;

	void setCategory(Categories category) throws RemoteException;

	Double getPrice() throws RemoteException;

	void setPrice(Double price) throws RemoteException;

	Statuses getStatus() throws RemoteException;

	void setStatus(Statuses status) throws RemoteException;

	IEmployee getOwner() throws RemoteException;

	void setOwner(IEmployee owner) throws RemoteException;

	ArrayList<IUser> getWaitingList() throws RemoteException;

	void setWaitingList(ArrayList<IUser> waitingList) throws RemoteException;

	String getName() throws RemoteException;

	void setName(String name) throws RemoteException;
	public String getUrl()throws RemoteException;
	public void setUrl(String url) throws RemoteException;


}