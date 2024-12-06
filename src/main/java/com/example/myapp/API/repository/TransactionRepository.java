package com.example.myapp.API.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
