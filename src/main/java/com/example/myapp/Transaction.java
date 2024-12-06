package com.example.myapp;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    // Identifiant unique
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Description de la transaction
    private String description;

    // Type de transaction (revenu ou dépense)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    // Montant de la transaction
    private Double amount;

    // Date de la transaction
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date date;

    // Constructeurs
    public Transaction() {}

    public Transaction(String description, TransactionType type, Double amount, Date date) {
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    // Getters et Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public enum TransactionType {
        REVENUE,
        DEPENSE
    }
    
}
