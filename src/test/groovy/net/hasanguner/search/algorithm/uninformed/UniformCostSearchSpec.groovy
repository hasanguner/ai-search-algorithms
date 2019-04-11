package net.hasanguner.search.algorithm.uninformed

import net.hasanguner.search.Search
import net.hasanguner.search.datastructure.GraphNode
import net.hasanguner.search.graph.GermanySearchGraph
import net.hasanguner.search.graph.RomaniaSearchGraph
import spock.lang.Specification

class UniformCostSearchSpec extends Specification {

    private Search search

    def setup() {
        search = new UniformCostSearch()
    }

    def "search attempt to unreachable node"() {
        given:
        def node1 = new GraphNode("1")
        def node2 = new GraphNode("2")
        def node3 = new GraphNode("3")
        def node4 = new GraphNode("4")
        def node5 = new GraphNode("5")
        def node6 = new GraphNode("6")
        node1.addEdge(5, node2)
        node1.addEdge(8, node3)
        node3.addEdge(3, node4)
        node3.addEdge(20, node5)
        node4.addEdge(9, node5)
        when:
        def result = search.search(node1, node6)
        then:
        result != null
        result.explored != null
        result.explored.size() == 5
        println "EXPLORED : ${result.explored.collect { "$it.id($it.cost)" }}"
        result.path != null
        println "PATH : ${result.path*.id}"
        result.path.size() == 1
        node6 == result.path[0]
    }

    def "search attempt from arad to bucharest"() {
        given:
        def graph = new RomaniaSearchGraph()
        when:
        def result = search.search(graph.arad, graph.bucharest)
        then:
        result != null
        result.explored != null
        println "EXPLORED : ${result.explored.collect { "$it.id($it.cost)" }}"
        result.path != null
        println "PATH : ${result.path*.id}"
        result.path.size() == 5
        with(graph) {
            result.path.containsAll([arad, sibiu, rimnicu, pitesti, bucharest])
        }
    }

    def "search attempt from frankfurt to munchen"() {
        given:
        def graph = new GermanySearchGraph()
        when:
        def result = search.search(graph.frankfurt, graph.munchen)
        then:
        result != null
        result.explored != null
        println "EXPLORED : ${result.explored.collect { "$it.id($it.cost)" }}"
        result.path != null
        println "PATH : ${result.path*.id}"
        result.path.size() == 5
        with(graph) {
            result.path.containsAll([frankfurt, mannheim, karisruhe, augsburg, munchen])
        }
    }

}

