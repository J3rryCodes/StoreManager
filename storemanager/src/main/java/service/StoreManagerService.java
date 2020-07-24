package service;

import java.util.ArrayList;

import model.DailyReport;
import model.Legger;
import model.MonthlyReport;
import model.Stock;
import model.Products;
import model.Sales;

public interface StoreManagerService {
	public ArrayList<Products> getAllProducts();
	public void addProduct(String product);
	public ArrayList<Sales>  getSalesByDate(String date);
	public int getProductIDbyName(String name);
	public String getProductById(int id);
	public void addSale(int productId,float ratePerKg,float quantity,float amount,String date);
	public ArrayList<Stock> getStockByDate(String date);
	public ArrayList<Legger> getPaymentsByDate(String date);
	public void addStock(int productId, float rateperkg, float quantity, float amount, String date);
	public void addPayment(String paymentFor, float amount, String date);
	public float getQuantityByProductId(int id);
	public ArrayList<DailyReport> getDailyReportByDate(String date);
	
	public int insertIntoLegger(String explanation,String type,float amount,String date);
	public ArrayList<Stock> getBalanceStock();
	public ArrayList<MonthlyReport> getMonthlyReportByDate(String startDate, String endDate);
	public ArrayList<Legger> getPaymentsOfMonthByDate(String date);
}
