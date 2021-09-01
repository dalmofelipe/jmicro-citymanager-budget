package com.citymanager.Budget.controllers;

import com.citymanager.Budget.dtos.BudgetDTO;
import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.services.BudgetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budgets")
@AllArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    // Cria um orçamento validando todos os campos não nulos e brancos.
    @PostMapping
    public BudgetEntity create(@RequestBody BudgetDTO budgetDTO) {
        return budgetService.create(budgetDTO);
    }

    // Lista todos os recursos disponíveis. É possível filtrar por possibleDestinations;
    @GetMapping
    public List<BudgetEntity> listBudgets() {
        return budgetService.listBudgets();
    }

    // Registra um uso daquele orçamento (acrescenta no spentAmount caso seja menor do que a diferença (total - spent).
    @PatchMapping("/budgets/{id}/expense")
    public void registerExpense(@RequestParam Long id) {
        budgetService.registerExpense(id);
    }

}
