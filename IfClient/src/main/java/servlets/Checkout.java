package servlets;

import java.io.IOException;

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
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	IfServiceImp ifservice;
    public Checkout() throws ServiceException {
        super();
        ifservice = new IfServiceImpServiceLocator().getIfServiceImp();
		((IfServiceImpSoapBindingStub) ifservice).setMaintainSession(true);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cart", ifservice.getCart("EUR"));
		request.setAttribute("total", ifservice.getTotal("EUR"));
		request.setAttribute("currency", "EUR");
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/checkout.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String IBAN= request.getParameter("IBAN");
		String BIC= request.getParameter("BIC");
		String cvv2= request.getParameter("cvv2");
		String total= request.getParameter("total");
		

		boolean result=ifservice.checkout((long)1, Long.parseLong(IBAN), Integer.parseInt(cvv2), "EU");
		if(result==true) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/success.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
