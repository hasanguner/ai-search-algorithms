package net.hasanguner.search.algorithm

import net.hasanguner.search.algorithm.informed.AStarSearch
import net.hasanguner.search.algorithm.informed.GreedySearch
import net.hasanguner.search.algorithm.uninformed.BreadthFirstSearch
import net.hasanguner.search.algorithm.uninformed.DepthFirstSearch
import net.hasanguner.search.algorithm.uninformed.UniformCostSearch
import spock.lang.Specification
import spock.lang.Unroll

class SearchAlgorithmFactorySpec extends Specification {

    @Unroll
    def "factory should create #concreteClass.simpleName when #algorithm provided"() {
        expect:
        SearchAlgorithmFactory.create(algorithm).class == concreteClass
        where:
        algorithm              || concreteClass
        SearchAlgorithm.BFS    || BreadthFirstSearch.class
        SearchAlgorithm.DFS    || DepthFirstSearch.class
        SearchAlgorithm.UCS    || UniformCostSearch.class
        SearchAlgorithm.GREEDY || GreedySearch.class
        SearchAlgorithm.ASTAR  || AStarSearch.class
    }
}
