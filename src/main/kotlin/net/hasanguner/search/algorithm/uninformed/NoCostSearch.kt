package net.hasanguner.search.algorithm.uninformed

import net.hasanguner.search.AbstractSearch
import net.hasanguner.search.CostCalculator

abstract class NoCostSearch : AbstractSearch() {
    override val costCalculator: CostCalculator =
        NoCostCalculator()
}