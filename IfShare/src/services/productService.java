package services;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import common.Categories;
import common.IEmployee;
import common.IProduct;
import common.IProductService;
import common.IUserService;
import common.Statuses;
import entity.Product;

public class productService extends UnicastRemoteObject implements Serializable, IProductService {
	private static final long serialVersionUID = 1L;
	
	IUserService us ;
	protected List<IProduct> products;
	protected static IProductService instance = null;

	private productService() throws RemoteException {
		products = new CopyOnWriteArrayList<IProduct>();
	}

	public static IProductService GetInstance() throws RemoteException {
		if (instance == null) {
			instance = new productService();
		}
		return instance;
	}

	
	
	
	@Override
	public boolean addProduct (Long ID,String name, String url,Categories category, Double price, Statuses status, IEmployee owner,Long quantity) throws RemoteException {
		return this.products.add(new Product(ID,  name, url,category,  price,  status,  owner, quantity));
		
	}

	@Override
	public boolean deleteProduct(Long ID) throws RemoteException {
		for(IProduct p :this.products) {
			if(p.getID()==ID) {
				return this.products.remove(p);
			}
		}
		return false;

	}

	
	@Override
	public List<IProduct> getByCategory(Categories c) throws RemoteException {

		List<IProduct> listP = (List<IProduct>) this.products.stream().filter(p -> {
			try {
				return p.getCategory().equals(c);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return listP;
	}

	
	@Override
	public List<IProduct> getByPrice(Double r) throws RemoteException {

		List<IProduct> listP = (List<IProduct>) this.products.stream().filter(p -> {
			try {
				return p.getPrice() == r;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return listP;
	}


	@Override
	public List<IProduct> getByStatus(Statuses s) throws RemoteException {

		List<IProduct> listP = (List<IProduct>) this.products.stream().filter(p -> {
			try {
				return p.getStatus().equals(s);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return listP;
	}

	
	@Override
	public IProduct getByID(long id) throws RemoteException {
		Optional<IProduct> prod = this.products.stream().filter(p -> {
			try {
				return p.getID() == id;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).findFirst();

		return (IProduct) prod.get();
	}

	
	@Override
	public String show() throws RemoteException {
		String res = "Products in the stock: \n";
		for (IProduct p : this.products) {
			res += p.toString() ;
			res += "\n";
		}
		return res;
	}


	@Override
	public boolean buyProduct(Long productID,Long userID) throws RemoteException {
		IProduct p= (IProduct) getByID(productID);
		
		if(p.getQuantity()>0) {
			p.setQuantity(p.getQuantity()-1);
			p.setSold(true);
			return true;
		}
		else {
			p.getWaitingList().add(us.getByID(userID));
			return false;
		}
		
	}

	
	@Override
	public boolean addNote(Long ID, String note) throws RemoteException {
		return this.getByID(ID).getNotes().add(note);
		

	}
	@Override
	public boolean  modifyQuantity(Long ID, Long q) throws RemoteException {
		IProduct p =this.getByID(ID);
		p.setQuantity(p.getQuantity()+q);
		if  (p.getWaitingList().isEmpty()) {return false;}
		else {
			while ((p.getQuantity()>0) ) {
				if (p.getWaitingList().isEmpty()) break;
				p.getWaitingList().get(0).getNotifications().add("Purchase for Product"+p.getName()+"is complete");
			
				buyProduct(p.getID(),p.getWaitingList().get(0).getID());
				p.getWaitingList().remove(0);
				
			}
			return true;
		}
		
	}

	@Override
	public List<IProduct> getBySoldOnce() throws RemoteException {
		List<IProduct> listP = (List<IProduct>) this.products.stream().filter(p -> {
			try {
				return p.getSold()==true;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		return listP;
	}

	
	

}
