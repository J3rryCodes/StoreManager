package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Legger;
import model.MonthlyReport;
import service.StoreManagerService;
import service.StoreManagerServiceImpl;

/**
 * Servlet implementation class MonthlyReportController
 */
public class MonthlyReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreManagerService storeManagerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeManagerService = StoreManagerServiceImpl.getInstence();
		
		String date = request.getParameter("date");
		if(date == null)
			date = java.time.LocalDate.now().toString();
		request.setAttribute("date", date);
		
		String[] dateArg = date.split(":"); 
		String startDate = dateArg[0]+"-"+dateArg[1]+"-00";
		String endDate = dateArg[0]+"-"+dateArg[1]+"-31";
		ArrayList<MonthlyReport> dr = storeManagerService.getMonthlyReportByDate(startDate,endDate);
		ArrayList<Legger> legger = storeManagerService.getPaymentsOfMonthByDate(date);
		request.setAttribute("legger", legger);
		request.setAttribute("data", dr);
		request.getRequestDispatcher("dailyReport.jsp").forward(request, response);
	}
}
