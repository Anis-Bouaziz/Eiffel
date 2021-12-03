package Products;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Common.IEmployee;
import Common.IProduct;
import Common.IProduct.Categories;
import Common.IProduct.Statuses;
import Common.IStock;

public class Stock extends UnicastRemoteObject implements IStock,Serializable{

	/**
	 * 
	 */
	protected  HashMap <IProduct,Long> quantity ;
	private static final long serialVersionUID = 1L;
	public HashMap<IProduct, Long> getQuantity() throws RemoteException {
		return this.quantity;
	}
	public void setQuantity(HashMap<IProduct, Long> q) throws RemoteException {
		this.quantity =  q ;
	}
	
	
	public Stock() throws RemoteException {
		super();
		this.quantity = new HashMap<IProduct,Long>() ;
	}
	@Override
	public void add(Long ID, Categories category, Double price, Statuses status, IEmployee owner, Long quantity)
			throws RemoteException {
		Product p= new Product(ID,category,price,status,owner);
		this.quantity.put(p, quantity);
		
	}
	@Override
	public void del(IProduct p) throws RemoteException {
		this.quantity.remove(p);
		
	}
	@Override
	public List<IProduct> listAll() throws RemoteException {
		
		return (List<IProduct>) this.quantity.keySet().stream().collect(Collectors.toList());
	}
	@Override
	public List<IProduct> listByCategory(Categories c) throws RemoteException {
		
		List <IProduct> listP= (List<IProduct>) this.quantity.keySet().stream().filter(p -> {
			try {
				return p.getCategory().equals(c);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return  listP;
	}
	@Override
	public List<IProduct> listByPrice(Double r) throws RemoteException {
		
		List<IProduct> listP= (List<IProduct>) this.quantity.keySet().stream().filter(p -> {
			try {
				return p.getPrice()== r;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return  listP;
	}
	@Override
	public List<IProduct> listByStatus(Statuses s) throws RemoteException {
		
		List<IProduct> listP= (List<IProduct>) this.quantity.keySet().stream().filter(p -> {
			try {
				return p.getStatus().equals(s);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return  listP;
	}
	@Override
	public IProduct getProduct(long id) throws RemoteException {
		Optional<IProduct> prod = this.getQuantity().keySet().stream().filter(p ->{
			try {
				return p.getID()==id;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).findFirst();
		
		return (IProduct) prod.get();
	}
	

}
