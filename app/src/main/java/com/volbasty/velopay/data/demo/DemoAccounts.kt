
package com.volbasty.velopay.data.demo

import com.volbasty.velopay.domain.model.FinancialAccount

object DemoAccounts {

    val accounts: List<FinancialAccount> = listOf(
        FinancialAccount(
            id = "demo-account-main",
            name = "Everyday Account",
            openingBalancePaise = 2_485_000L,
            currencyCode = "INR"
        ),
        FinancialAccount(
            id = "demo-account-savings",
            name = "Savings Account",
            openingBalancePaise = 0L,
            currencyCode = "INR"
        )
    )
}
