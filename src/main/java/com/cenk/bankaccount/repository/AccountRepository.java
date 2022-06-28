package com.cenk.bankaccount.repository;

import com.cenk.bankaccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {


}
