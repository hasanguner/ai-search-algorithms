package net.hasanguner.search

import net.hasanguner.search.datastructure.Node

interface CostCalculator {
    fun calculate(parent: Node, target: Node, edgeCost: Int): Int
}
