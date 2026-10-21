
package com.volbasty.velopay.core.format

import java.text.NumberFormat
import java.util.Locale

object MoneyFormatter {

    private val indianLocale = Locale("en", "IN")

    /**
     * Formats an amount stored in paise as Indian rupees.
     * Example: 2485000 paise -> ₹24,850.00
     */
    fun formatRupees(amountPaise: Long): String {
        val formatter = NumberFormat.getCurrencyInstance(indianLocale)
        formatter.currency = java.util.Currency.getInstance("INR")
        formatter.minimumFractionDigits = 2
        formatter.maximumFractionDigits = 2

        return formatter.format(amountPaise / 100.0)
    }

    /**
     * Formats whole rupees without decimal digits.
     * Example: 2485000 paise -> ₹24,850
     */
    fun formatWholeRupees(amountPaise: Long): String {
        val formatter = NumberFormat.getCurrencyInstance(indianLocale)
        formatter.currency = java.util.Currency.getInstance("INR")
        formatter.minimumFractionDigits = 0
        formatter.maximumFractionDigits = 0

        return formatter.format(amountPaise / 100.0)
    }
}
