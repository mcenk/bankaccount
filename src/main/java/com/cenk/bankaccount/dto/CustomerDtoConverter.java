package com.cenk.bankaccount.dto;

import com.cenk.bankaccount.model.Customer;

public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer (Customer from  )
    {
        if(from == null){
            return new AccountCustomerDto("", "", "");
        }
        return new AccountCustomerDto( from.getId(),
                from.getName(),
                from.getSurName());

    }
}
