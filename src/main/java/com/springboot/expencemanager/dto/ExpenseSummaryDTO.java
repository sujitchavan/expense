package com.springboot.expencemanager.dto;

public class ExpenseSummaryDTO {

	private String monthyear;
	private int amount;
	
	public String getMonthyear() {
		return monthyear;
	}
	public void setMonthyear(String monthyear) {
		this.monthyear = monthyear;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
