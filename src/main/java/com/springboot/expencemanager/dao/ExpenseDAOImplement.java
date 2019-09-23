package com.springboot.expencemanager.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.expencemanager.Entity.Expense;
import com.springboot.expencemanager.conversion.Translator;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDTO;
import com.springboot.expencemanager.exceptions.RecordNotFoundException;

@Repository
@Transactional
public class ExpenseDAOImplement
        implements
            ExpenseDAO,
            Translator<Expense, ExpenseDTO> {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        translateToEntity(expense, expenseDTO);
        entityManager.persist(expense);

    }

    @Override
    public SummaryDTO getSummary(int user_id) throws RecordNotFoundException {
        SummaryDTO summaryDTO = new SummaryDTO();
        Query q1 = (Query) entityManager
                .createQuery("select sum(amount) from Expense where users."
                        + "user_id = " + user_id);
        Query q2 = (Query) entityManager
                .createQuery("select DATE_FORMAT(Date,'%b %Y'), sum(amount)"
                        + "from Expense where users.user_id = " + user_id
                        + " group by month(Date), " + "year(Date)");
        summaryDTO.setSum(q1.getResultList().get(0).toString());
        summaryDTO.setExpenseSummaryDTO(q2.getResultList());
        return summaryDTO;
    }

    @Override
    public Expense translateToEntity(Expense entity, ExpenseDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setCategory(dto.getCategory());
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        entity.setAmount(dto.getAmount());
        entity.setUsers(userDAO.findUser(dto.getUser_id()));
        return entity;
    }

    @Override
    public ExpenseDTO translateToDTO(Expense entity, ExpenseDTO dto) {
        dto.setTitle(entity.getTitle());
        dto.setCategory(entity.getCategory());
        dto.setDescription(entity.getDescription());
        dto.setDate(entity.getDate());
        dto.setAmount(entity.getAmount());
        return dto;
    }

}
