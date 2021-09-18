package com.citymanager.Budget.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExpeseDTO {

    @NotNull
    private Float expense;
}
