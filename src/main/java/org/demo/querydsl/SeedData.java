package org.demo.querydsl;

import org.demo.querydsl.entities.BranchLocation;
import org.demo.querydsl.entities.Customer;
import org.demo.querydsl.entities.Transaction;
import org.demo.querydsl.repositories.BranchLocationRepository;
import org.demo.querydsl.repositories.CustomerRepository;
import org.demo.querydsl.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class SeedData {

    private final BranchLocationRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @PostConstruct
    public void insertData() {
        System.out.println("-------- Inserting data -----------");
        // save a couple of branches
        BranchLocation bl1 = branchRepository.save(new BranchLocation(null, "Bank of Texas", "Downtown Penn", "600 Penn Street", "Fort Worth", "TX", "76102", "USA", "817-255-2108"));
        branchRepository.save(new BranchLocation(null, "Bank of Texas", "Royal Lane", "2650 Royal Lane", "Dallas", "TX", "75229", "USA", "214-574-1277"));
        branchRepository.save(new BranchLocation(null, "Bank of Texas", "West University", "5500 Kirby", "Houston", "TX", "77005", "USA", "713-218-2259"));
        BranchLocation bl2 = branchRepository.save(new BranchLocation(null, "Wells Fargo", "Church & Elm", "205 Church Street", "New Haven", "CT", "06510", "USA", "203-773-9037"));
        branchRepository.save(new BranchLocation(null, "Wells Fargo", "Whalley Norton", "388 Whalley Avenue", "New Haven", "CT", "06511", "USA", "203-777-7113"));
        branchRepository.save(new BranchLocation(null, "Wells Fargo", "University of New Haven", "300 Boston Post Road", "New Haven", "CT", "06516", "USA", "800-869-3557"));
        BranchLocation bl3 = branchRepository.save(new BranchLocation(null, "Citibank", "Government Center", "100 Cambridge Street", "Boston", "MA", "02114", "USA", "617-849-7544"));

        //save some users
        Customer frank = customerRepository.save(new Customer(null, "fwood", "Frank", "Wood", "583942302"));
        Customer alice = customerRepository.save(new Customer(null, "alain", "Alice", "Lain", "294032410"));
        Customer matt = customerRepository.save(new Customer(null, "mlean", "Matt", "Lean", "034502102"));

        //save some transactions
        transactionRepository.save(new Transaction(null, frank, bl1, 10457.83));
        transactionRepository.save(new Transaction(null, frank, bl1, 582.43));
        transactionRepository.save(new Transaction(null, frank, bl2, 926.01));

        transactionRepository.save(new Transaction(null, alice, bl1, 70583.92));
        transactionRepository.save(new Transaction(null, alice, bl2, 209.31));
        transactionRepository.save(new Transaction(null, alice, bl2, 48.21));
        transactionRepository.save(new Transaction(null, alice, bl3, 493.21));

        transactionRepository.save(new Transaction(null, matt, bl2, 111021.53));
        transactionRepository.save(new Transaction(null, matt, bl3, 72983.51));
        transactionRepository.save(new Transaction(null, matt, bl3, 5924.21));
    }
}
