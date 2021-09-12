package com.citymanager.Budget.dtos;

import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.enums.OriginEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class BudgetDTO {

    private Float totalAmount;
    private Float spentAmount;
    private List<FolderEnum> possibleDestinations;
    private OriginEnum origin;

    public BudgetEntity toEntity() {
        BudgetEntity budgetEntity = new BudgetEntity();
        BeanUtils.copyProperties(this, budgetEntity);
        return budgetEntity;
    }

}
