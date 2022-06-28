package com.cenk.bankaccount.repository;

import com.cenk.bankaccount.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction, String> {
}
