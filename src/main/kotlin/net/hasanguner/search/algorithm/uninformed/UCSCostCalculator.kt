package net.hasanguner.search.algorithm.uninformed

import net.hasanguner.search.CostCalculator
import net.hasanguner.search.datastructure.Node

class UCSCostCalculator : CostCalculator {
    override fun calculate(parent: Node, target: Node, edgeCost: Int): Int =
        parent.cost + edgeCost
}
