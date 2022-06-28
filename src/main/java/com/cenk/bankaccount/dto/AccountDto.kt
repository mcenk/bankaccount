package com.cenk.bankaccount.dto

import com.cenk.bankaccount.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(


        val id: String?,
        val balance: BigDecimal?,
        val creationDate: LocalDateTime?,
        val customer: AccountCustomerDto?, // oncelikle customerdto kullandi
                                                // account icerisinden customer bilgilerine ulasmayi amacladi
        val transactions: Set<TransactionDto>?

)
