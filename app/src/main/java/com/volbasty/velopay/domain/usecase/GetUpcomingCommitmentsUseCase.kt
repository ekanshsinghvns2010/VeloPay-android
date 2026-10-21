
package com.volbasty.velopay.domain.usecase

import com.volbasty.velopay.domain.model.DemoCommitment

class GetUpcomingCommitmentsUseCase {

    /**
     * Returns unpaid commitments due between now and the
     * inclusive end of the requested window.
     *
     * The result is sorted by due date, earliest first.
     */
    operator fun invoke(
        commitments: List<DemoCommitment>,
        nowEpochMillis: Long,
        daysAhead: Int = 30
    ): List<DemoCommitment> {
        require(daysAhead >= 0) {
            "daysAhead cannot be negative."
        }

        val windowMillis = Math.multiplyExact(
            daysAhead.toLong(),
            MILLIS_PER_DAY
        )

        val endEpochMillis = Math.addExact(
            nowEpochMillis,
            windowMillis
        )

        return commitments
            .asSequence()
            .filterNot { it.isPaid }
            .filter {
                it.dueDateEpochMillis >= nowEpochMillis &&
                    it.dueDateEpochMillis <= endEpochMillis
            }
            .sortedBy { it.dueDateEpochMillis }
            .toList()
    }

    private companion object {
        const val MILLIS_PER_DAY = 86_400_000L
    }
}
