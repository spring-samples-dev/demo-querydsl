package com.credera.querydsl.services;

import com.credera.querydsl.SeedData;
import com.credera.querydsl.entities.BranchLocation;
import com.credera.querydsl.entities.Customer;
import com.credera.querydsl.entities.QTransaction;
import com.credera.querydsl.entities.Transaction;
import com.credera.querydsl.repositories.BranchLocationRepository;
import com.credera.querydsl.repositories.CustomerRepository;
import com.credera.querydsl.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

    private final BranchLocationRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final SeedData seedData;

//    v
    public void run(){
        seedData.insertData();

        Iterable<BranchLocation> locations = branchRepository.findAll();
        System.out.println("Branch locations found with findAll():");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        // fetch all customers
        Iterable<Customer> customers = customerRepository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println();

//		//Simulate user authentication and save current user in thread local.
//		UserService.setCurrentUser("Frank");

        // fetch all transactions
        Iterable<Transaction> transactions = transactionRepository.findAll();
        System.out.println("Transactions found with findAll():");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();

        // fetch all transctions for Bank of Texas
        QTransaction tr = QTransaction.transaction;
        transactions = transactionRepository.findAll(tr.branchLocation.bankName.eq("Bank of Texas"));
        System.out.println("Transactions found for \"Bank of Texas\" locations:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();


        // fetch all transctions over $10,000
        transactions = transactionRepository.findAll(tr.transactionAmount.gt(10000));
        System.out.println("Transactions found with amount over $10,000:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();

        // fetch all Alice's transactions
        transactions = transactionRepository.findAll(tr.customer.username.eq("alain"));
        System.out.println("Transactions found for Alice:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
//        new JPAQuery<Transaction>().from()
//		context.close();
    }
}
