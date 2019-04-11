package net.hasanguner.search.graph

import net.hasanguner.search.datastructure.GraphNode

class RomaniaSearchGraph {

    def arad = new GraphNode("Arad", 366)
    def zerind = new GraphNode("Zerind", 374)
    def oradea = new GraphNode("Oradea", 380)
    def sibiu = new GraphNode("Sibiu", 253)
    def fagaras = new GraphNode("Fagaras", 178)
    def bucharest = new GraphNode("Bucharest", 0)
    def rimnicu = new GraphNode("Rimnicu Vicea", 193)
    def pitesti = new GraphNode("Pitesti", 98)
    def timisoara = new GraphNode("Timisoara", 329)
    def lugoj = new GraphNode("Lugoj", 244)
    def mehadia = new GraphNode("Mehadia", 241)
    def dobreta = new GraphNode("Dobreta", 242)
    def craiova = new GraphNode("Craiova", 160)

    RomaniaSearchGraph() {
        arad.addEdge(75, zerind)
        zerind.addEdge(71, oradea)
        oradea.addEdge(151, sibiu)
        arad.addEdge(140, sibiu)
        arad.addEdge(118, timisoara)
        timisoara.addEdge(111, lugoj)
        lugoj.addEdge(70, mehadia)
        mehadia.addEdge(75, dobreta)
        dobreta.addEdge(120, craiova)
        craiova.addEdge(146, rimnicu)
        craiova.addEdge(138, pitesti)
        sibiu.addEdge(99, fagaras)
        fagaras.addEdge(211, bucharest)
        sibiu.addEdge(80, rimnicu)
        rimnicu.addEdge(97, pitesti)
        pitesti.addEdge(101, bucharest)
    }

}
