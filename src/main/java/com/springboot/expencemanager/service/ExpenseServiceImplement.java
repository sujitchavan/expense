package com.springboot.expencemanager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.expencemanager.dao.ExpenseDAO;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDTO;
import com.springboot.expencemanager.exceptions.RecordNotFoundException;

@Service
public class ExpenseServiceImplement implements ExpenseService {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private ExpenseDAO expenseDAO;

    @Override
    public void addExpense(ExpenseDTO expenseDTO) {
        expenseDAO.addExpense(expenseDTO);
        logger.info("Expenses added in db: ");
    }

    @Override
    public SummaryDTO getSummary(int user_id) {
        SummaryDTO summaryDTO = expenseDAO.getSummary(user_id);
        if (summaryDTO.getExpenseSummaryDTO() == null
                && summaryDTO.getSum() == null) {
            logger.error("Expenses not found: ");
            throw new RecordNotFoundException("User Id invalid" + user_id);
        }
        logger.info("Expenses found: ");
        return summaryDTO;
    }

}
