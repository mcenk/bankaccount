package com.cenk.bankaccount.controller;


import com.cenk.bankaccount.dto.AccountDto;
import com.cenk.bankaccount.dto.CreateAccountRequest;
import com.cenk.bankaccount.model.Account;
import com.cenk.bankaccount.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<AccountDto> createAccount (@RequestBody CreateAccountRequest request){

        return ResponseEntity.ok(accountService.createAccount(request));

    }
}
