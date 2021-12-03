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

import service.IfServiceImp;
import service.IfServiceImpServiceLocator;
import service.IfServiceImpSoapBindingStub;


/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String currency="EUR";
    /**
     * @see HttpServlet#HttpServlet()
     */
	IfServiceImp ifservice;
    public cart() throws ServiceException, RemoteException {
        super();
        ifservice = new IfServiceImpServiceLocator().getIfServiceImp();
		((IfServiceImpSoapBindingStub) ifservice).setMaintainSession(true);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			request.setAttribute("cart", ifservice.getCart("EUR"));
			
			request.setAttribute("currency", currency);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/cart.jsp");
			dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		currency = request.getParameter("currency");
		if (id!=null) {
		ifservice.addToCart(Long.parseLong(id));
		request.setAttribute("cart", ifservice.getCart(currency));
		request.setAttribute("total", ifservice.getTotal(currency));
		request.setAttribute("currency", currency);
		 
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request, response);}
		else {
			doGet( request,  response) ;}
		
		
	}

}
