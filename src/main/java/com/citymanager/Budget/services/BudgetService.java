package com.citymanager.Budget.services;

import com.citymanager.Budget.dtos.BudgetDTO;
import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        // query personalizada
        return budgetRepository.findByPossibleDestinationsIn(destinations);
    }

    public void registerExpense(Long id) {
        return;
    }
}
