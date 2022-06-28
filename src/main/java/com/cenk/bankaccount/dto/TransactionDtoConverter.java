package com.cenk.bankaccount.dto;


import com.cenk.bankaccount.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from){


        return new TransactionDto(from.getId(),
                from.getTransaction(),
                from.getAmount(),
                from.getTransactionDate());

    }




}
