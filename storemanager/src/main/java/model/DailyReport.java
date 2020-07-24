package model;

public class DailyReport {
	private String product;
	
	private float buyingRate;
	private float buyingQt;
	private float sellingRate;
	private float sellingQt;
	private float stockLeft;
	private float totalAmount;
	private float profit;
	public DailyReport() {
		super();
	}
	public DailyReport(float sellingRate, float sellingQt,float totalAmount,
			float profit,String product) {
		this.sellingRate = sellingRate;
		this.sellingQt = sellingQt;
		this.totalAmount = totalAmount;
		this.profit = profit;
		this.product = product;
	}
	public float getBuyingRate() {
		return buyingRate;
	}
	public void setBuyingRate(float buyingRate) {
		this.buyingRate = buyingRate;
	}
	public float getBuyingQt() {
		return buyingQt;
	}
	public void setBuyingQt(float buyingQt) {
		this.buyingQt = buyingQt;
	}
	public float getSellingRate() {
		return sellingRate;
	}
	public void setSellingRate(float sellingRate) {
		this.sellingRate = sellingRate;
	}
	public float getSellingQt() {
		return sellingQt;
	}
	public void setSellingQt(float sellingQt) {
		this.sellingQt = sellingQt;
	}
	public float getStockLeft() {
		return stockLeft;
	}
	public void setStockLeft(float stockLeft) {
		this.stockLeft = stockLeft;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
}
