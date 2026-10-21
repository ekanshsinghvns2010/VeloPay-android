
package com.volbasty.velopay.domain.model

data class FinancialAccount(
    val id: String,
    val name: String,
    val openingBalancePaise: Long,
    val currencyCode: String = "INR",
    val isIncludedInTotal: Boolean = true
) {
    init {
        require(id.isNotBlank()) {
            "Account ID cannot be blank."
        }
        require(name.isNotBlank()) {
            "Account name cannot be blank."
        }
        require(currencyCode.matches(Regex("[A-Z]{3}"))) {
            "Currency code must contain three uppercase letters."
        }
    }
}
