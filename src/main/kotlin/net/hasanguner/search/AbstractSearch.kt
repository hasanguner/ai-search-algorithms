package net.hasanguner.search

import net.hasanguner.search.datastructure.Node
import java.util.*

abstract class AbstractSearch : Search {

    abstract val fringe: Queue<Node>

    abstract val costCalculator: CostCalculator

    override fun search(root: Node, goal: Node): SearchResult =
        search(fringe.apply { add(root) }, mutableSetOf(), goal)
            .let { SearchResult(goal.getShortestPath(), it) }

    private tailrec fun search(
        fringe: Queue<Node>,
        explored: MutableSet<Node>,
        goal: Node
    ): Set<Node> =
        if (fringe.isEmpty()) explored
        else {
            val node = fringe.remove()
            if (node == goal) {
                goal.apply {
                    parent = node.parent
                    cost = node.cost
                }
                explored.apply { add(node) }
            } else {
                search(
                    fringe.apply { addAdjacencies(node, explored) },
                    explored.apply { add(node) },
                    goal
                )
            }
        }

    private fun Queue<Node>.addAdjacencies(parentNode: Node, explored: MutableSet<Node>): Boolean {
        val nodeCosts = parentNode.adjacencies.map {
            it.target to costCalculator.calculate(parentNode, it.target, it.cost)
        }.toMap()

        parentNode.adjacencies
            .filter { it.target in this }
            .filter { nodeCosts[it.target]!! < it.target.cost }
            .map {
                it.target.apply {
                    parent = parentNode
                    cost = nodeCosts[this]!!
                }
            }.also { removeAll(it) }
            .also { addAll(it) }

        return parentNode.adjacencies
            .filterNot { adjacency -> adjacency.target in explored }
            .map { adjacency ->
                adjacency.target.apply {
                    parent = parentNode
                    cost = nodeCosts[this]!!
                }
            }.let { addAll(it) }
    }

}
