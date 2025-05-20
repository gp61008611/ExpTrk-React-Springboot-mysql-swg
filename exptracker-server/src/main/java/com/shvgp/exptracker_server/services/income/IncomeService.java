package com.shvgp.exptracker_server.services.income;

import com.shvgp.exptracker_server.dto.IncomeDTO;
import com.shvgp.exptracker_server.entity.Income;

import java.util.List;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);

    List<Income> getAllIncomes();

    Income getIncomeById(Long id);

    Income updateIncomeById(Long id, IncomeDTO IncomeDTO);

    void deleteIncome(Long id);
}
