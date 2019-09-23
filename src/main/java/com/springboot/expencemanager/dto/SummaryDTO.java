package com.springboot.expencemanager.dto;

import java.util.List;

public class SummaryDTO {

	private List<ExpenseSummaryDTO> expenseSummaryDTO;
	private String sum;
	
	public List<ExpenseSummaryDTO> getExpenseSummaryDTO() {
		return expenseSummaryDTO;
	}
	public void setExpenseSummaryDTO(List<ExpenseSummaryDTO> expenseSummaryDTO) {
		this.expenseSummaryDTO = expenseSummaryDTO;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	
}
