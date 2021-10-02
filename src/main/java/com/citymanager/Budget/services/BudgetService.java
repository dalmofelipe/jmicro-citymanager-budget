package com.citymanager.Budget.services;

import com.citymanager.Budget.dtos.BudgetDTO;
import com.citymanager.Budget.dtos.ExpeseDTO;
import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public BudgetEntity create(BudgetDTO budgetDTO) {
        BudgetEntity budget = budgetDTO.toEntity();
        return budgetRepository.save(budget);
    }

    public List<BudgetEntity> listBudgets() {
        return budgetRepository.findAll();
    }

    public List<BudgetEntity> listBudgets(List<FolderEnum> destinations) {
        return budgetRepository.findByPossibleDestinationsIn(destinations);
    }

    public void registerExpense(Long id, ExpeseDTO expeseDTO) {

        Optional<BudgetEntity> budgetOpt = budgetRepository.findById(id);

        if(budgetOpt.isEmpty()) return;

        BudgetEntity budget = budgetOpt.get();
        Float total = budget.getTotalAmount();
        Float spent = budget.getSpentAmount();

        Float expense = expeseDTO.getExpense();

        if(expense > (total - spent)) return;

        spent += expense;
        budget.setSpentAmount(spent);

        budgetRepository.save(budget);
    }

	public BudgetEntity getBudget(Long id) {
		
		Optional<BudgetEntity> budgetOpt = budgetRepository.findById(id);

        if(budgetOpt.isEmpty()) return null;
        
        return budgetOpt.get();
	}
}
