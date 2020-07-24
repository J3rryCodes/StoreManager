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
 * Servlet implementation class AddProductPaymentController
 */
@WebServlet(value = "/AddStock")
public class AddStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreManagerService storeManagerService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		String date = request.getParameter("date").toString();
		String product = request.getParameter("product").toString();
		float rateperkg = Float.parseFloat(request.getParameter("rateperkg"));
		float quantity = Float.parseFloat(request.getParameter("quantity"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		int productId = storeManagerService.getProductIDbyName(product);
		
		storeManagerService.addStock(productId, rateperkg, quantity, amount, date);
		response.sendRedirect("Stock?date="+date);
	}

}
