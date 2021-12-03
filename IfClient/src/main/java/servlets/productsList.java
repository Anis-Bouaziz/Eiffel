package servlets;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import entity.ProductForUser;
import service.IfServiceImp;
import service.IfServiceImpServiceLocator;
import service.IfServiceImpSoapBindingStub;


/**
 * Servlet implementation class productsList
 */
@WebServlet("/productsList")
public class productsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public String curr="EUR";
       IfServiceImp ifservice;
    /**
     
     * @see HttpServlet#HttpServlet()
     */
    public productsList() throws RemoteException, ServiceException {
        super();
        ifservice = new IfServiceImpServiceLocator().getIfServiceImp();
		((IfServiceImpSoapBindingStub) ifservice).setMaintainSession(true);
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
			
			
			ProductForUser[] result = ifservice.getProducts();
			
			request.setAttribute("curr", curr);
			
			request.setAttribute("productList", result);
//			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/productListView.jsp");
			
			dispatcher.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currency = request.getParameter("currency");
		String category = request.getParameter("category");
		ProductForUser[] result=null;
if (category!=null){
	 result =ifservice.getByCategory(category);
	
} else {
		
		
	
			
			if (currency.equals("EUR")){doGet(request,response);}else {
			 result = ifservice.convert(currency);
			curr=currency;}
			}
request.setAttribute("productList", result);
request.setAttribute("curr", curr);
RequestDispatcher dispatcher = request.getServletContext()
		.getRequestDispatcher("/productListView.jsp");

dispatcher.forward(request, response);
		
	}

}
