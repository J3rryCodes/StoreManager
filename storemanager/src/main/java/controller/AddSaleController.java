package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class AddSaleController
 */
@WebServlet(value = "/AddSale")
public class AddSaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StoreManagerService storeManagerService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		String date = request.getParameter("date").toString();
		String product = request.getParameter("product").toString();
		float rateperkg = Float.parseFloat(request.getParameter("rateperkg").toString());
		float quantity = Float.parseFloat(request.getParameter("quantity").toString());
		float amount = Float.parseFloat(request.getParameter("amount").toString());
		
		int productId = storeManagerService.getProductIDbyName(product);
		
		storeManagerService.addSale(productId, rateperkg, quantity, amount, date);
		response.sendRedirect("Sales?date="+date);
	}

}
