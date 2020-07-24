package model;

public class Sales {
	private int id;
	private int productID;
	private float ratePerKg;
	private float quantityOfSale;
	private float totalAmount;
	private int leggerId;
	
	private String date;
	private String product;
	
	public Sales() {}
	
	public Sales(int id, int productID, float ratePerKg, float quantityOfSale, int leggerId, String date,
			String product,float totalAmount) {
		super();
		this.id = id;
		this.productID = productID;
		this.ratePerKg = ratePerKg;
		this.quantityOfSale = quantityOfSale;
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

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public float getRatePerKg() {
		return ratePerKg;
	}

	public void setRatePerKg(float ratePerKg) {
		this.ratePerKg = ratePerKg;
	}

	public float getQuantityOfSale() {
		return quantityOfSale;
	}

	public void setQuantityOfSale(float quantityOfSale) {
		this.quantityOfSale = quantityOfSale;
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
