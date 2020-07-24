package service;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DBConnection;
import model.DailyReport;
import model.Legger;
import model.MonthlyReport;
import model.Stock;
import model.Products;
import model.Sales;

public class StoreManagerServiceImpl implements StoreManagerService {
	private static StoreManagerServiceImpl storeManagerServiceImpl;
	private DBConnection dbConnection;

	private StoreManagerServiceImpl() {
		dbConnection = new dao.DBConnection();
	}

	public static StoreManagerServiceImpl getInstence() {
		if (storeManagerServiceImpl == null)
			storeManagerServiceImpl = new StoreManagerServiceImpl();
		return storeManagerServiceImpl;
	}

	public ArrayList<Products> getAllProducts() {
		ArrayList<Products> products = new ArrayList<Products>();
		String sql = "select * from products";
		ResultSet rs = dbConnection.getData(sql);
		try {
			while (rs.next()) {
				products.add(new Products(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public void addProduct(String product) {
		dbConnection.putData("insert into products(product) values('" + product + "')");
		int pId = getProductIDbyName(product);
		dbConnection.putData("insert into stock(productId,rateperkg,quantity,amount) values ("+pId+",0,0,0)");
	}

	public int insertIntoLegger(String explanation, String type, float amount, String date) {
		String sql = "insert into legger(details,type,amount,date) values('" + explanation + "','" + type + "',"
				+ amount + ",'" + date + "')";
		dbConnection.putData(sql);
		sql = "select max(id) from legger";
		ResultSet rs = dbConnection.getData(sql);
		try {
			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Sales> getSalesByDate(String date) {
		String sql = "select s.*,p.product from sales as s inner join products as p "
				+ "on s.productId = p.id where s.date='" + date + "'";
		ArrayList<Sales> sales = new ArrayList<Sales>();
		ResultSet rs = dbConnection.getData(sql);
		try {
			while (rs.next()) {
				sales.add(new Sales(rs.getInt(1), rs.getInt(2), rs.getFloat(3), rs.getFloat(4), 0,
						rs.getString(6), rs.getString(8), rs.getFloat(5)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sales;
	}

	public int getProductIDbyName(String name) {
		ResultSet rs = dbConnection.getData("select id from products where product='" + name + "'");
		try {
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void addSale(int productId, float ratePerKg, float quantity, float amount, String date) {
		String pName = getProductById(productId);
		insertIntoLegger("Recived from Sales : " + pName, "DR", amount, date);
		
		String sql = "select rateperkg from stock where productId = "+productId;
		ResultSet rs = dbConnection.getData(sql);
		float buyRate = 0;
		try {
			if(rs.next())
				buyRate = rs.getFloat(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		float profit = amount - (buyRate * quantity);
		
		sql = "insert into sales(productId,rateperkg,quantity,amount,date,profit) values(" + productId + ","
				+ ratePerKg + "," + quantity + "," + amount + ",'" + date + "',"+profit+")";
		dbConnection.putData(sql);
		// Update Stock
		sql = "update stock set quantity = quantity-" + quantity + " where productId=" + productId;
		dbConnection.updateData(sql);
	}

	public ArrayList<Stock> getStockByDate(String date) {
		String sql = "select s.*,p.product from StockHistory as s inner join products as p on s.productId = p.id "+
	" where s.date='"+date+"'";
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		ResultSet rs = dbConnection.getData(sql);
		try {
			while(rs.next())
				stocks.add(new Stock(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4),0,rs.getString(6),rs.getString(7),rs.getFloat(5)));
		}catch(Exception e) {e.printStackTrace();
		}
		return stocks;
	}

	public ArrayList<Legger> getPaymentsByDate(String date) {
		String sql = "select id,details,type,amount,date from legger where type <> 'DR' and date='"+date+"'";
		ArrayList<Legger> legger = new ArrayList<Legger>();

		ResultSet rs = dbConnection.getData(sql);
		try {
			while(rs.next()) {
				legger.add(new Legger(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5)));
			}
		} catch (Exception e) {
		}
		return legger;
	}

	public void addStock(int productId, float rateperkg, float quantity, float amount, String date) {
		String pName = getProductById(productId);
		insertIntoLegger("Paid for : "+pName, "SCR", amount, date);
		float q = getQuantityByProductId(productId);
		String sql = "update stock set rateperkg="+rateperkg+",quantity="+(quantity+q)+",amount="+
		amount+",date='"+date+"' where productId="+productId;
		dbConnection.updateData(sql);
		dbConnection.putData("insert into StockHistory(productId,rateperkg,quantity,amount,date) values ("+productId+","+rateperkg+","+quantity+","+amount+",'"+date+"')");
		dbConnection.putData(sql);
	}

	public void addPayment(String paymentFor, float amount, String date) {
		insertIntoLegger(paymentFor, "OCR", amount, date);
	}

	public String getProductById(int id) {
		ResultSet rs = dbConnection.getData("select product from products where id=" + id);
		try {
			rs.next();
			return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public float getQuantityByProductId(int id) {
		ResultSet rs = dbConnection.getData("select quantity from stock where productId="+id);
		try {
			if(rs.next()) {
				return rs.getFloat(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}

	public ArrayList<Stock> getBalanceStock() {
		String sql = "select s.*,p.product from Stock as s inner join products as p on s.productId = p.id "+
				"where s.date is not null";
		System.out.print(sql);
					ArrayList<Stock> stocks = new ArrayList<Stock>();
					ResultSet rs = dbConnection.getData(sql);
					try {
						while(rs.next())
							stocks.add(new Stock(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4),0,rs.getString(6),rs.getString(7),rs.getFloat(5)));
					}catch(Exception e) {e.printStackTrace();
					}
					return stocks;
	}

	public ArrayList<DailyReport> getDailyReportByDate(String date) {

		String sql = "select s.rateperkg,s.quantity,s.amount,s.profit,p.product from sales as s inner join products as p on p.id = s.productId where s.date ='"+date+"'";
		System.out.println(sql);
		ArrayList<DailyReport> rd = new ArrayList<DailyReport>();
		ResultSet rs = dbConnection.getData(sql);
		try {
			while(rs.next()) {
				DailyReport dr = new DailyReport(rs.getFloat(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4),rs.getString(5));
				rd.add(dr);
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		return rd;
	}

	public ArrayList<MonthlyReport> getMonthlyReportByDate(String startDate, String endDate) {
		ArrayList<MonthlyReport> monthlyReports = new ArrayList<MonthlyReport>();
	//	String sql = "Select ";
		return monthlyReports;
	}

	public ArrayList<Legger> getPaymentsOfMonthByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
