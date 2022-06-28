package com.cenk.bankaccount.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

data class Account(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = "",
        val balance: BigDecimal? =BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL]) // birden fazla turu var ancak all genel islemleri yapiyor
        @JoinColumn(name = "customer_id", nullable = false)
        val customer : Customer?,

        @OneToMany(mappedBy = "account",fetch = FetchType.LAZY ) // mappedBy iliskiyi saklayan nesnenin ismi account
        val transaction: Set<Transaction>?

)


{



        // GENERATE EDILDI

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Account

                if (id != other.id) return false
                if (balance != other.balance) return false
                if (creationDate != other.creationDate) return false
                if (customer != other.customer) return false
                if (transaction != other.transaction) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (balance?.hashCode() ?: 0)
                result = 31 * result + creationDate.hashCode()
                result = 31 * result + (customer?.hashCode() ?: 0)
                result = 31 * result + (transaction?.hashCode() ?: 0)
                return result
        }
}