package com.shvgp.exptracker_server.dto;

import com.shvgp.exptracker_server.entity.Expense;
import com.shvgp.exptracker_server.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;
    private List<Income> incomeList;



}
