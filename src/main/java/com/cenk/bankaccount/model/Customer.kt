package com.cenk.bankaccount.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Customer(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID",  strategy= "org.hibernate.id.UUIDGenerator")
        val id:  String,
        val name: String?,
        val surName: String?



)
