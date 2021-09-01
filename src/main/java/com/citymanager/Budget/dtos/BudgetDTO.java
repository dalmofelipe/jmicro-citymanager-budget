package com.citymanager.Budget.dtos;

import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.Folder;
import com.citymanager.Budget.enums.Origin;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class BudgetDTO {

    private Float totalAmount;
    private Float spentAmount;
    private List<Folder> possibleDestinations;
    private Origin origin;

    public BudgetEntity toEntity() {
        BudgetEntity budgetEntity = new BudgetEntity();
        BeanUtils.copyProperties(this, budgetEntity);
        return budgetEntity;
    }

}
