package com.example.myapp.API.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.myapp.API.repository.TransactionRepository;
import com.example.myapp.Transaction;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(UUID id) {
        return transactionRepository.findById(id);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(UUID id, Transaction transaction) {
        return transactionRepository.findById(id).map(existing -> {
            existing.setDescription(transaction.getDescription());
            existing.setAmount(transaction.getAmount());
            return transactionRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public void deleteTransaction(UUID id) {
        transactionRepository.deleteById(id);
    }
}
