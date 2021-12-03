package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUserService extends Remote{

	boolean addEmployee(Long ID, String firstName, String lastName, String email,String password, boolean admin) throws RemoteException;

	IUser getByID(Long ID) throws RemoteException;
	IUser getByEmail(String email) throws RemoteException;

	boolean removeUser(Long id) throws RemoteException;

	boolean addCustomer(Long iD, String firstName, String lastName, String email, String password)
			throws RemoteException;

}