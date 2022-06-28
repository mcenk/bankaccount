package com.cenk.bankaccount.dto

import java.math.BigDecimal

data class CreateAccountRequest(
    val customerId:String,
    val initialCreadit: BigDecimal
)