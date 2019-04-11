package net.hasanguner.search.algorithm.informed

import net.hasanguner.search.AbstractSearch
import net.hasanguner.search.CostCalculator
import net.hasanguner.search.datastructure.Node
import java.util.*

class GreedySearch : AbstractSearch() {

    override val fringe: Queue<Node> = PriorityQueue()

    override val costCalculator: CostCalculator =
        GreedyCostCalculator()

}