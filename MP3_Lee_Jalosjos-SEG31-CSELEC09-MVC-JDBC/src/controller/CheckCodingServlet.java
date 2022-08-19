package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BusBean;

import model.BusBean;

@WebServlet("/coding.action")
public class CheckCodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busName  = request.getParameter("busName");
		 String plateNumber = request.getParameter("plateNumber");
		 String driverName = request.getParameter("driverName");
		 String codingDay = request.getParameter("codingDay");
		 char lastDigit = request.getParameter("plateNumber").charAt(5);
		 
		 BusBean busDetails = new BusBean(busName,plateNumber,driverName,codingDay,lastDigit);
		 
		 
		 busDetails.createTable();
		 busDetails.codingCheck();
		 
		 
		 getServletContext().setAttribute("busDetails", busDetails);
		 
		 if (busDetails.insertRecord()) {
				//perform object binding on application scope 
				getServletContext().setAttribute("busDetails", busDetails);
				
				//send redirect to view (display.jsp)
				response.sendRedirect("display.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
	}

}
