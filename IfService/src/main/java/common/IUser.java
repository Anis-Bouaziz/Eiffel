package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUser extends Remote{

	Long getID() throws RemoteException;

	void setID(Long iD) throws RemoteException;

	String getFirstName() throws RemoteException;

	void setFirstName(String firstName) throws RemoteException;

	String getLastName() throws RemoteException;

	void setLastName(String lastName) throws RemoteException;

	String getEmail() throws RemoteException;

	void setEmail(String email) throws RemoteException;

	List<String> getNotifications() throws RemoteException;

	void setNotifications(List<String> notifications) throws RemoteException;
	public String getPassword() throws RemoteException;
	public void setPassword(String password) throws RemoteException;
	

}