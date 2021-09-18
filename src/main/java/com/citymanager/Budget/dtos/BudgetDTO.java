package com.citymanager.Budget.dtos;

import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.enums.OriginEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BudgetDTO {

    @NotNull
    private Float totalAmount;

    @NotNull
    private Float spentAmount;

    private List<FolderEnum> possibleDestinations;

    @NotNull
    private OriginEnum origin;

    public BudgetEntity toEntity() {
        BudgetEntity budgetEntity = new BudgetEntity();
        BeanUtils.copyProperties(this, budgetEntity);
        return budgetEntity;
    }

}
