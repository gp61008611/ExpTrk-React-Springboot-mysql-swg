package com.shvgp.exptracker_server.services.expense;

import com.shvgp.exptracker_server.dto.ExpenseDTO;
import com.shvgp.exptracker_server.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpenseById(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
