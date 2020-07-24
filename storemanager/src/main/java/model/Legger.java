package model;

public class Legger {
	private int id;
	private String paymentFor;
	private String type;
	private float amount;
	private String date;
	public Legger() {
		super();
	}
	public Legger(int id, String paymentFor,String type, float amount, String date) {
		super();
		this.id = id;
		this.paymentFor = paymentFor;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentFor() {
		return paymentFor;
	}
	public void setPaymentFor(String paymentFor) {
		this.paymentFor = paymentFor;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
