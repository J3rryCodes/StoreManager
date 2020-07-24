package model;

public class MonthlyReport {
	private String date;
	private float income;
	private float Expenses;
	private float profit;
	
	
	public MonthlyReport() {
		super();
	}
	public MonthlyReport(String date, float income, float expenses, float profit) {
		super();
		this.date = date;
		this.income = income;
		Expenses = expenses;
		this.profit = profit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public float getExpenses() {
		return Expenses;
	}
	public void setExpenses(float expenses) {
		Expenses = expenses;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	
	
}
