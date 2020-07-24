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
 * Servlet implementation class AddProductController
 */
@WebServlet(value = "/AddProduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StoreManagerService storeManagerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		storeManagerService = StoreManagerServiceImpl.getInstence();
		storeManagerService.addProduct(product);
		response.sendRedirect("Update");
	}

}
