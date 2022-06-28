package com.cenk.bankaccount.service;

import com.cenk.bankaccount.dto.AccountDto;
import com.cenk.bankaccount.dto.AccountDtoConverter;
import com.cenk.bankaccount.dto.CreateAccountRequest;
import com.cenk.bankaccount.model.Account;
import com.cenk.bankaccount.model.Customer;
import com.cenk.bankaccount.model.Transaction;
import com.cenk.bankaccount.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    // Bir servis sadece kendisi ile alakali repoyu kullanabilir

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    // repo ile konusmak yerine ilgili alanin servisi ile islem yapmak daha mantikli

    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository
            , CustomerService customerService,
                          TransactionService transactionService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService= customerService;
        this.transactionService = transactionService;

        this.converter = converter;
    }

    public AccountDto createAccount (CreateAccountRequest createAccountRequest){

        Customer customer= customerService.findCustomerById(createAccountRequest.getCustomerId());
        //Bulamazsa sorun yok zaten exp atacak

        Account account= new Account(customer,
                createAccountRequest.getInitialCreadit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCreadit().compareTo(BigDecimal.ZERO) >0){
            // if big = 1 equals = 0 small -1

            Transaction transaction= transactionService.initiateMoney(account, createAccountRequest.getInitialCreadit());
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));

    }



}
