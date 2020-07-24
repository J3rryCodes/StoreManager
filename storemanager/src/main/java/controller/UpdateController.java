package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet(value = "/Update")
public class UpdateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private StoreManagerService storeManagerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		ArrayList<Products> products = storeManagerService.getAllProducts();
		request.setAttribute("products", products);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
