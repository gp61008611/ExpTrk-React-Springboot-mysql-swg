package com.shvgp.exptracker_server.services.stats;

import com.shvgp.exptracker_server.dto.GraphDTO;
import com.shvgp.exptracker_server.dto.StatsDTO;
import com.shvgp.exptracker_server.entity.Expense;
import com.shvgp.exptracker_server.entity.Income;
import com.shvgp.exptracker_server.repository.ExpenseRepository;
import com.shvgp.exptracker_server.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService{

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);
        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));
        return graphDTO;

    }

    public StatsDTO getStats(){
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();

        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO= new StatsDTO();
        statsDTO.setIncome(totalIncome);
        statsDTO.setExpense(totalExpense);

        optionalExpense.ifPresent(statsDTO::setLatestExpense);
        optionalIncome.ifPresent(statsDTO::setLatestIncome);

        statsDTO.setBalance(totalIncome-totalExpense);

        List<Expense> expenseList = expenseRepository.findAll();
        List<Income> incomeList = incomeRepository.findAll();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();
        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble(): null);
        statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble(): null);
        statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble(): null);
        statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble(): null);
        return statsDTO;
    }


}
