package com.springboot.expencemanager.service;

import com.springboot.expencemanager.Entity.Expense;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDTO;

public interface ExpenseService {

	public void addExpense(ExpenseDTO expenseDTO);
	
	public SummaryDTO getSummary(int user_id);

}
