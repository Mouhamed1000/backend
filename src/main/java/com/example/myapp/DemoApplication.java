package com.example.myapp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.myapp.API.service.TransactionService;
import com.example.myapp.Transaction.TransactionType;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	private Transaction transaction1, transaction2, transaction3;
	private TransactionService transactionService;

	@Autowired
    public DemoApplication(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

	public static void main(String[] args) {		
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Transactions started ");
	}

	@Override
	public void run(String... args) throws Exception {
		transaction1 = new Transaction("Achat Ordinateur", TransactionType.DEPENSE, 120000.0, new Date());
		transaction2 = new Transaction("Achat Télévision", TransactionType.DEPENSE, 100000.0, new Date());
		transaction3 = new Transaction("Achat Bureau", TransactionType.DEPENSE, 500000.0, new Date());

		transactionService.addTransaction(transaction1);
		transactionService.addTransaction(transaction2);
		transactionService.addTransaction(transaction3);


		int n = 0;

		for (Transaction t : transactionService.getAllTransactions())
		{
			n++;
			System.out.println("Transaction: " + t.getDescription() + "\t Type: " + t.getType() + "\t Montant: " +
			t.getAmount() + "\t Date: " + t.getDate()) ;
			System.out.println("-----             ------");
		}
	}

}
