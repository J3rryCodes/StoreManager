package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import model.Sales;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class SalesController
 */
@WebServlet(value = "/Sales")
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreManagerService storeManagerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		String date = request.getParameter("date");
		if(date == null)
			date = java.time.LocalDate.now().toString();
		request.setAttribute("date", date);
		
		ArrayList<Products> products = storeManagerService.getAllProducts();
		request.setAttribute("products", products);
		
		ArrayList<Sales> sales = storeManagerService.getSalesByDate(date);
		request.setAttribute("sales", sales);
		request.getRequestDispatcher("sales.jsp").forward(request, response);
	}

}
