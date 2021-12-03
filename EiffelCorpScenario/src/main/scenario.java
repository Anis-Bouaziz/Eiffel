package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.Categories;
import common.IEmployee;
import common.IProductService;
import common.IUserService;
import common.Statuses;

public class scenario {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IProductService ps;
		IUserService us ;
		us=(IUserService)Naming.lookup("rmi://localhost:1200/UserService");
		ps = (IProductService) Naming.lookup("rmi://localhost:1199/ProductService");
		
		
		us.addEmployee((long) 1, "Khalil", "Khalil", "Khalil", "Khalil", false );
		us.addEmployee((long) 2, "Khalil", "Khalil", "Khalil", "Khalil", false );
		us.addEmployee((long) 3, "Khalil", "Khalil", "Khalil", "Khalil", false );
		us.addCustomer((long)4, "anis", "anis", "anis", "anis");
		ps.addProduct((long)1, "iphone1","assets/images/iphone1.png", Categories.IT, 102.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)2, "iphone2","assets/images/iphone2.png", Categories.IT, 222.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)3, "iphone3","assets/images/iphone3.png", Categories.IT, 1222.25, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)4, "iphone4","assets/images/iphone4.png", Categories.IT, 252.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)5, "iphone5","assets/images/iphone5.png", Categories.IT, 1582.55, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)6, "book1","assets/images/book1.png", Categories.Book, 12.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)7, "book2","assets/images/book2.jpg", Categories.Book, 10.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)8, "book3","assets/images/book3.png", Categories.Book, 15.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)9, "clothes1","assets/images/clothes1.png", Categories.Clothes, 122.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);
		ps.addProduct((long)10, "clothes2","assets/images/clothes2.png", Categories.Clothes, 2.5, Statuses.New, (IEmployee)us.getByID((long)2), (long)50);

		
		
		
		ps.buyProduct((long)1, (long)2);
		ps.buyProduct((long)2, (long)2);
		ps.buyProduct((long)3, (long)2);
		ps.buyProduct((long)4, (long)2);
		ps.buyProduct((long)5, (long)2);
		ps.buyProduct((long)6, (long)2);
		ps.buyProduct((long)7, (long)2);
		ps.buyProduct((long)8, (long)2);
		ps.buyProduct((long)9, (long)2);
		ps.buyProduct((long)10, (long)2);
		
		
		//System.out.println(us.addEmployee((long) 2, "Khalil", "Khalil", "Khalil", "Khalil", false ));
		//System.out.println(us.getByID((long)2));
		//ps.addProduct((long)1, "iphone","iphone.png", Categories.IT, 2.5, Statuses.New, null, (long)50);
		//System.out.println(ps.getByID((long)1).getName());
		

	}

}
