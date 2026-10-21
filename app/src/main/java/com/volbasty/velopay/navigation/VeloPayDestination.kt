
package com.volbasty.velopay.navigation

enum class VeloPayDestination(
    val title: String,
    val label: String
) {
    HOME(
        title = "Your financial overview",
        label = "Home"
    ),
    ACTIVITY(
        title = "Your activity",
        label = "Activity"
    ),
    PLAN(
        title = "Your financial plan",
        label = "Plan"
    ),
    INSIGHTS(
        title = "Your insights",
        label = "Insights"
    );

    companion object {
        val bottomNavigationItems: List<VeloPayDestination>
            get() = listOf(HOME, ACTIVITY, PLAN, INSIGHTS)
    }
}
