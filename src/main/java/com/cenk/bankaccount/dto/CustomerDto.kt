package com.cenk.bankaccount.dto

data class CustomerDto(

        val id:  String,
        val name: String?,
        val surName: String?,
        val accounts: Set<CustomerAccountDto>
)
