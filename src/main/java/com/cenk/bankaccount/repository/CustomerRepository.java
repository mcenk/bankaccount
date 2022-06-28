package com.cenk.bankaccount.repository;

import com.cenk.bankaccount.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
