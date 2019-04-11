package net.hasanguner.search.algorithm

import net.hasanguner.search.Search
import net.hasanguner.search.algorithm.informed.AStarSearch
import net.hasanguner.search.algorithm.informed.GreedySearch
import net.hasanguner.search.algorithm.uninformed.BreadthFirstSearch
import net.hasanguner.search.algorithm.uninformed.DepthFirstSearch
import net.hasanguner.search.algorithm.uninformed.UniformCostSearch

object SearchAlgorithmFactory {

    private val algorithmMap: Map<SearchAlgorithm, () -> Search> = mapOf(
        SearchAlgorithm.DFS to ::DepthFirstSearch,
        SearchAlgorithm.BFS to ::BreadthFirstSearch,
        SearchAlgorithm.UCS to ::UniformCostSearch,
        SearchAlgorithm.GREEDY to ::GreedySearch,
        SearchAlgorithm.ASTAR to ::AStarSearch
    )

    @JvmStatic
    fun create(algorithm: SearchAlgorithm): Search =
        algorithmMap[algorithm]?.invoke()
            ?: throw SearchAlgorithmNotFoundException(algorithm)
}
