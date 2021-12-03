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
 * Servlet implementation class cartDetails
 */
@WebServlet("/cartDetails")
public class cartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	IfServiceImp ifservice;
    public cartDetails() throws ServiceException {
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
				.getRequestDispatcher("/cartDetails.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String action=request.getParameter("action");
		if(action.equals("delete")) {ifservice.removeFromCart(Long.parseLong(id));}
		response.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	

}
