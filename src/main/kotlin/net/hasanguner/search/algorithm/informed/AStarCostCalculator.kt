package net.hasanguner.search.algorithm.informed

import net.hasanguner.search.CostCalculator
import net.hasanguner.search.datastructure.Node

class AStarCostCalculator : CostCalculator {
    override fun calculate(parent: Node, target: Node, edgeCost: Int) =
        target.heuristic + edgeCost + parent.cost -
                (parent.heuristic.takeIf { parent.cost != 0 } ?: 0)
}