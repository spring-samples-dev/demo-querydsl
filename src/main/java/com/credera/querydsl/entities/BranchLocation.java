package com.credera.querydsl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BranchLocation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String bankName;
    private String branchName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phoneNumber;

}

