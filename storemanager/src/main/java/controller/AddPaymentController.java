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
 * Servlet implementation class AddOtherPaymentController
 */
@WebServlet(value = "/AddPayment")
public class AddPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StoreManagerService storeManagerService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		String date = request.getParameter("date").toString();
		String paymentFor = request.getParameter("paymentFor").toString();
		float amount = Float.parseFloat(request.getParameter("amount").toString());
		
		storeManagerService.addPayment(paymentFor, amount, date);
		response.sendRedirect("Payment?date="+date);
	}

}
