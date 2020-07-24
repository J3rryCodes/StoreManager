package model;

public class Stock {
	private int id;
	private int productId;
	private float ratePerKg;
	private float totalQuantity;
	private float totalAmount;
	private int leggerId;
	private String date;
	
	private String product;
	public Stock() {}
	public Stock(int id, int productId, float ratePerKg, float totalQuantity,int leggerId, String date,
			String product, float totalAmount) {
		super();
		this.id = id;
		this.productId = productId;
		this.ratePerKg = ratePerKg;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.leggerId = leggerId;
		this.date = date;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getRatePerKg() {
		return ratePerKg;
	}
	public void setRatePerKg(float ratePerKg) {
		this.ratePerKg = ratePerKg;
	}
	public float getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(float totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getLeggerId() {
		return leggerId;
	}
	public void setLeggerId(int leggerId) {
		this.leggerId = leggerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
}
