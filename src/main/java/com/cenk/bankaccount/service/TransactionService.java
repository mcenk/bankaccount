package com.cenk.bankaccount.service;


import com.cenk.bankaccount.model.Account;
import com.cenk.bankaccount.model.Transaction;
import com.cenk.bankaccount.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class TransactionService {

    private Logger logger= LoggerFactory.getLogger(TransactionService.class);


    private  final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount){
        return transactionRepository.save(
                new Transaction(amount,account)
        );

    }
}
