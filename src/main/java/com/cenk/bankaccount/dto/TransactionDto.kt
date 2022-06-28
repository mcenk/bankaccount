package com.cenk.bankaccount.dto

import com.cenk.bankaccount.model.Account
import com.cenk.bankaccount.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

data class TransactionDto(

        val id: String?,
        val transactionType: Transaction.TransactionType? = Transaction.TransactionType.INITIAL,
        val amount: BigDecimal?,
        val transactionDate: LocalDateTime?,
)
