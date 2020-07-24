package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DailyReport;
import model.Legger;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class DailyReportController
 */
public class DailyReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreManagerService storeManagerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		String date = request.getParameter("date");
		if(date == null)
			date = java.time.LocalDate.now().toString();
		request.setAttribute("date", date);
		
		ArrayList<DailyReport> dr = storeManagerService.getDailyReportByDate(date);
		ArrayList<Legger> legger = storeManagerService.getPaymentsByDate(date);
		request.setAttribute("legger", legger);
		request.setAttribute("data", dr);
		request.getRequestDispatcher("dailyReport.jsp").forward(request, response);
	}
}
