package net.hasanguner.search.algorithm.uninformed

import net.hasanguner.search.AbstractSearch
import net.hasanguner.search.CostCalculator
import net.hasanguner.search.datastructure.Node
import java.util.*

class UniformCostSearch : AbstractSearch() {
    override val fringe: Queue<Node> = PriorityQueue()
    override val costCalculator: CostCalculator =
        UCSCostCalculator()
}