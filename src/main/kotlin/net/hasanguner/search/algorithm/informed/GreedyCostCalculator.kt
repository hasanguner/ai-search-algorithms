package net.hasanguner.search.algorithm.informed

import net.hasanguner.search.CostCalculator
import net.hasanguner.search.datastructure.Node

class GreedyCostCalculator : CostCalculator {
    override fun calculate(parent: Node, target: Node, edgeCost: Int): Int =
        target.heuristic
}
