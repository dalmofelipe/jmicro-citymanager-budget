package com.citymanager.Budget.entities;

import com.citymanager.Budget.enums.Folder;
import com.citymanager.Budget.enums.Origin;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_budget")
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_amount")
    private Float totalAmount;

    @Column(name = "spent_amount")
    private Float spentAmount;

    @Column(name = "possible_destinations")
    // patifaria isso aqui
    private List<Folder> possibleDestinations;

    @Enumerated(EnumType.STRING)
    private Origin origin;

}
