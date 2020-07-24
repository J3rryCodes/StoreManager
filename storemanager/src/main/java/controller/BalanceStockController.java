package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Stock;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

public class BalanceStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreManagerService storeManagerService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		ArrayList<Stock> stocks = storeManagerService.getBalanceStock();
		request.setAttribute("stocks", stocks);
		request.getRequestDispatcher("stockBalance.jsp").forward(request, response);
	}

}
