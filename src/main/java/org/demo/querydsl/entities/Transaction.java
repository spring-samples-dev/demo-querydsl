package org.demo.querydsl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private BranchLocation branchLocation;
    
    private double transactionAmount;


}
