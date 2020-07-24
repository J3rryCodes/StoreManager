package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Legger;
import model.Products;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class OtherPaymentController
 */
@WebServlet(value = "/Payment")
public class PaymentController extends HttpServlet {
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
		
		ArrayList<Legger> otherPayments = storeManagerService.getPaymentsByDate(date);
		request.setAttribute("otherPayments", otherPayments);
		request.getRequestDispatcher("payments.jsp").forward(request, response);
	}

}
