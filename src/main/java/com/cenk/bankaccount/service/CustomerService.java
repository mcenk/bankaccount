package com.cenk.bankaccount.service;

import com.cenk.bankaccount.exception.CustomerNotFoundException;
import com.cenk.bankaccount.model.Customer;
import com.cenk.bankaccount.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // ben bu metodun sadece paket icerisinde kullanilmasini istiyorum o nedenle protected kullandim
    protected Customer findCustomerById(String id){

        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer could not find bu id"+ id ));
    }



}
