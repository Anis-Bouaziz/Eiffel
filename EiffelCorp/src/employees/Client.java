package employees;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Common.IProduct.Categories;
import Common.IProduct.Statuses;
import Common.IEmployee;
import Common.IProduct;
import Common.IStock;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IStock stock;
		stock=(IStock) Naming.lookup("stock");
		Employee e1=new Employee((long) 1,"Anis");
		Employee e2=new Employee((long) 2,"Khalil");
		stock.add((long)1, Categories.IT,2.5, Statuses.New, (IEmployee)e1, (long)50);
		stock.add((long)2, Categories.Clothes,3.5, Statuses.Old, (IEmployee)e1, (long)20);
		
		e2.addNote(stock.getProduct((long)1), "5 stars");
		e2.buyProduct(stock.getProduct((long)1), stock);
		//System.out.println(stock.getQuantity().toString());
		stock.listByCategory(Categories.IT).forEach(p -> {
			try {
				System.out.println(p.getID());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
