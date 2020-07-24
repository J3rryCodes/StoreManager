package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Stock;
import model.Products;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class ProductPaymentController
 */
@WebServlet(value = "/Stock")
public class StockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreManagerService storeManagerService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();

		String date = request.getParameter("date");
		if (date == null)
			date = java.time.LocalDate.now().toString();
		request.setAttribute("date", date);

		ArrayList<Products> products = storeManagerService.getAllProducts();
		request.setAttribute("products", products);
		
		ArrayList<Stock> productPayments = storeManagerService.getStockByDate(date);
		request.setAttribute("productPayments", productPayments);
		request.getRequestDispatcher("stocks.jsp").forward(request, response);
	}

}
